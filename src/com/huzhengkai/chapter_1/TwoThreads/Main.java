package com.huzhengkai.chapter_1.TwoThreads;

/**
 * Created by root on 2017/12/11.
 */
public class Main
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 10000; i++)
        {
            System.out.print("Good!");
        }
    }
}
