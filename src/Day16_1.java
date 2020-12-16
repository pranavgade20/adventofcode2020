import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day16_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-16"));

        HashSet<Integer> all = new HashSet<>();
        HashMap<String, HashSet<Integer>> valid = new HashMap<>();
        String line;
        while (s.hasNext() && !(line = s.nextLine()).isEmpty()){
            String a = line.split(": ")[1].split(" or ")[0];
            String b = line.split(": ")[1].split(" or ")[1];
            int j = Integer.parseInt(a.split("-")[0]);
            int k = Integer.parseInt(a.split("-")[1]);
            int l = Integer.parseInt(b.split("-")[0]);
            int m = Integer.parseInt(b.split("-")[1]);

            line = line.split(": ")[0];
            valid.put(line, new HashSet<>());
            while (j <= k) valid.get(line).add(j++);
            while (l <= m) valid.get(line).add(l++);
            all.addAll(valid.get(line));
        }

        for (int i = 0; i < 2; i++) {
            s.nextLine(); // skip our lines
        }

        int ret = 0;
        while (s.hasNext()) {
            line = s.nextLine();
            for (String st : line.split(",")) if (!all.contains(Integer.parseInt(st))) ret += Integer.parseInt(st);
        }

        System.out.println(ret);
    }
}

