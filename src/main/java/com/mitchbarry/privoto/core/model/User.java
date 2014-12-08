package com.mitchbarry.privoto.core.model;

import com.google.gson.annotations.Expose;

import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/17/14.
 */
public class User {
    public User() {
        this.id = null;
    }

    @Expose
    private UUID id;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
