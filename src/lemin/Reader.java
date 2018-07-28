package lemin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Reader
{
    Scanner readFile()
    {
        System.out.println("Enter File Name: ");

        Scanner     sc = new Scanner(System.in);
        String  fileName = sc.next();
        try{
            File    file = new File("S:\\Code\\Lem_in\\tests\\"+fileName+".txt");
            Scanner fsc = new Scanner(file);
            sc.close();
            return fsc;
        }
        catch (FileNotFoundException f)
        {
            System.out.println("File doesn't exist. Continue Y/N?");
            sc.nextLine();
            if (sc.nextLine().equals("Y"))
                return readFile();
            else
                System.exit(0);
        }
        return sc;
    }
    void readInput()
    {
        Validate    val = new Validate();
        Scanner     sc = readFile();

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
            if (!add(type, s, sc))
                break ;
        }
        sc.close();
    }
    boolean add(int type, String s, Scanner sc)
    {
        if (type == 1)
            addRoom(s);
        if (type == 2)
            addLink(s);
        if (type == 3 || type == 4)
            if (!addCommand(s, type, sc))
                return false;
        return true;
    }
    void addRoom(String s)
    {
        String roomName = Room.extractName(s, 0);
        int id = Farm.roomList.size();
        Room room = new Room(roomName, id);
        Farm.roomList.add(room);
    }
    void addLink(String s)
    {
        String  roomOne = Room.extractName(s, 1);
        String  roomTwo = Room.extractName(s, 2);

        for (Room r : Farm.roomList)
        {
            int rNum = 0;
            if (r.getName().equals(roomOne))
                rNum = 1;
            if (r.getName().equals(roomTwo))
                rNum = 2;
            if (rNum > 0)
                r.getLinks().add(Room.findRoomByName(rNum == 1 ? roomTwo : roomOne));
        }
    }
    boolean addCommand(String s, int flag, Scanner sc)
    {
        String  roomLine = sc.nextLine();
        Validate val = new Validate();

        if (val.validateAs(roomLine) == 1)
            addRoom(roomLine);
        else
            return false;
        if (flag == 3) //start
            Farm.start = Farm.roomList.size() - 1;
        if (flag == 4) // end
            Farm.end = Farm.roomList.size() - 1;
        // if (flag == 2)
            // read next int as number of max sets
        return true;
    }
}