import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Day14_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-14"));

        long ORmask = 0;
        long ANDmask = 0;
        HashMap<Long, Long> memory = new HashMap<>();
        while (s.hasNext()){
            String line = s.nextLine();
            if (line.startsWith("mask")) {
                ORmask = Long.parseLong(line.substring(7).replaceAll("X", "0"), 2);
                ANDmask = Long.parseLong(line.substring(7).replaceAll("X", "1"), 2);
            } else {
                long loc = Long.parseLong(line.substring(4, line.indexOf(']')));
                long data = Long.parseLong(line.substring(line.indexOf('=')+2));

                data |= ORmask;
                data &= ANDmask;

                memory.put(loc, data);
            }
        }

        long res = 0;
        for (Long value : memory.values()) {
            res+=value;
        }
        System.out.println(res);
    }
}

