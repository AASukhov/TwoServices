package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FileResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String filename;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int size;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
}
