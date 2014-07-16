package com.maggioni.regularExpressions.Example_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author maggioni
 */
public class RegexGroupBasic {

    public String getGroup1Greedy(String input) {

        Pattern r = Pattern.compile("(.*)(\\d+)(.*)");
        Matcher m = r.matcher(input);
        m.find();
        return m.group(1);
    }
    
    public String getGroup1Reluctant(String input) {

        Pattern r = Pattern.compile("(.*?)(\\d+)(.*)");
        Matcher m = r.matcher(input);
        m.find();
        return m.group(1);
    }
    
    public boolean is6DigitNumber(String input) {
        
        Pattern patter = Pattern.compile("\\d{6}");
        return patter.matcher(input).matches();
    }
    
    public boolean isOnlyDigitNumber(String input) {
        
        Pattern patter = Pattern.compile(".*[^0-9].*");
        return !patter.matcher(input).matches();
    }
}
