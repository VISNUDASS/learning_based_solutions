CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, Age, Balance)
        VALUES (p_id, p_name, p_age, p_balance);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, Age = p_age
        WHERE CustomerID = p_id;
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    END;
END;
/
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept NUMBER, p_salary NUMBER);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_dept NUMBER);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept NUMBER, p_salary NUMBER) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, DepartmentID, Salary)
        VALUES (p_id, p_name, p_dept, p_salary);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_dept NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, DepartmentID = p_dept
        WHERE EmployeeID = p_id;
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    END;
END;
/
CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(p_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_id NUMBER);
    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations IS
    PROCEDURE OpenAccount(p_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, AccountType, Balance, CustomerID)
        VALUES (p_id, p_type, p_balance, p_id);
    END;

    PROCEDURE CloseAccount(p_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_id;
    END;

    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
        RETURN v_total;
    END;
END;
/
