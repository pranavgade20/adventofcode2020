import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Day4_2 {
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

            for (String kv : line.split(" ")) {
                String[] pair = kv.split(":");
                try {
                    int y;
                    switch (pair[0]) {
                        case "byr":
                            y = Integer.parseInt(pair[1]);
                            if (y < 1920) continue out;
                            if (y > 2002) continue out;
                            break;
                        case "iyr":
                            y = Integer.parseInt(pair[1]);
                            if (y < 2010) continue out;
                            if (y > 2020) continue out;
                            break;
                        case "eyr":
                            y = Integer.parseInt(pair[1]);
                            if (y < 2020) continue out;
                            if (y > 2030) continue out;
                            break;
                        case "hgt":
                            if (pair[1].endsWith("cm")) {
                                y = Integer.parseInt(pair[1].substring(0, pair[1].length()-2));
                                if (y < 150) continue out;
                                if (y > 193) continue out;
                            } else if (pair[1].endsWith("in")) {
                                y = Integer.parseInt(pair[1].substring(0, pair[1].length()-2));
                                if (y < 59) continue out;
                                if (y > 76) continue out;
                            } else continue out;
                            break;
                        case "hcl":
                            if (pair[1].length() != 7) continue out;
                            if (pair[1].charAt(0) != '#') continue out;
                            Integer.parseInt(pair[1].substring(1), 16);
                            break;
                        case "ecl":
                            HashSet<String> opts = new HashSet<String>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
                            if (!opts.contains(pair[1])) continue out;
                            break;
                        case "pid":
                            Long.parseLong(pair[1]);
                            if (pair[1].length() != 9) continue out;
                            break;
                        case "cid":
                            break;
                        default:
                            continue out;
                    }
                } catch (Exception e) {
                    continue out;
                }
            }
            ret++;
        }
        System.out.println(ret);
    }
}
