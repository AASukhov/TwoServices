package com.example.demo.repository;

import com.example.demo.entity.File;
import com.example.demo.model.FileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, String> {

    FileResponse findByFilename(String filename);
    File findById(int id);
    List<File> findAll();
}
