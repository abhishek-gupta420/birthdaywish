CREATE TABLE email_config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    host VARCHAR(100),
    port INT,
    username VARCHAR(100),
    password VARCHAR(100),
    from_address VARCHAR(100),
    protocol VARCHAR(20),
    auth_enabled BOOLEAN,
    starttls_enabled BOOLEAN
);
