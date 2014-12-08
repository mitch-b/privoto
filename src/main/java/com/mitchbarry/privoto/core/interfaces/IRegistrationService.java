package com.mitchbarry.privoto.core.interfaces;

import com.mitchbarry.privoto.core.model.User;

import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/27/14.
 */
public interface IRegistrationService {
    public User create(String info); // todo: add proper fields later

    public boolean delete(UUID id);

    public User get(UUID id);

    public User update(User user);
}
