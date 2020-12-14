import java.io.FileReader;
import java.util.Scanner;

public class Day12_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-12"));

        char facing = 'E';
        int x = 0, y = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            switch (line.charAt(0)) {
                case 'N':
                    x += Integer.parseInt(line.substring(1));
                    break;
                case 'S':
                    x -= Integer.parseInt(line.substring(1));
                    break;
                case 'E':
                    y += Integer.parseInt(line.substring(1));
                    break;
                case 'W':
                    y -= Integer.parseInt(line.substring(1));
                    break;
                case 'R':
                case 'L':
                    facing = getTurn(line, facing);
                    break;
                case 'F':
                    switch (facing) {
                        case 'N':
                            x += Integer.parseInt(line.substring(1));
                            break;
                        case 'S':
                            x -= Integer.parseInt(line.substring(1));
                            break;
                        case 'E':
                            y += Integer.parseInt(line.substring(1));
                            break;
                        case 'W':
                            y -= Integer.parseInt(line.substring(1));
                            break;
                    }
                    break;
            }
        }

        System.out.println(x);
        System.out.println(y);
        System.out.println(x-y);
    }

    static char getTurn(String st, char facing) {
        int deg = Integer.parseInt(st.substring(1));
        deg %= 360;
        if (st.charAt(0) == 'L') {
            deg = 360-deg;
        }
        while (deg > 0) {
            deg -= 90;
            switch (facing) {
                case 'N':
                    facing = 'E';
                    break;
                case 'E':
                    facing = 'S';
                    break;
                case 'S':
                    facing = 'W';
                    break;
                case 'W':
                    facing = 'N';
                    break;
            }
        }
        return facing;
    }
}

