import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day11_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-11"));

        int res = 0;
        char[][] curr = new char[93][];

        int a = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            curr[a++] = line.toCharArray();
        }
        char[][] prev = new char[curr.length][curr[0].length];

        while (!equals(curr, prev)) {
            prev = curr;
            curr = new char[prev.length][prev[0].length];

            for (int i = 0; i < prev.length; i++) {
                for (int j = 0; j < prev[i].length; j++) {
                    if (prev[i][j] == '.') {
                        curr[i][j] = '.';
                        continue;
                    }
                    int cnt = 0;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (-1 < i-k && i-k < prev.length) if (-1 < j-l && j-l < prev[0].length)
                                cnt += prev[i-k][j-l] == '#' ? 1 : 0;
                        }
                    }
                    cnt -= prev[i][j] == '#' ? 1 : 0;
                    if (cnt == 0) curr[i][j] = '#';
                    else if (cnt >= 4) curr[i][j] = 'L';
                    else curr[i][j] = prev[i][j];
                }
            }
        }

        for (int i = 0; i < prev.length; i++) {
            for (int j = 0; j < prev[i].length; j++) {
                res += curr[i][j] == '#' ? 1 : 0;
            }
        }

        System.out.println(res);
    }

    static boolean equals(char[][] a, char[][] b) {
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) return false;
        }
        return true;
    }
}

