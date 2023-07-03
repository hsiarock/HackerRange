package com.kph;

import java.util.regex.Pattern;

public class ParseUserName {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^(?=.{8,30}$)(?![0-9_])[A-Za-z0-9_]+$");
        /******
             ^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$
             └─────┬────┘└───┬──┘└─────┬─────┘└─────┬─────┘ └───┬───┘
             │         │         │            │           no _ or . at the end
             │         │         │            │
             │         │         │            allowed characters
             │         │         │
             │         │         no __ or _. or ._ or .. inside
             │         │
             │         no _ or . at the beginning
             │
             username is 8-20 characters long
         *******/
        int n = 8;
        String inpstr[] = {
                "Julia",
                "Samantha",
                "Samantha_21",
                "1Samantha",
                "Samantha?10_2A",
                "JuliaZ007",
                "Julia@007",
                "_Julia007"
        };

        for (int i=0; i< n; i++) {
            System.out.print(inpstr[i] + " -> ");
            if (pattern.matcher(inpstr[i]).find())
                System.out.println("Valid");
            else
                System.out.println("Invalid");
        }

    }
}
