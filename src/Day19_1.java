import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day19_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-19"));

        int res = 0;
        HashMap<Integer, int[][]> adj_list = new HashMap<>();
        HashMap<Integer, Character> endings = new HashMap<>();

        String line;
        while (!(line = s.nextLine()).isEmpty()){
            if (line.contains("\"")) {
                endings.put(Integer.parseInt(line.split(":")[0]), line.charAt(line.indexOf("\"")+1));
            } else {
                int n = Integer.parseInt(line.split(":")[0]);
                ArrayList<int[]> rules = new ArrayList<>();
                for (String st : line.split(": ")[1].split(" \\| ")) {
                    if (st.contains(" ")) {
                        rules.add(new int[]{Integer.parseInt(st.split(" ")[0]), Integer.parseInt(st.split(" ")[1])});
                    } else rules.add(new int[]{Integer.parseInt(st)});
                }
                adj_list.put(n, rules.toArray(new int[][]{}));
            }
        }

        while (s.hasNext()) {
            line = s.nextLine();
            int r = dfs(line, 0, 0, adj_list, endings);
            if (r == line.length()) res++;
        }
        System.out.println(res);
    }

    public static int dfs(String query, int start, int ruleNum, HashMap<Integer, int[][]> adj_list, HashMap<Integer, Character> endings) {
        if (endings.containsKey(ruleNum)) {
            if (query.charAt(start) == endings.get(ruleNum)) return start+1;
            else return -1;
        }
        for (int[] rule : adj_list.get(ruleNum)) {
            int temp = start;
            for (int num : rule) {
                int r = dfs(query, temp, num, adj_list, endings);
                if (r == -1) {
                    temp = -1;
                    break;
                }
                else temp = r;
            }
            if (temp != -1) return temp;
        }
        return -1;
    }
}

