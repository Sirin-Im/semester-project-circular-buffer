package ru.kpfu.itis.group101.imamov.c2.asd;

import ru.kpfu.itis.group101.imamov.c2.asd.benchmark.Benchmark;
import ru.kpfu.itis.group101.imamov.c2.asd.dataset.GenerateCSVDataset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void start() {
        GenerateCSVDataset generator = new GenerateCSVDataset();
        Benchmark benchmark = new Benchmark();
        int[] size = new int[]{100,500,1000,5000,10000,25000,50000,100000,250000,500000,750000,1000000};
        int sizeIndex = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\PathsOfFiles"));
            try {
                String line = reader.readLine();
                while (line != null) {
                    generator.writeValues(size[sizeIndex], Paths.get(line));
                    System.out.println(Arrays.toString(benchmark.execute(size[sizeIndex], Paths.get(line))));
                    sizeIndex++;
                    if (sizeIndex == size.length) {
                        sizeIndex = 0;
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        start();




//        CircularBuffer<Integer> d = new CircularBuffer<Integer>();
//        d.offer(0);
//        d.offer(1);
//        d.offer(2);
//        System.out.println(d);
//        System.out.println(d.sizeEqualsCapacity());
//        System.out.println(d.hashCode());
    }
}
