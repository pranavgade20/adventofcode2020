import java.io.FileReader;
import java.util.Scanner;

public class Day17_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-17"));

        byte[][][][] curr = new byte[25][25][25][25];

        int inY = 8;
        while (s.hasNext()){
            int x = 8;
            for (char c : s.nextLine().toCharArray()) {
                curr[x++][inY][8][8] = (byte) (c == '#' ? 1 : 0);
            }
            inY++;
        }

        for (int t = 0; t < 6; t++) {
            byte[][][][] next = new byte[25][25][25][25];
            for (int x = 0; x < curr.length; x++) {
                for (int y = 0; y < curr[0].length; y++) {
                    for (int z = 0; z < curr[0][0].length; z++) {
                        for (int w = 0; w < curr[0][0][0].length; w++) {
                            int neighbors = getNeighbors(x, y, z, w, curr);
                            if (curr[x][y][z][w] == 0 && neighbors == 3) next[x][y][z][w] = 1;
                            if (curr[x][y][z][w] == 1) if (neighbors == 3 || neighbors == 2) next[x][y][z][w] = 1;

                        }
                    }
                }
            }
            curr = next;
        }

        int ret = 0;
        for (int x = 0; x < curr.length; x++) {
            for (int y = 0; y < curr[0].length; y++) {
                for (int z = 0; z < curr[0][0].length; z++) {
                    for (int w = 0; w < curr[0][0][0].length; w++) {
                        ret += curr[x][y][z][w];
                    }
                }
            }
        }
        System.out.println(ret);
    }

    static int getNeighbors(int X, int Y, int Z, int W, byte[][][][] space) {
        int ret = -space[X][Y][Z][W];
        for (int x = X-1; x <= X+1; x++) {
            if (x < 0 || x >= space.length) continue;
            for (int y = Y-1; y <= Y+1; y++) {
                if (y < 0 || y >= space[x].length) continue;
                for (int z = Z-1; z <= Z+1; z++) {
                    if (z < 0 || z >= space[x][y].length) continue;
                    for (int w = W-1; w <= W+1; w++) {
                        if (w < 0 || w >= space[x][y][z].length) continue;
                        ret += space[x][y][z][w];
                    }
                }
            }
        }
        return ret;
    }
}

