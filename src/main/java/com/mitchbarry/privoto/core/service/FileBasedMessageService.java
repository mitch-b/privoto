package com.mitchbarry.privoto.core.service;

import com.mitchbarry.privoto.core.interfaces.IMessageService;
import com.mitchbarry.privoto.core.model.Message;
import com.mitchbarry.privoto.core.model.MessageType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    @Override
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

    @Override
    public Message postMessage(MultipartFile image, String textMessage, long decay) {
        Message msg = new Message();

        if (image == null || image.isEmpty()) {
            msg.setErrorMessage("ERROR: File contents empty");
            return msg;
        }

        try {
            msg.setData(image.getBytes());
            msg.setId(UUID.randomUUID());
            msg.setType(MessageType.Image);

            // create storage directory
            File dir = new File(this.uploadDirectory);
            if (!dir.exists())
                dir.mkdirs();

            // create the file
            File newImage = new File(dir.getAbsolutePath() +
                    File.separator + msg.getId());

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(newImage)
            );

            stream.write(msg.getData());
            stream.close();

            msg.setErrorMessage(null);

        } catch (Exception e) {
            msg.setErrorMessage(String.format("ERROR: %s - %s", e.getMessage(), e.getStackTrace()));
        }
        return msg;
    }

}
