package com.mitchbarry.privoto.core.controller.api;

import com.mitchbarry.privoto.core.interfaces.IImageService;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mitchell Barry on 10/18/14.
 */
@RestController
@RequestMapping("/api/images/**")
@Api(value = "images", description = "Download images from server")
public class ImageController {

    private IImageService imageService;

    @Autowired
    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/api/images/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") String id) {
        return this.imageService.getImage(id);
    }
}
