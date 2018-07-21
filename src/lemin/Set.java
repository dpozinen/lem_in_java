package lemin;

import java.util.ArrayList;
import java.util.Comparator;

class Set
{
    ArrayList <Path> setPaths = new ArrayList<>();
    private int efficiency;
    private int lenght;

    void    print()
    {
        for (Path p : setPaths)
            p.print();
    }
    void countEfficiency()
    {
        efficiency = 0;
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