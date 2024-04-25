/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author Admin
 */
public class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void splitOddEven(Node head) {
        if (head == null || head.next == null) {
            System.out.println("The list is either empty or contains only one element.");
            return;
        }

        Node oddHead = null;
        Node evenHead = null;
        Node oddTail = null;
        Node evenTail = null;

        Node current = head;

        while (current != null) {
            if (current.data % 2 != 0) { // Odd
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            } else { // Even
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            }
            current = current.next;
        }

        // Connect tails to null to end the lists
        if (oddTail != null) oddTail.next = null;
        if (evenTail != null) evenTail.next = null;

        // Print the odd list
        System.out.print("Odd list: ");
        printList(oddHead);

        // Print the even list
        System.out.print("Even list: ");
        printList(evenHead);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(10);

        System.out.print("Original list: ");
        printList(head);

        splitOddEven(head);
    }
}
