package com.mitchbarry.privoto.core.model;

import com.mysql.jdbc.Blob;

import javax.persistence.*;

/**
 * Created by Mitchell Barry on 12/7/14.
 */
@Entity
@Table(name="message_data")
public class MessageData {
    @Id
    @Column(name="message_id")
    private int messageId;

    private String text;

    @Lob
    private Blob data;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }
}
