package com.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOHandler {

    public static String readerFile(String path) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String text = "";
        String line = "";

        line = reader.readLine();
        while (line != null) {
            text = text + line + "\n";
            line = reader.readLine();
        }
        text = text.substring(0, text.length() - 1);

        reader.close();
        
        return text;
    }

    public static void createFile(String pathDest, String text) throws FileNotFoundException, IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(pathDest));

        writer.write(text);
        writer.close();
    }
}
