CREATE TABLE ErrorLog (
    ErrorMessage VARCHAR2(4000),
    LogTime TIMESTAMP DEFAULT SYSTIMESTAMP
);
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account_id;
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account_id;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Transfer Error: ' || SQLERRM);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percent     IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_employee_id;
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee not found.');
    END IF;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('UpdateSalary Error: ' || SQLERRM);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_age         IN NUMBER,
    p_balance     IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, Age, Balance)
    VALUES (p_customer_id, p_name, p_age, p_balance);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('AddCustomer Error: Duplicate ID - ' || p_customer_id);
        COMMIT;
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('AddCustomer Error: ' || SQLERRM);
        COMMIT;
END;
/
