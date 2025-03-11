package queue;

import java.util.Scanner;

class Node {

    int data;
    Node next;

    public Node(int x) {
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return data + "->";

    }
}

public class Queue {

    Node head;
    Node tail;

    void MyQueue() {
        head = tail = null;
    }

    boolean EmptQ() {
        return head == null;
    }

    void add(int x) {
        Node t = new Node(x);
        if (head == null) {
            head = tail = t;

        } else {
            tail.next = t;
            tail = t;
        }
    }

    int RemoveQ() {
        int x = 0;
        if (head == null) {

            System.out.println("\n Hang doi rong");

        } else {
            x = head.data;
            if (head.next == null) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
        return x;
    }

    void nhap() {
        Scanner sc = new Scanner(System.in);
        int x;
        while (true) {
            System.out.println("Nhap x<>0:");
            x = sc.nextInt();
            if (x == 0) {
                break;
            } else {
                add(x);
            }
        }
    }

    void tong() {
        Queue q = new Queue();
        int k = 0;
        while (!EmptQ()) {
            int x = RemoveQ();
            k = k + x;
            q.add(x);

        }
        while (!q.EmptQ()) {
            this.add(q.RemoveQ());
        }
        
    }
    void demLe() {
        Queue q = new Queue();
        int count = 0;
        while (!EmptQ()) {
            int x = RemoveQ();
            if (x % 2 != 0) { // Kiểm tra số lẻ
                count++;
            }
            q.add(x);
        }
        while (!q.EmptQ()) {
            this.add(q.RemoveQ());
        }
        System.out.println("\n So luong phan tu le trong hang doi: " + count);
    }
    void in() {
        System.out.println("\n Noi dung hang doi: ");
        Queue q = new Queue();
        while (!EmptQ()) {
            int x = RemoveQ();
            System.out.println(" " + x);
            q.add(x);
        }
        while (!q.EmptQ()) {
            this.add(q.RemoveQ());
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.nhap();
        q.in();
        q.tong();
        q.demLe();
    }
}
