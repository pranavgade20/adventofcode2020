import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Day9_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-9"));

        long[] nums = new long[1000];

        int i = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            nums[i++] = Long.parseLong(line);
        }

        HashSet<Long> preamble = new HashSet<>();
        for (int j = 0; j < 25; j++) {
            preamble.add(nums[j]);
        }

        for (int j = 26; j < 1000; j++) {
            boolean contains = false;
            for (Long l : preamble) {
                if (preamble.contains(nums[j] - l)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                System.out.println(nums[j]);
                return;
            }
            preamble.remove(nums[j-26]);
            preamble.add(nums[j]);
        }
    }
}

