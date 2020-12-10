import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Day9_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-9"));

        long[] nums = new long[1000];

        int i = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            nums[i++] = Long.parseLong(line);
        }

        for (int j = 0; j < 1000; j++) {
            long expected = 507622668;
            int k = j;
            while (expected > 0) {
                expected -= nums[k++];
            }

            if (expected == 0) {
                for (int l = j; l < k; l++) {
                    System.out.println(nums[l]);
                }
                return;
            }
        }
    }
}