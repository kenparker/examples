package com.maggioni.CustomException;

import java.util.HashMap;
import java.util.Map;

/**
 * http://javarevisited.blogspot.de/2014/06/how-to-create-custom-exception-in-java.html
 * @author maggioni
 */
public class CustomExceptionDemo {

    private static final Map<Integer, String> products = new HashMap<>();

    static {
        // http://openbook.galileocomputing.de/javainsel/javainsel_05_006.html#dodtpf09d4e31-719a-4bdc-bdff-d10f3483aa88
        products.put(100, "Coke");
        products.put(101, "KitKat");
        products.put(102, "Bisuits");
        products.put(103, "Toast");
    }

    public static void main(String args[]) {
        CustomExceptionDemo t = new CustomExceptionDemo();
        t.getProduct(1000);
    }

    public String getProduct(int id) {
        if (products.get(id) == null) {
            throw new NoSuchProductException("No such product exists", id);
        }
        return products.get(id);
    }

}
