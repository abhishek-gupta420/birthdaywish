DELIMITER $$

CREATE TRIGGER trg_person_delete
AFTER DELETE ON Person
FOR EACH ROW
BEGIN
    INSERT INTO Person_audit (
        id, first_name, last_name, mobile_number, email_id, dob,
        inserted_date, updated_date, inserted_by, updated_by,
        operation_type
    )
    VALUES (
        OLD.id, OLD.first_name, OLD.last_name, OLD.mobile_number,
        OLD.email_id, OLD.dob,
        OLD.inserted_date, OLD.updated_date,
        OLD.inserted_by, OLD.updated_by,
        'DELETE'
    );
END $$

DELIMITER ;
