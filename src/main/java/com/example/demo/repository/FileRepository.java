package com.example.demo.repository;

import com.example.demo.entity.File;
import com.example.demo.model.FileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, String> {

    FileResponse findByFilename(String filename);
    List<File> findAll();

    @Modifying
    @Query ("update File f set f.filename = :newName where f.filename = :filename")
    void editFilename (@Param ("filename") String filename, @Param("newName") String newName);
}
