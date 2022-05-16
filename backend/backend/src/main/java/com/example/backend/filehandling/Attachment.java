package com.example.backend.filehandling;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Attachment {

    private String fileId;

    private String fileName;
    private String fileType;

    private byte[] data;
}
