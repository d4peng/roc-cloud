//package icu.d4peng.cloud.common.core.util;
//
//import java.util.concurrent.*;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2021-12-24 10:15
// * @description ExecutorFactory:线程池工具类
// */
//// TODO 有点问题
//public class ExecutorFactory {
//    /**
//     * 线程池等待时间单位
//     */
//    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;
//    /**
//     * 活跃线程数
//     */
//    private int corePoolSize = 5;
//    /**
//     * 线程允许的最大线程数
//     */
//    private int maximumPoolSize = 10;
//    /**
//     * 当线程超过活跃线程数时,超过线程等待的时间数
//     */
//    private long keepAliveTime = 300L;
//    /**
//     * 未工作的线程排队的队列
//     */
//    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(5);
//    /**
//     * 线程产生的工厂
//     */
//    private ThreadFactory threadFactory = Executors.defaultThreadFactory();
//    /**
//     * 当线程达到队列数量时,拒绝操作的策略
//     */
//    private RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
//
//    /**
//     * 构建线程池
//     *
//     * @param executorFactory 线程池工厂
//     * @return 线程池
//     */
//    public static ExecutorService build(ExecutorFactory executorFactory) {
//        return new ThreadPoolExecutor(executorFactory.corePoolSize, executorFactory.maximumPoolSize,
//                executorFactory.keepAliveTime, TIME_UNIT, executorFactory.blockingQueue,
//                executorFactory.threadFactory, executorFactory.rejectedExecutionHandler);
//    }
//
//    /**
//     * 构建线程池
//     *
//     * @return 线程池
//     */
//    public static ExecutorService build() {
//        return build(new ExecutorFactory());
//    }
//
//    public ExecutorFactory setCorePoolSize(int corePoolSize) {
//        this.corePoolSize = corePoolSize;
//        return this;
//    }
//
//    public ExecutorFactory setMaximumPoolSize(int maximumPoolSize) {
//        this.maximumPoolSize = maximumPoolSize;
//        return this;
//    }
//
//    public ExecutorFactory setKeepAliveTime(long keepAliveTime) {
//        this.keepAliveTime = keepAliveTime;
//        return this;
//    }
//
//    public ExecutorFactory setBlockingQueue(BlockingQueue<Runnable> blockingQueue) {
//        this.blockingQueue = blockingQueue;
//        return this;
//    }
//
//    public ExecutorFactory setThreadFactory(ThreadFactory threadFactory) {
//        this.threadFactory = threadFactory;
//        return this;
//    }
//
//    public ExecutorFactory setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
//        this.rejectedExecutionHandler = rejectedExecutionHandler;
//        return this;
//    }
//
//}
