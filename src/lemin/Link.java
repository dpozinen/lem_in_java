package lemin;

import java.util.ArrayList;

class Link
{
    // int  nOfLinks;
    Room mainRoom;
    ArrayList <Room> links;

    Link (Room mainRoom)
    {
        this.mainRoom = mainRoom;
        links = new ArrayList<>();
    }
    void print()
    {
        System.out.println("Links for room: "+mainRoom);
        for (Room r : links)
            System.out.println(r);
        System.out.println();
    }
}