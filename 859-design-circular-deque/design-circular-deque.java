class MyCircularDeque {

    int size, front, rear;
    int[] arr; // Fixed: was 'int arr' before

    public MyCircularDeque(int k) {
        size = k;
        front = rear = -1;
        arr = new int[size];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false; // Fixed: was isEmpty()
        else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[front] = value;
        } else if (front == 0 && rear != size - 1) { // Corrected rear = size - 1 to comparison
            front = size - 1;
            arr[front] = value;
        } else if (front > 0) {
            front--;
            arr[front] = value;
        } else {
            return false; // cannot insert if there's no space
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = value;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            arr[rear] = value;
        } else if ((rear + 1) % size != front) {
            rear = (rear + 1) % size;
            arr[rear] = value;
        } else {
            return false;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        else if (front == rear) {
            arr[front] = -1;
            front = rear = -1;
        } else {
            arr[front] = -1;
            front = (front + 1) % size;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        else if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + size) % size;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1) % size == front;
    }

}
