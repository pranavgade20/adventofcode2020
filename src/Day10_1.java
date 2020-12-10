import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-10"));

        int[] arr = new int[103];

        int a = 1;
        while (s.hasNext()){
            String line = s.nextLine();
            arr[a++] = Integer.parseInt(line);
        }

        Arrays.sort(arr);

        int[] diffs = new int[3];
        diffs[2] = 1;

        for (int i = 1; i < arr.length; i++) {
            diffs[arr[i]-arr[i-1]-1]++;
        }
        System.out.println(diffs[0]*diffs[2]);
    }
}

