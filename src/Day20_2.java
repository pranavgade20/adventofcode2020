import com.google.common.collect.BiMap;
import com.google.common.collect.EnumHashBiMap;
import com.google.common.collect.HashBiMap;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day20_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-20"));

        long res = 1;

        HashMap<String, Integer> edges = new HashMap<>(); // edge -> tile
        HashMap<Integer, Integer> connections = new HashMap<>();
        while (s.hasNext()){
            String line = s.nextLine();
            int n = Integer.parseInt(line.substring(line.indexOf(' ')+1, line.indexOf(':'))) << 2;
            int u = 0, d = 0, l = 0, r = 0;
            char[] chars = s.nextLine().toCharArray();
            l += chars[0] == '#' ? 1 : 0;
            r += chars[9] == '#' ? 1 : 0;
            for (char c : chars) {
                u <<= 1;
                u += c == '#' ? 1 : 0;
            }
            for (int i = 0; i < 8; i++) {
                chars = s.nextLine().toCharArray();
                l <<= 1;
                r <<= 1;
                l += chars[0] == '#' ? 1 : 0;
                r += chars[9] == '#' ? 1 : 0;
            }
            chars = s.nextLine().toCharArray();
            l <<= 1;
            r <<= 1;
            l += chars[0] == '#' ? 1 : 0;
            r += chars[9] == '#' ? 1 : 0;
            for (char c : chars) {
                d <<= 1;
                d += c == '#' ? 1 : 0;
            }

            String U = Integer.toString(u, 2);
            while (U.length() != 10) U = "0" + U;
            String rU = (new StringBuilder(U)).reverse().toString();
            if (edges.containsKey(U)) {
                int target = edges.remove(U);
                connections.put(target, (n|0));
                connections.put((n|0), target);
            } else if (edges.containsKey(rU)) {
                int target = edges.remove(rU);
                connections.put(target, (n|0));
                connections.put((n|0), target);
            } else edges.put(U, (n|0));

            String D = Integer.toString(d, 2);
            while (D.length() != 10) D = "0" + D;
            String rD = (new StringBuilder(D)).reverse().toString();
            if (edges.containsKey(D)) {
                int target = edges.remove(D);
                connections.put(target, (n|1));
                connections.put((n|1), target);
            } else if (edges.containsKey(rD)) {
                int target = edges.remove(rD);
                connections.put(target, (n|0));
                connections.put((n|0), target);
            } else edges.put(D, (n|1));

            String L = Integer.toString(l, 2);
            while (L.length() != 10) L = "0" + L;
            String rL = (new StringBuilder(L)).reverse().toString();
            if (edges.containsKey(L)) {
                int target = edges.remove(L);
                connections.put(target, (n|2));
                connections.put((n|2), target);
            } else if (edges.containsKey(rL)) {
                int target = edges.remove(rL);
                connections.put(target, (n|0));
                connections.put((n|0), target);
            } else edges.put(L, (n|2));

            String R = Integer.toString(r, 2);
            while (R.length() != 10) R = "0" + R;
            String rR = (new StringBuilder(R)).reverse().toString();
            if (edges.containsKey(R)) {
                int target = edges.remove(R);
                connections.put(target, (n|3));
                connections.put((n|3), target);
            } else if (edges.containsKey(rR)) {
                int target = edges.remove(rR);
                connections.put(target, (n|0));
                connections.put((n|0), target);
            } else edges.put(R, (n|3));

            try {
                s.nextLine();
            } catch (Exception e) {break;}
        }

        HashSet<Integer> repeated = new HashSet<>();
        for (Integer edge : edges.values()) {
            int e = edge >> 2;
            if (repeated.contains(e)) {
                repeated.remove(e);
                res *= e;
            } else repeated.add(e);
        }

        System.out.println(res);
    }
}
