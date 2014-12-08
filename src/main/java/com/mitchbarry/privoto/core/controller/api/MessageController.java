package com.mitchbarry.privoto.core.controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mitchbarry.privoto.core.interfaces.IMessageService;
import com.mitchbarry.privoto.core.model.Message;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * Created by Mitchell Barry on 10/17/14.
 */
@RestController
@Api(value = "messages", description = "Send and retrieve messages between users")
public class MessageController {

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private IMessageService msgService;

    @Autowired
    public MessageController(IMessageService messageService) {
        this.msgService = messageService;
    }

    @RequestMapping(value = {"/api/v1/messages"}, method = RequestMethod.GET)
    public String getMessageList_v1() {
        // TODO: get only for user asking
        ArrayList<Message> messages = msgService.getMessages();
        return gson.toJson(messages);
    }

    @RequestMapping(value = {"/api/messages", "/api/v2/messages"}, method = RequestMethod.GET)
    public String getMessageList_v2() {
        // TODO: get only for user asking
        ArrayList<Message> messages = msgService.getMessages();
        return gson.toJson(messages);
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.POST)
    public String postImageMessage(
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "decay", defaultValue = "-1") long decay) {

        Message msg = new Message();

        // configurable log endpoint here?
        msg = msgService.postMessage(image, text, decay);

        // todo: trigger messaging service for push notifications?

        return gson.toJson(msg);
    }
}
