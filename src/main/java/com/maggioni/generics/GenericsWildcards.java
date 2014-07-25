package com.maggioni.generics;

import java.util.List;

/**
 *
 */
public class GenericsWildcards
{

    public static double upperBound(List<? extends Number> list)
    {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    public static List<? super Integer> lowerBound(List<? super Integer> list)
    {
        list.add(new Integer(50));
        return  list;
    }

    public static StringBuilder printData(List<?> list)
    {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj + "::");
        }
        return sb;
    }
}
