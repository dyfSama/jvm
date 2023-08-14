package com.dyf.jvm.refrences;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 软引用主要用于缓存
 * </p>
 *
 * @author duyafei
 * @since 2023-08-14
 */
public class Demo_02_PhamtomReference {
    public static void main(String[] args) {
        SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(sr.get());
        System.gc();
        // 给时间垃圾回收
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sr.get());

        // 添加JVM 参数 -Xmx20M
        // 再分配一个数组,heap将装下了, 这时候系统就会进行垃圾回收, 先回收一次, 如果不够, 就会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 12];
        System.out.println(sr.get());

    }
}
