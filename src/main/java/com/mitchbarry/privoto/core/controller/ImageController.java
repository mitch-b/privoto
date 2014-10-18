package com.mitchbarry.privoto.core.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mitchell Barry on 10/16/14.
 */
@Controller
public class ImageController {

    @Autowired
    ServletContext servletContext;

    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        InputStream in = servletContext.getResourceAsStream("glass.jpeg");
        return IOUtils.toByteArray(in);
    }

}
