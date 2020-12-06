import java.io.FileReader;
import java.util.*;

public class Day6_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-6"));

        int res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
            HashSet<Character> chars = new HashSet<>();
            Arrays.stream(line.split("")).forEachOrdered(c -> chars.add(c.charAt(0)));
            String temp;
            while (!(temp = s.nextLine()).isBlank()) {
                HashSet<Character> t = new HashSet<>();
                Arrays.stream(temp.split("")).forEachOrdered(c -> t.add(c.charAt(0)));
                chars.removeIf(o -> !t.contains(o));
            }
            res += chars.size();
        }

        System.out.println(res);
    }
}
