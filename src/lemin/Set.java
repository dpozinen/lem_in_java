package lemin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Set
{
    private ArrayList <Path> paths = new ArrayList<>();
    private int efficiency;
    private int length;

    public Set() {
    }

    public Set(Set other)
    {
        this.efficiency = other.efficiency;
        this.length = other.length;
        for (Path p : other.paths)
            this.paths.add(p);
    }

    public ArrayList<Path> getpaths() {
        return paths;
    }

    public int  getLength() {
        return length;
    }

    int     pathsIntersect()
    {
        ArrayList <Room> roomsInCurSet = new ArrayList<>();

        for (Path p : paths)
            for (Room r : p.getPathRooms())
                if (r != Farm.getStart() && r != Farm.getEnd())
                    if (roomsInCurSet.contains(r))
                        return paths.indexOf(p);
                    else
                        roomsInCurSet.add(r);
        return -1;
    }

    void     makeByPathIds(int[] pathIds)
    {
        paths.clear();
        for (int i : pathIds)
        {
            Path p = Farm.getPathList().get(i);
            paths.add(p);
        }
        countLength();
    }

    void    countEfficiency() { // TODO
        // int maxPathSize = Collections.max(paths, Path.bySizeAsc).getLength();

        // nt	merge_value;
        // int	merge_sum;
        // int	in_total;
        // int i;

        // merge_value = max_len(set) - 1;
        // if (merge_value == 1 && (set->ants[0] = ants))
        //     return (1);
        // merge_sum = 0;
        // i = 0;
        // while (i < set->size)
        // {
        //     set->ants[i] = merge_value - (set->paths[i]->length - 1) + 1;
        //     merge_sum += set->ants[i++];
        // }
        // ants = ants - merge_sum + 1;
        // in_total = merge_value + ft_ceildiv(ants - 1, set->size);
        // i = 0;
        // while (i < set->size && --ants > 0)
        // {
        //     set->ants[i]++;
        //     if (++i == set->size)
        //         i = 0;
        // }
        // return (in_total);
    }

    void    countLength()
    {
        length = 0;
        for (Path p : paths)
            length += p.getLength();
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

    void    print()
    {
        for (Path p : paths)
            p.print();
        for (int i = 0; i < 10; i++)
            System.out.print('-');
        System.out.println();
    }
}