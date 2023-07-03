package com.kph;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        Song s1 = this;
        Song s2 = this.nextSong;

        int count = 0;
        while (s2 != null) {
            System.out.println("name : " + s2.name);
            if (s1.name.equals(s2.name))
                return true;
            s2 = s2.nextSong;

            if (count++ > 30)
                break;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("\n-----Song -----");
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("3333");
        Song four = new Song("4444");

        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(four);
        four.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}




