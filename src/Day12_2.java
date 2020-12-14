import java.io.FileReader;
import java.util.Scanner;

public class Day12_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-12"));

        long[] ship = new long[2];
        long[] waypoint = {10, 1};
        while (s.hasNext()){
            String line = s.nextLine();
            switch (line.charAt(0)) {
                case 'N':
                    waypoint[1] += Integer.parseInt(line.substring(1));
                    break;
                case 'S':
                    waypoint[1] -= Integer.parseInt(line.substring(1));
                    break;
                case 'E':
                    waypoint[0] += Integer.parseInt(line.substring(1));
                    break;
                case 'W':
                    waypoint[0] -= Integer.parseInt(line.substring(1));
                    break;
                case 'R':
                case 'L':
                    waypoint = getTurn(line, ship, waypoint);
                    break;
                case 'F':
                    long times = Integer.parseInt(line.substring(1));
                    ship[0] += (waypoint[0])*times;
                    ship[1] += (waypoint[1])*times;
                    break;
            }
        }

        System.out.println(ship[0]);
        System.out.println(ship[1]);
        System.out.println(-ship[1]-ship[0]);
    }

    static long[] getTurn(String st, long[] ship, long[] waypoint) {
        long deg = Integer.parseInt(st.substring(1));
        deg %= 360;
        if (st.charAt(0) == 'R') {
            deg = 360-deg;
        }
        while (deg > 0) {
            deg -= 90;
            long temp = waypoint[0];
            waypoint[0] = -waypoint[1];
            waypoint[1] = temp;
        }
        return waypoint;
    }
}

