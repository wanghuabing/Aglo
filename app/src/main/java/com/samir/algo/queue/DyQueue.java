package com.samir.algo.queue;

import java.util.Arrays;

/**
 * @author: samir
 * @date: 2019/3/1 上午9:52
 */
public class DyQueue {
    private static final int DEFAULT_CAPACITY = 10;
    String arr[];
    int curSize;
    int head;
    int tail;

    public DyQueue(int initialCapacity) {
        if (initialCapacity > 0) {
             arr = new String[initialCapacity];
        } else {
             arr = new String[DEFAULT_CAPACITY];
        }
    }

    //入列
    public void enqueue(String item){
        if(isQueueFull()){
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }

        arr[tail] = item;
        tail = (tail + 1)  % getSize();
        curSize++;
    }

    private int getSize(){
        return arr.length;
    }

    //出列
    public String dequeue(){
        String item = null;
        if(isQueueEmpty()){
            System.out.println("Queue is Enpty...");
            return null;
        }else{
            item = arr[head];
            head = (head + 1) % getSize();
        }
        curSize--;
        System.out.println("dequeue: " + item +"  head :"+head);
        return item;
    }


    //判断队列是否已满
    public boolean isQueueFull(){
        if(curSize == arr.length){
            return true;
        }
        return false;
    }

    //判断队列是否已空
    public boolean isQueueEmpty(){
        if(curSize == 0){
            return true;
        }
        return false;
    }


    //数组扩容
    public void increaseCapacity(){
        int oldCapacity = getSize();
        int newCapacity = oldCapacity + (oldCapacity >> 2);

        arr = Arrays.copyOf(arr,newCapacity);
        System.out.println("increaseCapacity  newCapacity: " + newCapacity);
    }

    public static void main(String[] args){
        DyQueue queue = new DyQueue(2);
        queue.enqueue("3");
        queue.enqueue("2");
        queue.dequeue();
        queue.enqueue("8");
        queue.enqueue("77");
        queue.enqueue("5");
        queue.enqueue("66");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

}
