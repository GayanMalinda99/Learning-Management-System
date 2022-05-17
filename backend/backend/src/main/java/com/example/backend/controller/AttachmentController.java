package com.example.backend.controller;

import com.example.backend.filehandling.Attachment;
import com.example.backend.filehandling.model.ResponseData;
import com.example.backend.service.AttachmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestPart("file")MultipartFile file) {
        Attachment attachment = null;
    }
}
