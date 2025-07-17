DECLARE
    CURSOR trans_cursor IS
        SELECT CustomerID, TransactionID, Amount, TransactionDate
        FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR rec IN trans_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CustomerID || 
                             ', Transaction ID: ' || rec.TransactionID || 
                             ', Amount: ' || rec.Amount || 
                             ', Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID
        FROM Accounts;
    v_fee NUMBER := 100;
BEGIN
    FOR rec IN acc_cursor LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID
        FROM Loans;
    v_new_rate NUMBER := 7.5;
BEGIN
    FOR rec IN loan_cursor LOOP
        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/
