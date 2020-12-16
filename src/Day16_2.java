import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day16_2 {
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

        String[] self = s.nextLine().split(",");
        s.nextLine();

        HashSet<String>[] possibilities = new HashSet[20];
        for (int i = 0; i < possibilities.length; i++) {
            possibilities[i] = new HashSet<>(valid.keySet());
        }
        out: while (s.hasNext()) {
            line = s.nextLine();
            for (String st : line.split(",")) if (!all.contains(Integer.parseInt(st))) continue out;

            String[] arr = line.split(",");
            for (int i = 0; i < arr.length; i++) {
                int temp = Integer.parseInt(arr[i]);
                possibilities[i].removeIf(elem -> !valid.get(elem).contains(temp));
            }
        }

        //now reduce based on constraints
        //coulda done topological sort but im lazy
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (possibilities[j].size() == 1) {
                    String toRm = possibilities[j].iterator().next();
                    for (int k = 0; k < 20; k++) {
                        if (k != j) {
                            possibilities[k].remove(toRm);
                        }
                    }
                }
            }
        }
        long ret = 1;
        for (int i = 0; i < 20; i++) {
            if (possibilities[i].iterator().next().startsWith("departure")) ret *= Integer.parseInt(self[i]);
        }
        System.out.println(ret);
    }
}

