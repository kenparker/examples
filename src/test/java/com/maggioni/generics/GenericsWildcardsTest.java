
package com.maggioni.generics;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author magang
 */
public class GenericsWildcardsTest
{
    
    public GenericsWildcardsTest()
    {
    }

    /**
     * Test of upperBound method, of class GenericsWildcards.
     */
    @Test
    public void testSumInteger()
    {
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(10);
        double expResult = 14;
        double result = GenericsWildcards.upperBound(list);
        assertEquals(expResult, result, 0.0);
        
    }
    
    @Test
    public void testSumDouble()
    {
       
        List<Double> list = new ArrayList<>();
        list.add(1.2);
        list.add(3.0);
        list.add(10.11);
        double expResult = 14.31;
        double result = GenericsWildcards.upperBound(list);
        assertEquals(expResult, result, 0.01);
        
    }
    
    @Test
    public void testSumNumber()
    {
       
        List<Number> list = new ArrayList<>();
        list.add(5.2);
        list.add(5.0);
        list.add(10.11);
        double expResult = 20.31;
        double result = GenericsWildcards.upperBound(list);
        assertEquals(expResult, result, 0.01);
        
    }
    
    @Test
    public void testSumFloat()
    {
       
        List<Float> list = new ArrayList<>();
        list.add(10F);
        list.add(5F);
        list.add(10F);
        double expResult = 25;
        double result = GenericsWildcards.upperBound(list);
        assertEquals(expResult, result, 0.01);
        
    }

    @Test
    public void lowerBoundInteger()
    {
       
        List<Integer> list = new ArrayList<>();
        List<Number> expResult = new ArrayList<>();
        expResult.add(new Integer(50));
        List<? super Integer> result = GenericsWildcards.lowerBound(list);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void lowerBoundObject1()
    {
       
        List<Object> list = new ArrayList<>();
        List<Integer> expResult = new ArrayList<>();
        expResult.add(50);
        List<? super Integer> result = GenericsWildcards.lowerBound(list);
        assertEquals(expResult, result);
        
    }
    
        
    @Test
    public void lowerBoundNumber()
    {
       
        List<Number> list = new ArrayList<>();
        List<Integer> expResult = new ArrayList<>();
        expResult.add(new Integer(50));
        List<? super Integer> result = GenericsWildcards.lowerBound(list);
        assertEquals(expResult, result);
        
    }
    
       
    
    /**
     * Test of printData method, of class GenericsWildcards.
     */
    @Test
    public void testPrintDataString()
    {
      
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        
        assertEquals("A::B::", GenericsWildcards.printData(list).toString());
        
    }
    
    @Test
    public void testPrintDataInteger()
    {
      
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        
        assertEquals("1::2::", GenericsWildcards.printData(list).toString());
        
    }
    
    @Test
    public void testPrintDataObject()
    {
      
        List<Object> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new String("a"));
        
        assertEquals("1::a::", GenericsWildcards.printData(list).toString());
        
    }
}
