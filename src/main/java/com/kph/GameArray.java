package com.kph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameArray {

    public static void main(String[] args) {

        String[] inpstr = new String[]{
                "1",
                "9 4",
                "0 1 1 0 0 1 1 0 1"
        };

        int n = Integer.parseInt(inpstr[0]);
        try {
            for (int i=0; i < n; i=i+2) {
                String[] gamestr = inpstr[i+1].replaceAll("\\s+$", "").split(" ");
                String[] gamearry = inpstr[i+2].trim().split(" ");
                int gameSz = Integer.parseInt(gamestr[0]);
                int leap = Integer.parseInt(gamestr[1]);
                int winln = gamearry.length;
                int j=0;
                boolean resu = true;
                while (j < winln) {
                    if (j + leap > winln) {
                        break;
                    }
                    if (gamearry[j + leap].equals("0")) { // jump first
                        j = j + leap;
                    } else { // step to next
                        if (gamearry[j + 1].equals("0")){
                            j++;
                        } else {
                            resu = false;
                            break;
                        }
                    }
                }

                if (resu) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");

                }
            }

        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
}
