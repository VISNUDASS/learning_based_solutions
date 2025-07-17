SET SERVEROUTPUT ON;

DECLARE
    CURSOR senior_cursor IS
        SELECT CustomerID, InterestRate
        FROM Customers
        WHERE Age > 60;

    CURSOR vip_cursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;

    CURSOR loan_cursor IS
        SELECT L.LoanID, L.CustomerID, L.DueDate, C.Name
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN senior_cursor LOOP
        UPDATE Customers
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    FOR rec IN vip_cursor LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    FOR rec IN loan_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Loan ID ' || rec.LoanID || 
                             ', Customer: ' || rec.Name || 
                             ', Due: ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;

    COMMIT;
END;
/
