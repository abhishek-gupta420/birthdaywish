CREATE TABLE bdaywish_message_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    operation_type VARCHAR(10),
    id INT,
    birthday_wish_message VARCHAR(500),
    operation_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
