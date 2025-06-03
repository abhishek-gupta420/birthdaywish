CREATE TRIGGER trg_bdaywish_message_insert
AFTER INSERT ON bdaywish_message
FOR EACH ROW
INSERT INTO bdaywish_message_audit (operation_type, id, birthday_wish_message)
VALUES ('INSERT', NEW.id, NEW.birthday_wish_message);
