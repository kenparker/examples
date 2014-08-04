
package com.maggioni.generics;

import static org.junit.Assert.*;

/**
 *
 * @author magang
 */
public class GenericsMethodsTest
{

    
    /**
     * Test of isEqual method, of class GenericsMethods.
     */
    @org.junit.Test
    public void testIsEqual()
    {
        System.out.println("isEqual");
        boolean expResult = true;
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Pankaj");
        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Pankaj");
        boolean result = GenericsMethods.isEqual(g1, g2);
        assertEquals(expResult, result);
        
    }

    

}
