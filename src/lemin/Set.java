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
    }
    Set     makeByPathIds(int[] pathIds, Set curSet)
    {
        curSet.setPaths.clear();
        for (int i : pathIds)
        {
            Path p = Farm.pathList.get(i);
            curSet.setPaths.add(p);
        }
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