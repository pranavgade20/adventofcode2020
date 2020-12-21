import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day21_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-21"));

        int res = 0;

        HashSet<String>[] foods = new HashSet[38];
        HashSet<String>[] allergens = new HashSet[38];
        HashMap<String, HashSet<Integer>> allergen = new HashMap<>();
        HashMap<Integer, HashSet<String>> food = new HashMap<>();
        int a = 0;
        while (s.hasNext()){
            String line = s.nextLine();
            foods[a] = new HashSet<>(Arrays.asList(line.split("\\|")[0].split(" ")));
            allergens[a] = new HashSet<>(Arrays.asList(line.split("\\|")[1].split(", ")));

            for (String f : foods[a]) {
                if (!food.containsKey(a)) food.put(a, new HashSet<>());
                food.get(a).add(f);
            }

            for (String f : allergens[a]) {
                if (!allergen.containsKey(f)) allergen.put(f, new HashSet<>());
                allergen.get(f).add(a);
            }

            a++;
        }

        HashMap<String, String> contains = new HashMap<>();
        for (int i = 0; i < allergen.size()*2; i++) allergen.entrySet().removeIf((n) -> {
            HashSet<Integer> positions = n.getValue();
            HashSet<String> possibleFoods = new HashSet(food.get(positions.iterator().next()));
            for (Integer pos : positions) {
                possibleFoods.retainAll(food.get(pos));
            }
            if (possibleFoods.size() == 1) {
                food.forEach((x,y) -> y.remove(possibleFoods.iterator().next()));
                contains.put(possibleFoods.iterator().next(), n.getKey());
                return true;
            }
            return false;
        });

        System.out.println(contains.entrySet().stream().sorted(Map.Entry.comparingByValue()).map((Map.Entry::getKey)).reduce((s1, s2) -> s1+","+s2));
    }
}

