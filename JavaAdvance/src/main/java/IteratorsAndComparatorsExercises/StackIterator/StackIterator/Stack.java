package IteratorsAndComparatorsExercises.StackIterator.StackIterator;

import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer>{
    private Node<Integer> top;

    public Stack() {
        this.top = null;
    }

    public void push(int element) {
        Node<Integer> node = new Node<>(element);
        node.prev = this.top;
        top = node;

    }

    public int pop() throws Exception {
        if (this.top == null) {
          throw new Exception ("No elements");

        } else {
            Node<Integer> currentTop = this.top;
            this.top = this.top.prev;
            return currentTop.element;
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node<Integer> current = top;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Integer next() {
               int currentValue = current.element;
               this.current = this.current.prev;
               return (Integer) java.lang.Integer.valueOf(currentValue);
            }
        };
    }
}


