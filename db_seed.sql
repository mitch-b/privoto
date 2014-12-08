INSERT INTO `privoto`.`users` (`user_id`, `email`, `display_name`) VALUES ('1', 'test1@test.com', 'test1');
INSERT INTO `privoto`.`users` (`user_id`, `email`, `display_name`) VALUES ('2', 'test2@test.com', 'test2');

INSERT INTO `privoto`.`friendships` (`user_id`, `friend_id`) VALUES ('1', '2');
INSERT INTO `privoto`.`friendships` (`user_id`, `friend_id`) VALUES ('2', '1');

INSERT INTO `privoto`.`messages` (`message_id`, `sender_id`, `recipient_id`) VALUES ('1', '1', '2');
INSERT INTO `privoto`.`messages` (`message_id`, `sender_id`, `recipient_id`) VALUES ('2', '1', '2');
INSERT INTO `privoto`.`messages` (`message_id`, `sender_id`, `recipient_id`) VALUES ('3', '2', '1');

INSERT INTO `privoto`.`message_data` (`message_id`, `text`) VALUES ('1', 'Hello, test2!');
INSERT INTO `privoto`.`message_data` (`message_id`, `text`) VALUES ('2', 'Did you get my message?');
INSERT INTO `privoto`.`message_data` (`message_id`, `text`) VALUES ('3', 'No I didn\'t...');
