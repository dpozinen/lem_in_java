package lemin;

import java.util.ArrayList;

class Farm
{
    private static int       ants;
    private static Room      start;
    private static Room      end;
    private static boolean   quickFind = false;
    private static ArrayList <Room> roomList = new ArrayList<>();
    private static ArrayList <Path> pathList = new ArrayList<>();
    private static ArrayList <Set> setsFound;

    void    execute()
    {
        Reader reader = new Reader();
        reader.readInput();
        PathFinder pathFinder = new PathFinder();
        pathFinder.findAllPaths();
        SetFinder setFinder = new SetFinder();
        setFinder.chooseBestPathSet();
    }
    void    print(int what)
    {
        System.out.println();
        System.out.println("Ants count: "+ ants);
        System.out.println("Start: "+ Farm.getStart());
        System.out.println("End: "+ Farm.getEnd());

        if (what >= 1) // print room list
            for (Room r : roomList)
                System.out.println("Room name: " + r.getName());
        if (what >= 2) // print link list
            for (Room r : roomList)
            {
                System.out.println("Links for room: " + r.getName());
                for (Room rlinks : r.getLinks())
                    System.out.println(rlinks.getName());
            }
        if (what >= 3) // print path list
            for (Path p : pathList)
            {
                System.out.printf("path with id %4d : ", pathList.indexOf(p));
                p.print();
                System.out.println();
            }
        System.out.println();
        for (Set s : setsFound)
            {
                System.out.println(s.getLength());
                s.print();
            }
    }
    public static int getAnts() {
        return ants;
    }
    public static Room getEnd() {
        return end;
    }
    public static ArrayList<Path> getPathList() {
        return pathList;
    }
    public static ArrayList<Room> getRoomList() {
        return roomList;
    }
    public static ArrayList<Set> getSetsFound() {
        return setsFound;
    }
    public static Room getStart() {
        return start;
    }
    public static boolean getQuickFind() {
        return quickFind;
    }
    public static void setStart(Room start) {
        Farm.start = start;
    }
    public static void setEnd(Room end) {
        Farm.end = end;
    }
    public static void setAnts(int ants) {
        Farm.ants = ants;
    }
    public static void setSetsFound(ArrayList<Set> setsFound) {
        Farm.setsFound = setsFound;
    }
}