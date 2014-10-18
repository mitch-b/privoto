package com.mitchbarry.privoto.core.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mitchbarry.privoto.core.model.Message;
import com.mitchbarry.privoto.core.model.MessageType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by Mitchell Barry on 10/17/14.
 */
@RestController
public class MessageController {

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Value("${upload.dir}")
    private String uploadDirectory;

    @RequestMapping(value = "/api/message/image", method = RequestMethod.POST)
    public String postImageMessage(@RequestParam(value = "image", required = true, defaultValue = "") MultipartFile image) {
        Message msg = new Message();

        if (image.isEmpty()) {
            return gson.toJson(msg);
        }



        try {
            byte[] file = image.getBytes();
            File dir = new File(uploadDirectory +
                    File.separator + "uploads");
            if (!dir.exists())
                dir.mkdirs();

            msg.setId(UUID.randomUUID());
            msg.setType(MessageType.Image);

            // create the file
            File newImage = new File(dir.getAbsolutePath() +
                File.separator + msg.getId());

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(newImage)
            );

            stream.write(file);

            stream.close();

        } catch (Exception e) {
            // log e
        }


        return gson.toJson(msg);
    }

    @RequestMapping(value = "/api/message/text", method = RequestMethod.POST)
    public String postTextMessage() {
        Message msg = new Message();

        return gson.toJson(msg);
    }
}
