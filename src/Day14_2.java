import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Day14_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-14"));

        long ORmask = 0;
        String mask = "";
        HashMap<Long, Long> memory = new HashMap<>();
        while (s.hasNext()){
            String line = s.nextLine();
            if (line.startsWith("mask")) {
                ORmask = Long.parseLong(line.substring(7).replaceAll("X", "0"), 2);
                mask = line.substring(7);
            } else {
                long loc = Long.parseLong(line.substring(4, line.indexOf(']')));
                long data = Long.parseLong(line.substring(line.indexOf('=')+2));

                loc |= ORmask;

                addrs(new LinkedList<>(), loc, mask, 0).forEach(addr -> memory.put(addr, data));
            }
        }

        long res = 0;
        for (Long value : memory.values()) {
            res+=value;
        }
        System.out.println(res);
    }

    static LinkedList<Long> addrs(LinkedList<Long> ret, long addr, String mask, int start) {
        int index;
        if ((index = mask.indexOf('X', start)) > -1) {
            addrs(ret, addr|((1L<<35)>>index), mask, index+1);
            addrs(ret, addr&(~((1L<<35)>>index)), mask, index+1);
        } else ret.add(addr);
        return ret;
    }
}

