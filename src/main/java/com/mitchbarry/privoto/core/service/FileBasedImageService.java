package com.mitchbarry.privoto.core.service;

import com.mitchbarry.privoto.core.interfaces.IImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.*;

/**
 * Created by Mitchell Barry on 10/18/14.
 */
@Service
public class FileBasedImageService implements IImageService {

    @Autowired
    ServletContext servletContext;

    @Value("${storage.dir}")
    private String uploadDirectory;

    public byte[] getImage(String id) {
        File inputFile = new File(
                this.uploadDirectory + File.separator + id
        );

        InputStream in = null;
        try {
            in = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (in != null)
        {
            try {
                return IOUtils.toByteArray(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
