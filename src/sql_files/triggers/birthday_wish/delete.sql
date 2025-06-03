CREATE TRIGGER trg_bdaywish_message_delete
AFTER DELETE ON bdaywish_message
FOR EACH ROW
INSERT INTO bdaywish_message_audit (operation_type, id, birthday_wish_message)
VALUES ('DELETE', OLD.id, OLD.birthday_wish_message);
