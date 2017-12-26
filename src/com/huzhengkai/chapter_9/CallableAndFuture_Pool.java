package com.huzhengkai.chapter_9;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by root on 2017/12/25.
 */
public class CallableAndFuture_Pool
{
    public static void main(String[] args)
    {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>()
        {
            public Integer call() throws Exception
            {
                Thread.sleep(5000);// 可能做一些事情
                return new Random().nextInt(100);
            }
        });
        try
        {
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
