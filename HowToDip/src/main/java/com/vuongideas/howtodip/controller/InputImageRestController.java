package com.vuongideas.howtodip.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image/input")
public class InputImageRestController {
    
    @RequestMapping(value = "/greyscale", method = RequestMethod.POST)
    public ResponseEntity<byte[]> generateGreyscale(@RequestParam("file") MultipartFile file) {
        // check type, make sure it's an image
        if (file.getContentType().contains("image/")) {
            String filename = file.getOriginalFilename();
            try {
                InputStream stream = file.getInputStream();
                BufferedImage image = ImageIO.read(stream);
                
                int width = image.getWidth();
                int height = image.getHeight();
                
                for (int i=0; i<height; i++) {
                    for (int j=0; j<width; j++) {
                        Color c = new Color(image.getRGB(j, i));
                        int red = (int)(c.getRed() * 0.299);
                        int green = (int)(c.getGreen() * 0.587);
                        int blue = (int)(c.getBlue() * 0.114);
                        int rgb = red+green+blue;
                        Color newColor = new Color(rgb, rgb, rgb);
                        image.setRGB(j, i, newColor.getRGB());
                    }
                }
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                String extension = filename.substring(filename.lastIndexOf('.')+1);
                ImageIO.write(image, extension, baos);
                
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("Content-Type", file.getContentType());
                return new ResponseEntity<byte[]>(baos.toByteArray(), responseHeaders, HttpStatus.OK);
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }            
        }     
        return null;
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello() {
        return "Hello, World!";
    }
}
