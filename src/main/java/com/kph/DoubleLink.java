package com.kph;

public class DoubleLink {

    public Train head = null;
    public Train tail = null;

    public void attachWagonFromLeft(int wagonId) {
        Train node = new Train();
        node.name = wagonId;
        node.prev = null;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            node.prev = null;
            head = node;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        Train node = new Train();
        node.name = wagonId;
        node.prev = null;

        if (tail == null) {
            tail = node;
            head = node;
        } else {
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public int detachWagonFromLeft() {
        int ret = head.name;
        System.out.println("Detach left." + ret);
        head = head.next;
        return ret;
    }

    public int detachWagonFromRight() {
        int ret = tail.name;
        System.out.println("Detach right." + ret);
        tail = tail.prev;
        return ret;
    }
    public void insertAfter(Train prevNode, int newDdata) {

        if (prevNode == null) {
            System.out.println("insertAfter cannot have null prev node");
            return;
        }
        Train newnode = new Train();
        newnode.name = newDdata;
        newnode.prev = null;

        newnode.next = prevNode.next;
        newnode.prev = prevNode;
        prevNode.next = newnode;


    }

    public void printTrainList() {

        Train node = head;
        while ( node != null) {
            System.out.printf(" %d - ", node.name);
            node = node.next;
        }
    }

    public class Train {
        int name;
        Train prev;
        Train next;
    }
}
