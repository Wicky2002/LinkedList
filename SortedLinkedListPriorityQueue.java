/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortedlinkedlistpriorityqueue;

/**
 *
 * @author Admin
 */
public class SortedLinkedListPriorityQueue {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class PriorityQueue {
        private Node head;

        public PriorityQueue() {
            this.head = null;
        }

        public void insert(int key) {
            Node newNode = new Node(key);

            // If the list is empty or the new node has a smaller key than the head
            if (head == null || key < head.data) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.data < key) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }

        public void remove() {
            if (head == null) {
                System.out.println("Priority queue is empty.");
                return;
            }

            head = head.next;
        }

        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.insert(3);
        pq.insert(1);
        pq.insert(4);
        pq.insert(2);

        System.out.print("Priority Queue: ");
        pq.display(); // Output: 1 2 3 4

        pq.remove();
        System.out.print("After remove: ");
        pq.display(); // Output: 2 3 4
    }
}
