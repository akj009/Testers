package models;

import java.util.LinkedList;

public class Stack<T> {

    private LinkedList<T> stack = new LinkedList<>();

    public void push(T element) {
        stack.add(element);
    }

    public T peek() {
        return stack.getLast();
    }

    public T pop() {
        return stack.removeLast();
    }

    public int size() {
        return stack.size();
    }
}