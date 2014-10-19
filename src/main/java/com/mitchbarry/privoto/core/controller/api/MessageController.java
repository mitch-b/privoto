package com.mitchbarry.privoto.core.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mitchbarry.privoto.core.interfaces.IMessageService;
import com.mitchbarry.privoto.core.model.Message;
import com.mitchbarry.privoto.core.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/17/14.
 */
@RestController
public class MessageController {

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private IMessageService msgService;

    @Autowired
    public MessageController(IMessageService messageService) {
        this.msgService = messageService;
    }

    @Value("${storage.dir}")
    private String uploadDirectory;

    @RequestMapping(value = "/api/message", method = RequestMethod.GET)
    public String getMessageList() {
        // TODO: get only for user asking
        ArrayList<Message> messages = msgService.getMessages();
        return gson.toJson(messages);
    }

    @RequestMapping(value = "/api/message/image", method = RequestMethod.POST)
    public String postImageMessage(
            @RequestParam(value = "image", required = true, defaultValue = "") MultipartFile image,
            @RequestParam(value = "decay", required = false, defaultValue = "-1") long decay) {
        Message msg = new Message();

        if (image.isEmpty()) {
            msg.setErrorMessage("ERROR: File contents empty");
            return gson.toJson(msg);
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

        return gson.toJson(msg);
    }

    @RequestMapping(value = "/api/message/text", method = RequestMethod.POST)
    public String postTextMessage() {
        Message msg = new Message();

        return gson.toJson(msg);
    }
}
