package cn.itedus.lottery.interfaces.test.domain;

/**
 * @description: 测试ThreadLocal
 * @author：小林哥，微信：tabc18835
 * @date: 2023/5/19 0019
 * @github: https://github.com/tangchaolin
 * @Copyright： - 沉淀、分享、成长，让自己和他人都能有所收获！
 */



import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *		通过魔数0x61c88647来计算数组索引下标
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/2 22:02
 */
public class ThreadLocal0x61c88647 {

    /** 定义数组的初始大小 */
    private static final int INITIAL_CAPACITY = 16;
    /** 魔数 -> 可以让生成出来的值或者说ThreadLocal的Index均匀的分布在2^n的数组大小中 */
    private static final int HASH_INCREMENT = 0x61c88647;

    private  ThreadLocal<Integer> s;
    /** 魔数 */
    private final int threadLocalHashCode = nextHashCode();
    /** 定义一个线程安全的原子类AtomicInteger，用于魔数的累加 */
    private static AtomicInteger nextHashCode = new AtomicInteger();

    /** 计算下一个code(魔数累加) */
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    /**
     * 根据生成的均匀分布的随机数threadLocalHashCode 取模(%) （数组大小INITIAL_CAPACITY-1（因为数组索引从0开始）)
     *
     * @return
     */
    public int index() {
        return this.threadLocalHashCode & (INITIAL_CAPACITY - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.println(new ThreadLocal0x61c88647().index());
        }
    }
}
