package lemin;

import java.util.ArrayList;
import java.util.Comparator;

class Set
{
    ArrayList <Path> setPaths = new ArrayList<>();
    private int efficiency;
    private int length;

    void    print()
    {
        for (Path p : setPaths)
            p.print();
        for (int i = 0; i < 10; i++)
            System.out.print('-');
        System.out.println();
    }
    public Set(){
    }
    public Set(Set other)
    {
        this.efficiency = other.efficiency;
        this.length = other.length;
        for (Path p : other.setPaths)
            this.setPaths.add(p);
    }
    public int  getLength()
    {
        return length;
    }
    int     pathsIntersect()
    {
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        for (Path p : setPaths)
            for (Room r : p.pathRooms)
                if (r.id != Farm.start && r.id != Farm.end)
                    if (roomsInCurSet.contains(r))
                        return setPaths.indexOf(p);
                    else
                        roomsInCurSet.add(r);
        return -1;
    }
    Set     makeByPathIds(int[] pathIds, Set curSet) // TODO: change so that takes only pathIds
    {
        curSet.setPaths.clear();
        for (int i : pathIds)
        {
            Path p = Farm.pathList.get(i);
            curSet.setPaths.add(p);
        }
        countLength();
        return curSet;
    }
    void    countEfficiency()
    {
        efficiency = 0;
    }
    void    countLength()
    {
        length = 0;
        for (Path p : setPaths)
            length += p.length;
    }
    public static Comparator<Set> byEfficiency = new Comparator<Set>() {
        public int compare(Set one, Set two)
        {
            if (one.efficiency > two.efficiency)
                return 1;
            if (one.efficiency < two.efficiency)
                return -1;
            return 0;
        }
    };
}