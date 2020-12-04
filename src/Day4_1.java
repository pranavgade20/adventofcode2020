import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Day4_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-4"));
        int ret = 0;

        String[] req = {"byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:"};
        out: while (s.hasNext()) {
            String line = s.nextLine();
            String temp;
            while (!(temp = s.nextLine()).isBlank()) line += " " + temp;
            for (String r : req) {
                if (!line.contains(r)) continue out;
            }
            ret++;
        }
        System.out.println(ret);
    }
}
