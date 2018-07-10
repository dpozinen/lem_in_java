package lemin;

import java.util.regex.*;

class AddInput
{
    static void add(int type, String s)
    {
        if (type == 1)
            addRoom(s);
        /* if (type == 2)
            addLink(s);
        if (type == 3)
            addCommand(s);
        if (type == 4)
            addComment(s);  */  
    }
    static void addRoom(String s)
    {
        Pattern pattern = Pattern.compile("^\\w[ ]");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        String roomName = matcher.group(1);
        int id = Farm.roomList.size() + 1; 
        Room room = new Room(roomName, id);
        Farm.roomList.add(room);
    }
    static void addLink(String s)
    {

    }

}