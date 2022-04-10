package ru.kpfu.itis.group101.imamov.c2.asd.dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class GenerateCSVDataset {

    public void writeValues(int size, Path path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(path.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(',');
        sb.append("value");
        sb.append('\n');

        for (int i = 0; i < size; i++) {
            sb.append(i);
            sb.append(',');
            sb.append((int)(Math.random()*1000000));
            sb.append('\n');
        }

        writer.write(sb.toString());
        writer.close();
    }
}
