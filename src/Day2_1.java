import java.io.FileReader;
import java.util.Scanner;

public class Day2_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-2"));

        int res = 0;

        while (s.hasNext()){
            String[] line = s.nextLine().split(" ");

            int min = Integer.parseInt(line[0]);
            int max = Integer.parseInt(line[1]);
            String pattern = line[2];

            int occ = 0;
            for (String c : line[3].split("")) {
                if (pattern.equals(c)) occ++;
            }
            if (min <= occ && occ <= max)
                res++;
        }

        System.out.println(res);
    }
}
