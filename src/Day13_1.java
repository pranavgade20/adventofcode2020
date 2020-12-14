import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-13"));

        int res = 0;

        double min = Integer.parseInt(s.nextLine());
        ArrayList<Integer> departs = new ArrayList<>();
        for (String d : s.nextLine().split(",")) {
            if (!d.equals("x")) {
                departs.add(Integer.parseInt(d));
            }
        }

        int bestBus = departs.get(0);
        int bestTime = (int) (bestBus*(Math.ceil(min/bestBus)));
        for (Integer bus : departs) {
            int time = (int) (bus*(Math.ceil(min/bus)));
            if (time < bestTime) {
                bestBus = bus;
                bestTime = time;
            }
        }

        System.out.println((bestTime-min)*bestBus);
    }
}

