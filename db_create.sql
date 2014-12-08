CREATE DATABASE `privoto` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `privoto`;

-- tables
-- Table: friendships
CREATE TABLE friendships (
    user_id int    NOT NULL ,
    friend_id int    NOT NULL ,
    CONSTRAINT friendships_pk PRIMARY KEY (user_id,friend_id)
);

-- Table: message_data
CREATE TABLE message_data (
    message_id int    NOT NULL ,
    text varchar(140)    NOT NULL ,
    data blob    NULL ,
    CONSTRAINT message_data_pk PRIMARY KEY (message_id)
);

-- Table: messages
CREATE TABLE messages (
    message_id int    NOT NULL ,
    sender_id int    NOT NULL ,
    recipient_id int    NOT NULL ,
    CONSTRAINT messages_pk PRIMARY KEY (message_id)
);

-- Table: users
CREATE TABLE users (
    user_id int    NOT NULL ,
    email varchar(200)    NOT NULL ,
    display_name varchar(200)    NOT NULL ,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);





-- foreign keys
-- Reference:  friendships_users (table: friendships)


ALTER TABLE friendships ADD CONSTRAINT friendships_users_user FOREIGN KEY friendships_users (user_id)
    REFERENCES users (user_id);
-- Reference:  friendships_users (table: friendships)


ALTER TABLE friendships ADD CONSTRAINT friendships_users_friend FOREIGN KEY friendships_users (friend_id)
    REFERENCES users (user_id);
-- Reference:  message_data_messages (table: message_data)


ALTER TABLE message_data ADD CONSTRAINT message_data_messages FOREIGN KEY message_data_messages (message_id)
    REFERENCES messages (message_id);
-- Reference:  messages_users_sender (table: messages)


ALTER TABLE messages ADD CONSTRAINT `messages_users_sender` FOREIGN KEY (`sender_id`)
    REFERENCES `privoto`.`users` (`user_id`);
-- Reference:  messages_users_recipient (table: messages)


ALTER TABLE messages ADD CONSTRAINT `messages_users_recipient` FOREIGN KEY (`recipient_id`)
    REFERENCES `privoto`.`users` (`user_id`);


-- End of file.
