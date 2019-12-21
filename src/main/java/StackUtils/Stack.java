package StackUtils;

import CommonUtils.Node;

import java.io.Serializable;

public class Stack<T> implements Serializable {

    public Node<T> head;

    public void push(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if(null != head) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public T pop(){
        if(null != head){
            T data = head.getData();
            head = head.getNext();
            return data;
        }else
            return null;
    }

    public T peek(){
        if(null != head){
            return head.getData();
        }else
            return null;
    }


    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0; i < 10; i++){
            integerStack.push(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(integerStack.pop());
        }
    }

}
