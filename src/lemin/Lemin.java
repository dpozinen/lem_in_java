package lemin;

import java.util.*;

class Lemin
{
    public static void main(String []args)
    {
        Farm antFarm = new Farm();
        AddInput addInput = new AddInput();
        addInput.read();
        antFarm.print(2);
    }
}