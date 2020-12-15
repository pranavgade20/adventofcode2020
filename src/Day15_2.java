import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Day15_2 {
    public static void main(String[] args) throws Exception{
        HashMap<Integer, Integer> nums = new HashMap<>();

        int lastSpoken;
        int turn = 1;

        lastSpoken = 16;
        nums.put(lastSpoken, turn++);
        lastSpoken = 1;
        nums.put(lastSpoken, turn++);
        lastSpoken = 0;
        nums.put(lastSpoken, turn++);
        lastSpoken = 18;
        nums.put(lastSpoken, turn++);
        lastSpoken = 12;
        nums.put(lastSpoken, turn++);
        lastSpoken = 14;
        nums.put(lastSpoken, turn++);
        lastSpoken = 19;
//        lastSpoken = 0;
//        nums.put(lastSpoken, turn++);
//        lastSpoken = 3;
//        nums.put(lastSpoken, turn++);
//        lastSpoken = 6;

        for (; turn < 30000000; turn++) {
            if (turn % 300000 == 0) {
                System.out.println(turn/300000);
            }
            if (!nums.containsKey(lastSpoken)) {
                nums.put(lastSpoken, turn);
                lastSpoken = 0;
            } else {
                int t = (turn)-nums.get(lastSpoken);
                nums.put(lastSpoken, turn);
                lastSpoken = t;
            }
        }
        System.out.println(lastSpoken);
    }
}

