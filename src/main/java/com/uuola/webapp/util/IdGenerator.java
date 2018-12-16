package com.uuola.webapp.util;

/**
 * 
 * <pre>
 * time(44bit) + workerId(4bit) + sequence(12bit)
 * @author tonydon
 * 创建日期: 2018年12月16日
 * </pre>
 */
public enum IdGenerator {

    INSTANCE;
    private long workerId;
    private long sequence = 0L;
    private long twepoch = 1543593600000L; // 2018-12-01 00:00:00
    private long workerIdBits = 4L; //节点ID长度
    private long sequenceBits = 12L; //序列号12位
    private long timeLeftShift = sequenceBits + workerIdBits; //时间毫秒数左移位
    private long sequenceMask = -1L ^ (-1L << sequenceBits); //4095
    private long lastTimestamp = -1L;

    IdGenerator() {
        this.workerId = Long.parseLong(System.getProperty("idGenerator.workerId", "0"));
        if(this.workerId<0L || this.workerId> 15L){
            throw new RuntimeException("the workerId config must be in range [0,15]");
        }
    }

    public synchronized long nextId() {
        long timestamp = time(); //获取当前毫秒数
        //如果服务器时间有问题(时钟后退) 报错。
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果上次生成时间和当前时间相同,在同一毫秒内
        if (lastTimestamp == timestamp) {
            //sequence自增，因为sequence只有12bit，所以和sequenceMask相与一下，去掉高位
            sequence = (sequence + 1) & sequenceMask;
            //判断是否溢出,也就是每毫秒内超过4095，当为4096时，与sequenceMask相与，sequence就等于0
            if (sequence == 0) {
                timestamp = nextMillis(lastTimestamp); //自旋等待到下一毫秒
            }
        } else {
            sequence = 0L; //如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加
        }
        lastTimestamp = timestamp;
        // 最后按照规则拼出ID。
        // 000000000000000000000000000000000000000000 0000 000000000000
        // time workerId sequence
        return ((timestamp - twepoch) << timeLeftShift) | (workerId << sequenceBits) | sequence;
    }

    private long nextMillis(long lastTimestamp) {
        long timestamp = time();
        while (timestamp <= lastTimestamp) {
            timestamp = time();
        }
        return timestamp;
    }

    private long time() {
        return System.currentTimeMillis();
    }

}

