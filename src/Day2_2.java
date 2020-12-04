import java.io.FileReader;
import java.util.Scanner;

public class Day2_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-2"));

        int res = 0;

        while (s.hasNext()){
            String[] line = s.nextLine().split(" ");

            int min = Integer.parseInt(line[0])-1;
            int max = Integer.parseInt(line[1])-1;
            char pattern = line[2].charAt(0);

            int occ = 0;
            occ += pattern == line[3].charAt(min) ? 1 : 0;
            occ += pattern == line[3].charAt(max) ? 1 : 0;

            if (occ == 1)
                res++;
        }

        System.out.println(res);
    }
}
