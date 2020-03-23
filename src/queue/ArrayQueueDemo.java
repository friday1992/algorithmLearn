package queue;

import java.util.Scanner;

//使用数组模拟队列
public class ArrayQueueDemo {
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        System.out.println(arrayQueue.headQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
    }

    static class ArrayQueue{
        //最大容量
        private int maxSize;
        private int front;//队首指针
        private int rear;//队尾指针
        private int[] arr;
        public  ArrayQueue(int size){
            maxSize = size;
            arr = new int[maxSize];
            front = -1;
            rear = -1;

        }
        public boolean isFull(){
            return rear == maxSize-1;
        }
        public boolean isEmpty(){
            return rear == front;
        }
        public void addQueue(int data){
            if(isFull()){
                System.out.println("队列已满");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        public int getQueue() throws Exception {
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            front++;
            return arr[front];
        }
        public int headQueue(){
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            return arr[front+1];
        }
        public void showQueue(){
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            System.out.println("队列");
            for(int a:arr){

                System.out.println(a);
            }
        }

    }
}
