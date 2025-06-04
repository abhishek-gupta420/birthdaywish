INSERT INTO email_config (host, port, username, password, from_address, protocol, auth_enabled, starttls_enabled)
VALUES (
  'smtp.gmail.com', 587, 'your_email@gmail.com', 'your_app_password',
  'your_email@gmail.com', 'smtp', true, true
);