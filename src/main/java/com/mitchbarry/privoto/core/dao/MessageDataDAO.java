package com.mitchbarry.privoto.core.dao;

import com.mitchbarry.privoto.core.model.MessageData;

/**
 * Created by Mitchell Barry on 12/7/14.
 */
public interface MessageDataDAO {
    public MessageData getMessageData(int id);
    public MessageData postMessageData(MessageData data);
}
