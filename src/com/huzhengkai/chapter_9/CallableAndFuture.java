package com.huzhengkai.chapter_9;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by root on 2017/12/25.
 */

public class CallableAndFuture
{
    public static void main(String[] args)
    {
        Callable<Integer> callable = new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                Thread.sleep(5000);// 可能做一些事情
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try
        {
            //如果没有执行完，get方法会等待
            System.out.println(future.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}

