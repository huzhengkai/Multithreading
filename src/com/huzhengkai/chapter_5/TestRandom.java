package com.huzhengkai.chapter_5;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by root on 2017/12/20.
 */
public class TestRandom
{
    public static void main(String[] args)
    {

        // 案例2
        // 对于种子相同的Random对象，生成的随机数序列是一样的。
        Random ran1 = new Random(10);
        System.out.println("使用种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(ran1.nextInt(10) + " ");
        }
        System.out.println();
        Random ran2 = new Random(10);
        System.out.println("使用另一个种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(ran2.nextInt(10) + " ");
        }
        /**
         * 输出结果为：
         *
         * 使用种子为10的Random对象生成[0,10)内随机整数序列:
         * 3 0 3 0 6 6 7 8 1 4
         * 使用另一个种子为10的Random对象生成[0,10)内随机整数序列:
         * 3 0 3 0 6 6 7 8 1 4
         *
         */

        // 案例3
        // 在没带参数构造函数生成的Random对象的种子缺省是当前系统时间的毫秒数。
        Random r3 = new Random();
        System.out.println();
        System.out.println("使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(r3.nextInt(10) + " ");
        }
        /**
         * 输出结果为：
         *
         * 使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列
         * 1 1 0 4 4 2 3 8 8 4
         *
         */

        // 另外，直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
        ArrayList list = new TestRandom().getDiffNO(10);
        System.out.println();
        System.out.println("产生的n个不同的随机数：" + list);
    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     *
     * @param n
     * @return
     */
    public ArrayList getDiffNO(int n)
    {
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++)
        {
            do
            {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }
}
