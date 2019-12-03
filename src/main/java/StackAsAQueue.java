import StackUtils.Stack;

public class StackAsAQueue<T> {

    private Stack<T> originalStack = new Stack<>();

    private Stack<T> stackAsAQueue = new Stack<>();

    public void enqueue(T data){
        originalStack.push(data);
    }

    public Stack<T> getQueueFromStack(Stack<T> originalStack) {
        while(null != originalStack.peek()){
            stackAsAQueue.push(originalStack.pop());
        }
        return stackAsAQueue;
    }

    public T peek() {
        Stack<T> queue = this.getQueueFromStack(originalStack);
        return queue.peek();
    }

    public T dequeue() {
        Stack<T> queue = this.getQueueFromStack(originalStack);
        return queue.pop();
    }

    public static void main(String[] args) {
        StackAsAQueue<Integer> integerStackAsAQueue =new StackAsAQueue();
        for(int i = 0; i < 10; i++){
            integerStackAsAQueue.enqueue(i);
        }

        while(null != integerStackAsAQueue.peek()){
            System.out.println(integerStackAsAQueue.dequeue());
        }
    }

}
