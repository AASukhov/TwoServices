package com.example.demo.service;

import com.example.demo.entity.File;
import com.example.demo.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Slf4j
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public void getFileList () {
        for (int i = 0; i < fileRepository.findAll().size(); i++){
            System.out.println(fileToString(fileRepository.findAll().get(i)));
        }
    }

    public String fileToString(File file) {
        return "Filename: " + file.getFilename() + "\n" +
                "Size: " + file.getSize() + "\n" +
                "Date: " + file.getDate();
    }
}
