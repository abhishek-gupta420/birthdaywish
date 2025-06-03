CREATE TRIGGER trg_bdaywish_message_update
AFTER UPDATE ON bdaywish_message
FOR EACH ROW
INSERT INTO bdaywish_message_audit (operation_type, id, birthday_wish_message)
VALUES ('UPDATE', NEW.id, NEW.birthday_wish_message);
