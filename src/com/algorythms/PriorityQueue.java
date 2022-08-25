package com.algorythms;

import java.io.IOException;

public class PriorityQueue {
    private int maxSize;
    private int nItems;
    private long[] queueArray;

    public PriorityQueue(int s) {
        maxSize = s;
        queueArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if(nItems == 0) {
            queueArray[nItems++] = item;
        }else
        {
            for(j = nItems - 1; j >= 0; j--) {
                if(item > queueArray[j])
                    queueArray[j + 1] = queueArray[j];
                else
                    break;
            }
            queueArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queueArray[--nItems];
    }

    public long peekMin() {
        return queueArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

}

class PriorityQueueApp {
    public static void main(String[] args) throws IOException {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(20);
        priorityQueue.insert(10);
        priorityQueue.insert(50);
        priorityQueue.insert(40);

        while (!priorityQueue.isEmpty()) {
            long item = priorityQueue.remove();
            System.out.println(item + " ");
        }
        System.out.println("");
    }
}
