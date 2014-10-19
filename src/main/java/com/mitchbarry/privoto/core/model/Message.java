package com.mitchbarry.privoto.core.model;

import com.google.gson.annotations.Expose;

import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/17/14.
 */
public class Message {
    public Message() {
        this.id = null;
        this.sender = null;
        this.receiver = null;
    }

    @Expose
    private UUID id;
    @Expose
    private UUID sender;
    @Expose
    private UUID receiver;

    @Expose
    private MessageType type;

    @Expose
    private String url;

    private byte[] data;

    private String errorMessage;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public void setReceiver(UUID receiver) {
        this.receiver = receiver;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
