package com.maggioni.regularExpressions;

import com.maggioni.regularExpressions.Example_1.RegexGroupBasic;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author maggioni
 */
public class RegexGroupBasicTest {

    private RegexGroupBasic regex;
    String str;

    @Before
    public void setup() {
        regex = new RegexGroupBasic();
    }

    @Test
    public void testGroup1Greedy() {
        str = "This order was placed for QT3000! OK?";
        String group1 = regex.getGroup1Greedy(str);
        assertTrue(group1.equals("This order was placed for QT300"));

    }

    @Test
    public void testGroup1Reluctant() {
        str = "This order was placed for QT3000! OK?";
        String group1 = regex.getGroup1Reluctant(str);
        assertTrue(group1.equals("This order was placed for QT"));

    }

    @Test
    public void testIs6DigitNumber1() {
        str = "123";
        assertFalse(regex.is6DigitNumber(str));
    }
    
    @Test
    public void testIs6DigitNumber2() {
        str = "123333";
        assertTrue(regex.is6DigitNumber(str));
    }
    
    @Test
    public void testIsOnlyDigit1() {
        str = "123333";
        assertTrue(regex.isOnlyDigitNumber(str));
    }
    
    @Test
    public void testIsOnlyDigit2() {
        str = "1233x33";
        assertFalse(regex.isOnlyDigitNumber(str));
    }
    
    public void testIsOnlyDigit3() {
        str = "abc";
        assertFalse(regex.isOnlyDigitNumber(str));
    }
}
