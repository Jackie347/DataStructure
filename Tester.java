package com.jackie;

public class Tester {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("A");
        list.append("B");
        list.append("C");
        list.append("D");
        list.append("E");
      
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(3));
        
        list.remove(3);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        
        list.set(0, "A");      
        System.out.println(list);
        
        list.insert(1, "B");
        list.insert(2, "B");
        System.out.println(list);
        
    }
}

