package lemin;

import java.util.regex.*;

class Validate
{
    int     validateAs(String s)
    {
        if (isRoom(s))
            return 1;
        if (isLink(s))
            return 2;
        if (isCommand(s))
            return 3;
        if (isComment(s))
            return 4;
        return 0;
    }
    boolean isRoom(String s)
    {
        if (Pattern.matches("^\\w+[ ]\\d+[ ]\\d+$", s))
        {
            String rName = Room.extractName(s, 0);
            if (!Room.isRoomInList(rName)) 
                return true;  
        }
        return false;
    }
    boolean isCommand(String s)
    {
        if (Pattern.matches("##start", s) || Pattern.matches("##end", s))
           return true;
        return false;
    }
    boolean isComment(String s)
    {
        if (Pattern.matches("^[#].*", s))
            return true;
        return false;
    }
    boolean isLink(String s)
    {
        if (Pattern.matches("^\\w+[-]\\w+$", s))
        {
            String nameOne = Room.extractName(s, 1);
            String nameTwo = Room.extractName(s, 2);
            if (Room.isRoomInList(nameOne) && Room.isRoomInList(nameTwo))
                return true;
        }
        return false;
    }
}
