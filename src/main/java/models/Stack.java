package models;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T> {

    private LinkedList<T> stack = new LinkedList<>();

    public void push(T element) {
        stack.add(element);
    }

    public T peek() {
        try {
            return stack.getLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public T pop() {
        return stack.removeLast();
    }

    public int size() {
        return stack.size();
    }
}