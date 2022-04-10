package ru.kpfu.itis.group101.imamov.c2.asd;

import ru.kpfu.itis.group101.imamov.c2.asd.dataset.GenerateCSVDataset;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> d = new MyQueue<>(3);
        d.offer(0);
        d.offer(1);
        d.offer(2);
//        System.out.println(d);
//        System.out.println(d.sizeEqualsCapacity());
//        System.out.println(d.hashCode());


        GenerateCSVDataset generator = new GenerateCSVDataset();
        generator.writeValues(100, Paths.get("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\data\\dataset_1.csv"));
        generator.writeValues(1000, Paths.get("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\data\\dataset_2.csv"));
        generator.writeValues(10000, Paths.get("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\data\\dataset_3.csv"));
        generator.writeValues(100000, Paths.get("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\data\\dataset_4.csv"));
        generator.writeValues(1000000, Paths.get("C:\\Users\\Сирин\\IdeaProjects\\TestApp\\src\\ru\\kpfu\\itis\\group101\\imamov\\c2\\asd\\dataset\\data\\dataset_5.csv"));
    }
}
