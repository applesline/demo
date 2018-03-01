package org.applesline.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 19位长度ID生成策略（Java数据类型中long的最大长度是19位）
 *
 * 运算思路：15位时间戳：yyMMddHHmmssSSS + 自增长4位长度，自增数大于9999时重新以1000为开始
 *
 * 注意：跑main方法测试时，如果一毫秒可以调用generateId的次数如果多于自增长度时，则会出现ID重复，出现这种情况时建议设置较大的自增数区间
 *
 * created by liuyaping on 2018/3/1
 */
public class IdGenerator {

    private static final int minIncrementNum = 1;
    private static final int maxIncrementNum = 10000;
    private static AtomicInteger atomicId = new AtomicInteger(minIncrementNum);
    private static final Set<Long> generatorIds = new CopyOnWriteArraySet<>();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");

    public static Long generateId() {
        String sid = simpleDateFormat.format(new Date());
        int aid = atomicId.getAndIncrement();
        atomicId.compareAndSet(maxIncrementNum,minIncrementNum);
        System.out.println(Long.parseLong(sid + aid));
        return Long.parseLong(sid + aid);
    }

    public static void main(String[] args) throws InterruptedException {
        int tSize = 200;
        final CountDownLatch countDownLatch = new CountDownLatch(tSize);
        ExecutorService executorService = Executors.newFixedThreadPool(tSize);
        for(int i=0;i<tSize;i++) {
            executorService.execute(()->{
                generatorIds.add(IdGenerator.generateId());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        // 此处添加若干自定义ID用于校验ID是否重复生成
        generatorIds.add(100L);
        generatorIds.add(1010L);
        generatorIds.add(1002L);
        generatorIds.add(100L);
        // 查看生成的未重复的ID个数
        System.out.println(generatorIds.size());

        executorService.shutdown();
    }
}
