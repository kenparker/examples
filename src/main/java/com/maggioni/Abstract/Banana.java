
package com.maggioni.Abstract;

import java.awt.Color;

/*
 * Another concrete class to extend Fruit.
 */
public class Banana extends Fruit {

    public Banana(Color color, boolean seasonal) {
        super(color, seasonal);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void prepare() {
        System.out.println("Peal the Banana");
    }
}
