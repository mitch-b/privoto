package com.mitchbarry.privoto.core.interfaces;

import com.mitchbarry.privoto.core.model.Message;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * Created by Mitchell Barry on 10/18/14.
 */
public interface IMessageService {

    public ArrayList<Message> getMessages();

    public Message postMessage(MultipartFile image, String textMessage, long decay);

}
