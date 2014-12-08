package com.mitchbarry.privoto.core.dao;

import com.mitchbarry.privoto.core.model.MessageData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Mitchell Barry on 12/7/14.
 */
@Repository
public class MessageDataDAOImpl implements MessageDataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public MessageData getMessageData(int id) {
        MessageData data = (MessageData) getCurrentSession().get(MessageData.class, id);
        return data;
    }

    @Override
    public MessageData postMessageData(MessageData data) {
        // TODO: implement
        return data;
    }
}
