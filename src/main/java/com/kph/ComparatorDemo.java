package com.kph;

import java.io.IOException;
import java.util.*;

public class ComparatorDemo {

        public static void main(String[] args) {

            String[] inpStr = {
                    "5",
                    "amy 100",
                    "david 100",
                    "heraldo 50",
                    "aakansha 75",
                    "aleksa 150"};

            try {
                List<Player> playarr = new ArrayList<>();
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                //int n = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(inpStr[0]);
                for (int i=1; i<= n; i++) {
                    //String[] inp = br.readLine().split(" ");
                    String[]  inp = inpStr[i].replaceAll("\\s+$", "").split(" ");
                    playarr.add(new Player(inp[0], Integer.parseInt(inp[1])));
                }

                Collections.sort(playarr, new Checker());

                //Arrays.sort

                for (Player p: playarr) {
                    System.out.println(p.getName() + " " + p.getScore());
                }

            } catch(Exception ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }

}

class Player {

    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.getScore() > b.getScore()) return -1;
        if (a.getScore() < b.getScore()) return 1;
        // equal then continue
        int ret = a.getName().compareTo(b.getName());
        if (ret != 0) return ret;

        return 0;
    }

}


