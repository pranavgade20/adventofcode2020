import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-3"));
        int ret, x, y;
        int product = 1;
        char[][] arr = new char[323][];
        int i = 0;
        while (s.hasNext()) {
            arr[i++] = s.nextLine().toCharArray();
        }

        x = 0;
        y = 0;
        ret = 0;
        while (x < arr.length) {
            if (arr[x][y] == '#') ret++;

            y+=1;
            y %= arr[0].length;
            x++;
        }
        product *= ret;
        x = 0;
        y = 0;
        ret = 0;
        while (x < arr.length) {
            if (arr[x][y] == '#') ret++;

            y+=3;
            y %= arr[0].length;
            x++;
        }
        product *= ret;
        x = 0;
        y = 0;
        ret = 0;
        while (x < arr.length) {
            if (arr[x][y] == '#') ret++;

            y+=5;
            y %= arr[0].length;
            x++;
        }
        product *= ret;
        x = 0;
        y = 0;
        ret = 0;
        while (x < arr.length) {
            if (arr[x][y] == '#') ret++;

            y+=7;
            y %= arr[0].length;
            x++;
        }
        product *= ret;
        x = 0;
        y = 0;
        ret = 0;
        while (x < arr.length) {
            if (arr[x][y] == '#') ret++;

            y+=1;
            y %= arr[0].length;
            x+=2;
        }
        product *= ret;
        System.out.println(product);
    }
}
