package com.mitchbarry.privoto.core.service;

import com.mitchbarry.privoto.core.interfaces.IMessageService;
import com.mitchbarry.privoto.core.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/18/14.
 */
@Service
public class FileBasedMessageService implements IMessageService {

    @Value("${storage.dir}")
    private String uploadDirectory;

    @Value("${hostname}")
    private String hostname;

    @Value("${protocol}")
    private String protocol;

    public FileBasedMessageService() { }

    // TODO: deprecate once we can retrieve per-user
    public ArrayList<Message> getMessages() {
        File dir = new File(this.uploadDirectory);
        ArrayList<Message> messages = new ArrayList<>();

        if (!dir.exists())
            return messages;

        for (final File fileEntry : dir.listFiles()) {
            if (!fileEntry.isDirectory()) { // do not search recursively ... this is short-term until db
                Message msg = new Message();
                msg.setId(UUID.fromString(fileEntry.getName()));
                msg.setUrl(String.format("%s://%s/api/images/%s", protocol, hostname, msg.getId()));
                messages.add(msg);
            }
        }

        return messages;
    }
}
