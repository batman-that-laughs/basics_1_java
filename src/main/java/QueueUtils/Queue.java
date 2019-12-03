import java.io.Serializable;

public class Queue<T> implements Serializable {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;

    private Node<T> tail;

    public void enqueue(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if(null != tail){
            tail.setNext(newNode);
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public

}
