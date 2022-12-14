package com.algorythms;

public class Queue2 {
    private int maxSize;
    private int front;
    private int rear;
    private long[] queueArray;

    public Queue2(int s) {
        maxSize = s + 1;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = j;
    }

    public long remove() {
        long temp = queueArray[front++];
        if(front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peek() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return ((rear + 1 == front) || (front + maxSize - 1== rear));
    }

    public boolean isFull() {
        return ((rear + 2 == front) || (front + maxSize - 2 == rear));
    }

    public int size() {
        if(rear >= front) {
            return rear = front + 1;
        }else
            return (maxSize - front) + (rear + 1);
    }
}
