package com.vuongideas.howtodip.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vuongideas.howtodip.model.ImageParameters;

@RestController
@RequestMapping("/api/image/input")
public class InputImageRestController {
    
    @RequestMapping(value = "/greyscale", method = RequestMethod.POST)
    public byte[] generateGreyscale(@RequestBody ImageParameters parameters) {
        ByteArrayInputStream stream = new ByteArrayInputStream(parameters.getImageData());
        
        try {
            BufferedImage image = ImageIO.read(stream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
        
    }
}
