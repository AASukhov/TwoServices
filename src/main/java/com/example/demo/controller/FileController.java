package com.example.demo.controller;

import com.example.demo.model.FileResponse;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/filelist")
    public void getFileList () {
        fileService.getFileList();
    }

    @GetMapping("/list")
    public List<FileResponse> getListAllFiles(){
        return fileService.getJsonFileList();
    }
}
