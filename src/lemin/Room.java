package lemin;

import java.util.regex.*;
import java.util.ArrayList;

class Room
{
    // private int     antsInRoom; not used yet
    private String  name;
    private ArrayList <Room> links = new ArrayList<>();

    Room(String name)
    {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    static boolean isRoomInList(String s)
    {
        for (Room r : Farm.getRoomList())
            if (r.name.equals(s))
                return true;
        return false;
    }
    static Room findRoomByName(String s)
    {
        for (Room r : Farm.getRoomList())
            if (r.name.equals(s))
                return r;
        return null;
    }
    static String extractName(String s, int link)
    {
        if (link == 0)
        {
            Pattern patternRoom = Pattern.compile("^\\w+");
            Matcher matcher = patternRoom.matcher(s);
            matcher.find();
            return matcher.group(0);
        }
        else
        {
            Pattern pattern;

            if (link == 1)
                pattern = Pattern.compile("(\\w+)(?=([-]))");
            else
                pattern = Pattern.compile("(?<=([-]))(\\w+)");
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            String rName = matcher.group(0);
            return rName;
        }
    }
    public ArrayList<Room> getLinks() {
        return links;
    }
    public String getName() {
        return name;
    }
}