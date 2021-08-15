package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/6/29
 * 描述：最近最少使用
 * 思路：每次访问后就移动到链表首位
 */
public class LRUCache {

    private Node head = new Node(0, 0);

    private Node tail = new Node(0, 0);

    private int size = 0;

    private final int capacity;

    public Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public Node removeTail() {
        Node tailNode = this.tail.prev;
        removeNode(tailNode);
        return tailNode;
    }


    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
