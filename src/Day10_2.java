import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-10"));

        int[] input = new int[104];

        int a = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            input[a++] = Integer.parseInt(line);
        }

        long[] result = new long[input.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i-j > -1 && input[i-j]-input[i] <= 3) {
                    result[i] += result[i-j];
                }
            }
        }

        System.out.println(result[103]);
    }
}

