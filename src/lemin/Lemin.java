package lemin;

import java.util.regex.*;

class Lemin
{
    public static void main(String []args)
    {
        // String s = Room.extractName("ROOM 4 5", 0);
        // System.out.println("|"+s+"|");
        // s = "lol-kek";
        // String lOne = Room.extractName(s, 1);
        // String lTwo = Room.extractName(s, 2);
        // System.out.println("| "+lOne + " | " + lTwo+" |");
        String s = "room-man";
        Pattern patternRoom = Pattern.compile("(?<=([-]))(\\w+)");
        Matcher matcher = patternRoom.matcher(s);
        matcher.find();
        String ss = matcher.group(0);
        System.out.println("|"+ss+"|");
    }
}