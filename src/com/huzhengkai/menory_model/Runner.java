package com.huzhengkai.menory_model;

/**
 * Created by root on 2017/12/13.
 */
public class Runner extends Thread
{
    private boolean quit = false;
    public void run()
    {
        while(!quit)
        {
            System.out.println("Running");
        }
        System.out.println("Done");
    }
    public void shutdown()
    {
        quit = true;
    }
}
