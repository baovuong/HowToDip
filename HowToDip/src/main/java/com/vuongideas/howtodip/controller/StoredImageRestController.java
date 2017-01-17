package com.vuongideas.howtodip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image/stored")
public class StoredImageRestController {
    
    public ResponseEntity<String> uploadImage() {
        return new ResponseEntity<String>("not made yet", HttpStatus.NOT_IMPLEMENTED);
    }
}
