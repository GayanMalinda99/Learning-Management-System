package com.example.backend.service;

import com.example.backend.filehandling.Attachment;
import com.example.backend.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) {
        return null;
    }
}
