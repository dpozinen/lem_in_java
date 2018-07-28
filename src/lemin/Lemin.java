package lemin;

class Lemin
{
    public static void main(String []args)
    {
        Farm antFarm = new Farm();
        Reader addInput = new Reader();
        addInput.readInput();
        PathFinder pathFinder = new PathFinder();
        pathFinder.findAllPaths();
        SetFinder setFinder = new SetFinder();
        setFinder.chooseBestPathSet();
        // antFarm.print(2);
    }
}