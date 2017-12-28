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
        try
        {
            threadPool.shutdown();
            // 一个是timeout即超时时间，另一个是unit即时间单位
            // (所有的任务都结束的时候，返回TRUE)
            if (!threadPool.awaitTermination(360, TimeUnit.SECONDS))
            {
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                threadPool.shutdownNow();
            }
        }
        catch (InterruptedException e)
        {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            threadPool.shutdownNow();
        }
        System.out.println("end");
    }
}
