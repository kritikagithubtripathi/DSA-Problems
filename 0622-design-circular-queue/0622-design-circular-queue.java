class MyCircularQueue {
    int []queue;
    int front, rear, size, capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[capacity];
        front = rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        rear = (rear+1)% capacity;
        queue[rear] = value;
        size++;
        
        if(front == -1)
            front = rear;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front =(front + 1)% capacity;
        size--;
        
        if(size == 0)
            front = rear = -1;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if ((rear+1)% capacity == front)
            return true;
        return false;
    }
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