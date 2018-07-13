package lemin;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class AddInput
{
    void read()
    {
        try {
            File        file = new File("S:\\Code\\Lem_in\\test.txt");
            Scanner     sc = new Scanner(file);
            Validate    val = new Validate();
            // Scanner     sc = new Scanner(System.in);

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
                add(type, s, sc);
            }
        }
        catch (FileNotFoundException f)
        {
            System.out.println("File doesnt exist");
            System.exit(0);
        }
    }
    static void add(int type, String s, Scanner sc)
    {
        if (type == 1)
            addRoom(s);
        if (type == 2)
            addLink(s);
        if (type == 3 || type == 4)
            addCommand(s, type, sc);
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
        Room    r;

        if (Farm.linkList.size() == 0)
            Farm.fillLinkList();
        for (ArrayList <Room> rlist : Farm.linkList)
        {
            r = rlist.get(0);
            int rNum = 0;
            if (r.name.equals(roomOne))
                rNum = 1;
            if (r.name.equals(roomTwo))
                rNum = 2;
            if (rNum > 0)
                rlist.add(Room.findRoomByName(rNum == 1 ? roomTwo : roomOne));
        }
    }
    static void addCommand(String s, int flag, Scanner sc)
    {
        String  roomLine = sc.nextLine();
        Validate val = new Validate();

        if (val.validateAs(roomLine) == 1)
            addRoom(roomLine);
        else
            return ;
        if (flag == 3) //start
            Farm.start = Farm.roomList.size() - 1;
        if (flag == 4) // end
            Farm.end = Farm.roomList.size() - 1;
        // if (flag == 2)
            // read next int as number of max sets
    }
}