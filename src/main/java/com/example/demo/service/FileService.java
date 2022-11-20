package com.example.demo.service;

import com.example.demo.entity.File;
import com.example.demo.exceptions.NoSuchFileException;
import com.example.demo.model.FileResponse;
import com.example.demo.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public FileResponse getByFilename(String filename) throws NoSuchFileException{
        return fileRepository.findByFilename(filename);
    }

    public List<FileResponse> getJsonFileList(){
        return fileRepository.findAll().stream()
                .map(f -> new FileResponse (f.getFilename(),f.getSize(),f.getDate()))
                .collect(Collectors.toList());
    }

    public void getFileList () {
        List<File> list = fileRepository.findAll();
        for (int i = 0; i < list.size(); i++){
            fileToString(list.get(i));
            System.out.println(fileToString(list.get(i)));
        }
    }
    public String fileToString(File file) {
        return "Filename: " + file.getFilename() + "\n" +
                "Size: " + file.getSize() + "\n" +
                "Date: " + file.getDate();
    }

    public boolean searchingForFilename(String filename) throws NoSuchFileException {
        List<File> fileList = fileRepository.findAll();
        boolean k = false;
        for (File f: fileList) {
            if (f.getFilename().equals(filename)) {
                k = true;
                break;
            }
        }
        if (!k) {
            throw new NoSuchFileException("File with such name is not exist");
        }
        return true;
    }
}
