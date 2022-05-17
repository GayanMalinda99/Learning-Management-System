package com.example.backend.controller;

import com.example.backend.service.AttachmentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
}
