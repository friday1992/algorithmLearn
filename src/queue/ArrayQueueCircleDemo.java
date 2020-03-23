package queue;

//使用数组模拟队列
public class ArrayQueueCircleDemo {
    public static void main(String[] args) throws Exception {
        ArrayQueueCircle arrayQueue = new ArrayQueueCircle(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.showQueue();
        System.out.println(arrayQueue.headQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        arrayQueue.addQueue(5);
        arrayQueue.showQueue();
    }

    static class ArrayQueueCircle{
        //最大容量
        private int maxSize;
        private int front;//队首指针
        private int rear;//队尾指针
        private int[] arr;
        public  ArrayQueueCircle(int size){
            maxSize = size+1;
            arr = new int[maxSize];
            front = 0;
            rear = 0;

        }
        public boolean isFull(){
            return (rear+1)%maxSize == front;
        }
        public boolean isEmpty(){
            return rear == front;
        }
        public void addQueue(int data){
            if(isFull()){
                System.out.println("队列已满");
                return;
            }

            arr[rear]=data;
            rear = (rear+1)%maxSize;
        }
        //取数据
        public int getQueue() throws Exception {
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            int temp = arr[front];
            front = (front+1)%maxSize;
            return temp;

        }
        public int headQueue(){
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            return arr[front];
        }
        public void showQueue(){
            if(isEmpty()){
                System.out.println("为空");
                throw  new RuntimeException("为空");
            }
            System.out.println("队列");
            //从front 开始遍历
            for(int i=front;i<front+size();i++){

                System.out.println(arr[i%maxSize]);
            }
        }
        //获取有效的个数
        private  int size(){
                return (rear+maxSize-front)%maxSize;
        }

    }

}
