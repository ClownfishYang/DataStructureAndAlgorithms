package io.clownfishyang.datastructure;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2019/10/29 16:40<br>
 */
public class LinkedList<E> {

    private Node head;
    private Node tail;

    public boolean add(E e) {
        Node<E> n = new Node<>(e);
        if (head == null) {
            head = n;
            tail = head;
        } else {
            tail.next(n);
            tail = n;
        }
        return true;
    }

    public boolean remove(E e) {

        if (this.head == null) {
            return false;
        }
        Node<E> beforeNode = head;
        if (beforeNode.data.equals(e)) {
            unlink(beforeNode, null);
            return true;
        }
        return false;
    }

    E unlink(Node<E> beforeNode, Node<E> currentNode) {
        beforeNode.next(currentNode.next);
        return currentNode.data;
    }


    class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public boolean next(Node<E> n) {
            this.next = n;
            return true;
        }
    }

}
