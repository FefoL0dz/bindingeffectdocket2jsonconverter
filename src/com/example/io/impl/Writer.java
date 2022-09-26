package com.loganima.io.impl;

import com.google.gson.Gson;
import com.loganima.io.base.IOHandler;
import com.loganima.io.base.IOProtocol;
import com.loganima.models.Docket;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer extends IOHandler implements IOProtocol.IWritable<List<Docket>> {

    private List<Docket> writable;

    public Writer(List<Docket> writable) {
        super(OUTPUT_FILE_PATH);
        this.writable = writable;
    }

    @Override
    public void writeFile(List<Docket> obj, String fileName) {
        Gson gson = new Gson();
        try {
            String json = gson.toJson(obj);
            FileWriter writer = new FileWriter(fileName);
            writer.write(json);
            writer.close();

            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        writeFile(this.writable, this.filePath);
    }
}
