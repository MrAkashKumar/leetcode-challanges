package com.akash.leetcode;
/*
 * https://leetcode.com/problems/design-circular-queue/
 */
public class MyDesignCircularQueue {

    private int front;
    private int rear;
    private int capacity;
    private int size;

    public MyDesignCircularQueue(int k) {
        this.capacity = 0;
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear+1) % capacity;
        //queue[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        return false;
        
    }
    
    public int Front() {
        return 0;
    }
    
    public int Rear() {
        return 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }


    public static void main(String[] args) {
        
        

    }


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
    
}