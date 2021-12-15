import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Day01 implements Solution {

    public static void main(String[] args) throws Exception {
//        String inputFile = "src/inputs/Day01_test.txt";
        String inputFile = "src/inputs/Day01.txt";

//        U.executePart01(Day01.class, inputFile);
        U.executePart02(Day01.class, inputFile);
    }

    @Override
    public void solvePart02(String inputFile) throws Exception {

        List<String> lines = U.readInput(inputFile);

        Map<String, Integer> map = new LinkedHashMap<>();

        iterate(0, lines, map);
        iterate(1, lines, map);
        iterate(2, lines, map);
        iterate(3, lines, map);

        int maxKeyCounter = map.keySet().stream()
                .filter(it -> it.startsWith("s"))
                .map(it -> it.replace("s", ""))
                .mapToInt(Integer::parseInt)
                .max()
                .orElseThrow(() -> new RuntimeException("There's no item in maps"));

//        for (int i = 0; i <= maxKeyCounter; i++) {
//            System.out.printf("%s = %d%n", "s" + i, map.get("s" + i));
//        }

        int counter = 0;
        for (int i = 1; i <= maxKeyCounter; i++) {
            if (map.get("s" + i) > map.get("s" + (i - 1))) {
                counter++;
            }
        }
        U.println(counter);
    }

    private void iterate(int keyCounterStarts, List<String> lines, Map<String, Integer> map) {

        final int MODULE = 3;

        int moduleCounter = 0;
        int keyCounter = keyCounterStarts;

        for (int i = keyCounterStarts; i < lines.size(); i++) {
            String key = "k" + keyCounter;
            if (map.get(key) == null) {
                map.put(key, U.toInt(lines.get(i)));
            } else {
                map.put(key, map.get(key) + U.toInt(lines.get(i)));
            }

            moduleCounter++;
            if (moduleCounter == MODULE) {
                map.put("s" + keyCounter, map.get(key)); // save the actual value (3 sums)

                i++;
                moduleCounter = 0;
                keyCounter += (MODULE + 1);
            }
        }
    }

    @Override
    public void solvePart01(String inputFile) throws Exception {

        List<String> lines = U.readInput(inputFile);

        int counter = 0;
        for (int i = 1; i < lines.size(); i++) {
            if (U.toInt(lines.get(i)) > U.toInt(lines.get(i - 1))) {
                counter++;
            }
        }
        U.println(counter);
    }
}
