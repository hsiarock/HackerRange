package com.kph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {

    public static Collection<String> parsePattern(String str, char startingLetter) {
        String regex = "<folder name=\"(.*?)\"(.*?)>";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);

        if(m.matches()) {
            System.out.println("Str matching is valid");
        } else {
            System.out.println("Str matching is not valid");
        }

        Collection<String> out = new ArrayList<>();
        //Retrieving the regular expression of the current pattern
        String prefix = String.valueOf(startingLetter);
        while (m.find()) {
            //String regularExpression = pattern.pattern();
            System.out.println(" : " + m.group(1));
            if (m.group(1).startsWith(prefix))
            out.add(m.group(1));
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("----Pattern parse\n");
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = PatternMatch.parsePattern(xml, 'u');
        for(String name: names)
            System.out.println(name);

    }
}
