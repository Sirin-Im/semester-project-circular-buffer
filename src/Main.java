package ru.kpfu.itis.group101.komissarov.course1.term2.hw3.task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> d = new MyQueue<>(3);
        d.offer(0);
        d.offer(1);
        d.offer(2);
        System.out.println(d);
        System.out.println(d.sizeEqualsCapacity());
        System.out.println(d.hashCode());
    }
}
