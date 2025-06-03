DELIMITER $$

CREATE TRIGGER trg_person_insert
AFTER INSERT ON Person
FOR EACH ROW
BEGIN
    INSERT INTO Person_audit (
        id, first_name, last_name, mobile_number, email_id, dob,
        inserted_date, updated_date, inserted_by, updated_by,
        operation_type
    )
    VALUES (
        NEW.id, NEW.first_name, NEW.last_name, NEW.mobile_number,
        NEW.email_id, NEW.dob,
        NEW.inserted_date, NEW.updated_date,
        NEW.inserted_by, NEW.updated_by,
        'INSERT'
    );
END $$

DELIMITER ;
