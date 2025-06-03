CREATE TABLE Person_audit (
    id BIGINT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    mobile_number VARCHAR(20),
    email_id VARCHAR(255),
    dob DATE,
    inserted_date DATETIME,
    updated_date DATETIME,
    inserted_by VARCHAR(255),
    updated_by VARCHAR(255),
    operation_type VARCHAR(10), -- INSERT, UPDATE, DELETE
    operation_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);
