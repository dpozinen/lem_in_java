package lemin;

import java.util.*;

class Lemin
{
    public static void main(String []args)
    {
        Farm antFarm = new Farm();
        AddInput addInput = new AddInput();
        addInput.read();
        PathFinder.findAllPaths();
        Collections.sort(Farm.pathList, Path.bySizeAsc);
        antFarm.print(3);
    }
}