package lemin;

import java.util.regex.*;

class Validate
{
    InputType     validateAs(String s)
    {
        if (isRoom(s))
            return InputType.ROOM;
        if (isLink(s))
            return InputType.LINK;
        if (isStart(s))
            return InputType.START;
        if (isEnd(s))
            return InputType.END;
        return null;
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

    boolean isStart(String s)
    {
        if (Pattern.matches("^##start$", s))
           return true;
        return false;
    }

    boolean isEnd(String s)
    {
        if (Pattern.matches("^##end$", s))
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
