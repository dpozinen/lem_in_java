package lemin;

import java.util.*;

class AddInput
{
    void read()
    {
        Scanner     sc = new Scanner(System.in);
        Validate    val = new Validate();
        
        if (sc.hasNextInt())
            Farm.ants = sc.nextInt();
        else
        {
            sc.close();
            return ;
        }
        sc.nextLine();
        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            int type = val.validateAs(s);
            if (type == 0)
                break ;
            add(type, s);
        }
        sc.close();
    }
    static void add(int type, String s)
    {
        if (type == 1)
            addRoom(s);
         if (type == 2)
            addLink(s);
        // if (type == 3)
            // addCommand(s);
        /*if (type == 4)
            addComment(s);  */  
    }
    static void addRoom(String s)
    {
        String roomName = Room.extractName(s, 0);
        int id = Farm.roomList.size(); 
        Room room = new Room(roomName, id);
        Farm.roomList.add(room);
    }
    static void addLink(String s)
    {
        String  roomOne = Room.extractName(s, 1);
        String  roomTwo = Room.extractName(s, 2);
        Boolean found = false;

        for (ArrayList <Room> rlist : Farm.linkList)
        {
            if (rlist.get(0).name.equals(roomOne))
            {
                rlist.add(Room.findRoomByName(roomTwo));
                found = true;
            }
        }
        if (found == false)
        {
            ArrayList <Room> newRoom = new ArrayList <Room>();
            newRoom.add(Room.findRoomByName(roomOne));
            newRoom.add(Room.findRoomByName(roomTwo));
            Farm.linkList.add(newRoom);
        }
    }
    static void addCommand(String s, int flag)
    {
        Scanner sc = new Scanner(System.in);
        String  roomLine = sc.nextLine();
        Validate val = new Validate();
        
        if (val.validateAs(roomLine) == 1)
            addRoom(s);
        if (flag == 0) //start
            Farm.start = Farm.roomList.size() - 1;
        if (flag == 1) // end
            Farm.start = Farm.roomList.size() - 1;
        sc.close();
        // if (flag == 2)
            // read next int as number of max sets
    }
}