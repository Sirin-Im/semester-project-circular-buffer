package ru.kpfu.itis.group101.imamov.c2.asd.benchmark;

import ru.kpfu.itis.group101.imamov.c2.asd.CircularBuffer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;


public class Benchmark {
    private double[] time = new double[3];

    public double[] execute(int size, Path path) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(size);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                buffer.offer(Integer.valueOf(data[1]));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        CircularBuffer<Integer> buffer1 = buffer;
        CircularBuffer<Integer> buffer2 = buffer;
        CircularBuffer<Integer> buffer3 = buffer;

        long timeOfRemoveBefore = System.nanoTime();
        buffer1.remove();
        long timeOfRemoveAfter = System.nanoTime();
        time[0] = (double)(timeOfRemoveAfter - timeOfRemoveBefore)/1000000;

        long timeOfOfferBefore = System.nanoTime();
        buffer2.offer((int)(Math.random()*10000));
        long timeOfOfferAfter = System.nanoTime();
        time[1] = (double)(timeOfOfferAfter-timeOfOfferBefore)/1000000;

        long timeOfPeekBefore = System.nanoTime();
        buffer3.peek();
        long timeOfPeekAfter = System.nanoTime();
        time[2] = (double) (timeOfPeekAfter-timeOfPeekBefore)/1000000;

        return time;
    }
}
