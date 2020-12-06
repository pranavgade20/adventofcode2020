import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Day6_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-6"));

        int res = 0;

        while (s.hasNext()){
            String line = s.nextLine();
            String temp;
            while (!(temp = s.nextLine()).isBlank()) line += temp;
            HashSet<Character> chars = new HashSet<>();
            Arrays.stream(line.split("")).forEachOrdered(c -> chars.add(c.charAt(0)));
            res += chars.size();
        }

        System.out.println(res);
    }
}
