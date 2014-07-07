
package com.maggioni.Abstract;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * http://java67.blogspot.de/2014/06/why-abstract-class-is-important-in-java.html
 */
public class AbstractClassDemo {
    public static void main(String args[]) {
        Fruit mango = new Mango(Color.YELLOW, true); // mango is seasonal
        Fruit banana = new Banana(Color.YELLOW, false); // banana is not seasonal

        List<Fruit> platter = new ArrayList<Fruit>();
        platter.add(mango);
        platter.add(banana);
        serve(platter);
    }

    public static void serve(Collection<Fruit> fruits) {
        System.out.println("Preparing fruits to serve");
        for (Fruit f : fruits) {
            f.prepare();
        }
    }
}
