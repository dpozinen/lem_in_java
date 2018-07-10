package lemin;

import java.util.*;

class Lemin
{
    public static void main(String []args)
    {
        Farm antFarm = new Farm();
        AddInput addInput = new AddInput();
        addInput.read();
        antFarm.print(1);
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextLine())
        // {
        //     String s = sc.nextLine();
        //     // System.out.println(s);
        //     int type = val.validateAs(s);
        //     AddInput.add(type, s);
        // }
        // sc.close();
    }
}