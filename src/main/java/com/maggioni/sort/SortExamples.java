package com.maggioni.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * programcreek.com
 */
public class SortExamples {

    public static void main(String[] args) {

        // Example 1 
        List unsortedList = new ArrayList();
        unsortedList.add("Bari");
        unsortedList.add("Ancona");
        unsortedList.add("Agrigento");

        System.out.println("unsorted list : " + unsortedList);

        Set<String> sortedSet = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        sortedSet.addAll(unsortedList);
        
        System.out.println("sorted list : " + sortedSet);
        
        
        // Example 2 sort with TreeSet
        Set<String> sortedSet2 = new TreeSet<String>();
        
        sortedSet2.addAll(unsortedList);
        System.out.println("sortled list 2 : "+ sortedSet2);
        
        // example 3
        
        Order order1 = new Order(100, 200, "Angelo");
        Order order2 = new Order(5, 300, "lucia");
        Order order3 = new Order(200, 3333, "sandro");
        
        List listofOrders = new ArrayList<Order>();
        listofOrders.add(order1);
        listofOrders.add(order2);
        listofOrders.add(order3);
        System.out.println("list of orders unsorted : "+ listofOrders);
        
        sortedSet2.clear();
        sortedSet2.addAll(listofOrders);
        System.out.println("list of orders sorted :" +sortedSet2);
        
        for (Object set : sortedSet2) {
            System.out.println(set.toString());
        }
        
        // Example 5
        Set<Order> sortedSetOrder = new TreeSet<Order>( new Order.OrderByCustomer());
        sortedSetOrder.addAll(listofOrders);
        System.out.println(sortedSetOrder);
        for (Order order : sortedSetOrder) {
            System.out.println("order : id :" + order.getOrderId() + " customer : " + order.getCustomer() + " amount : " + order.getAmount()  );
        }
    }
}
