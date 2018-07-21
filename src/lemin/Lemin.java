package lemin;

// import java.util.*;

class Lemin
{
    public static void main(String []args)
    {
        // Farm antFarm = new Farm();
        // AddInput addInput = new AddInput();
        // addInput.read();
        // PathFinder pathFinder = new PathFinder();
        // pathFinder.findAllPaths();
        // pathFinder.chooseBestPathSet();
        // antFarm.print(0);
        int maxComb = 0;
        for (int i = 0; i < 3; i++)
            maxComb += 9 - i;
        System.out.println(maxComb);
    }
}