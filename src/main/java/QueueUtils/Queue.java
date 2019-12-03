package QueueUtils;

import CommonUtils.Node;

import java.io.Serializable;

public class Queue<T> implements Serializable {

    private Node<T> head;

    private Node<T> tail;

    public void enqueue(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if(null != tail){
            tail.setNext(newNode);
            tail = newNode;
        }else{
            head = newNode;
            tail = newNode;
        }
    }

    public T peek(){
        if(null != head){
            return head.getData();
        }else
            return null;
    }

    public T dequeue(){
        if(null != head){
            T data = head.getData();
            if(null != head.getNext())
                head = head.getNext();
            else{
                head = null;
                tail = null;
            }
            return data;
        }else
            return null;
    }

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        for(int i = 0; i < 10; i++){
            integerQueue.enqueue(i);
        }
        while(null != integerQueue.peek()){
            System.out.println(integerQueue.dequeue());
        }
    }

}
