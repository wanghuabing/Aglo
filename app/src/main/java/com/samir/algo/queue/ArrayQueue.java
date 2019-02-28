package com.samir.algo.queue;

/**
 * 用数组实现的队列
 * @author: samir
 * @date: 2019/2/28 上午10:49
 */
// 用数组实现的队列
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item){
        if(tail == n){
            //队列已满
            if(head == 0 ) return false;

            //数据搬移
            for (int i = head; i < tail ; i++) {
                items[i-head] = items[i];
            }
            //更新head tail 位置
            tail -= head;
            head = 0;
        }
        //插入队列
        items[++tail] = item;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把 -- 操作放到单独一行来写了
        String ret = items[++head];
        return ret;
    }
}
