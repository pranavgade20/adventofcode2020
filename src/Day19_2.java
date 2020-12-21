import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day19_2 {
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
        int[][] spl8 = new int[11][];
        for (int i = 0; i < spl8.length; i++) {
            spl8[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                spl8[i][j] = 42; // afterthought: shoulda used Arrays.fill
            }
        }
        int[][] spl11 = new int[11][];
        for (int i = 0; i < spl11.length; i++) {
            spl11[i] = new int[2*i+2];
            for (int j = 0; j < i+1; j++) {
                spl11[i][j] = 42;
            }
            for (int j = i+1; j < spl11[i].length; j++) {
                spl11[i][j] = 31;
            }
        }
        adj_list.put(8, spl8);
        adj_list.put(11, spl11);

        while (s.hasNext()) {
            line = s.nextLine();
            String finalLine = line;
            int r = dfs(line, 0, 0, adj_list, endings).stream().filter(node -> node.pos+1 == finalLine.length()).collect(Collectors.toList()).size();
            if (r > 0) {
                System.out.println(line);
                res++;
            }
        }
        System.out.println(res);
    }

    public static List<Node> dfs(String query, int start, int ruleNum, HashMap<Integer, int[][]> adj_list, HashMap<Integer, Character> endings) {
        if (start >= query.length()) return Collections.emptyList();
        if (endings.containsKey(ruleNum)) {
            if (query.charAt(start) == endings.get(ruleNum)) return Collections.singletonList(new Node(start+1));
            else return Collections.emptyList();
        }

        List<Node> ret = new ArrayList<>();
        for (int[] rule : adj_list.get(ruleNum)) {
            List<Node> temp = Collections.singletonList(new Node(start));
            for (int num : rule) {
                for (Node node : temp) {
                    List<Node> r = dfs(query, node.pos, num, adj_list, endings);
                    node.addChildren(r);
                }
                temp = temp.stream().map(Node::getChildren).flatMap(Collection::stream).collect(Collectors.toList());
                temp.removeIf(n -> n.pos == -1 || n.pos > query.length());
                if (temp.size() == 0) break;
            }
            ret.addAll(temp);
        }
        return ret;
    }
}

class Node {
    int pos;
    LinkedList<Node> children;
    Node (int pos) {
        this.pos = pos;
        children = new LinkedList<>();
    }

    Node addChild(int offset) {
        Node ret = new Node(pos + offset);
        children.add(ret);
        return ret;
    }

    void addChildren(List<Node> children) {
        this.children.addAll(children);
    }

    List<Node> getChildren() {
        return children.size() == 0 ? Collections.singletonList(this) : children.stream().map(Node::getChildren).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Node{" +
                "pos=" + pos +
                ", children=" + children.toString() +
                '}';
    }
}