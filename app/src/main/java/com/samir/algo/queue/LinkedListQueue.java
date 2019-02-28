package com.samir.algo.queue;

/**
 * @author: samir
 * @date: 2019/2/28 上午11:36
 */
public class LinkedListQueue {
    // head 表示队头下标，tail 表示队尾下标
    private Note head = null;
    private Note tail = null;

    //入列
    public void enqueue(String item){
      if(tail == null){
          Note newNode = new Note(item);
          newNode.next = null;
          head = tail = newNode;
      }else{
          Note newNode = new Note(item);
          newNode.next = null;
          tail.next = newNode ;
          tail = newNode;
      }
    }


    // 出队
    public Note dequeue() {
        if (head == null) return null;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return head;
    }

    public class Note{
        private Note next;
        private String data;

        public Note(String data) {
            this.data = data;
        }
    }
}
