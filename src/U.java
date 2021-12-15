import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class U {

    public static List<String> readInput(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            return IOUtils.readLines(fis, StandardCharsets.UTF_8);
        }
    }

    public static int toInt(String value) {
        return Integer.parseInt(value.trim());
    }

    public static void println(Object value) {
        System.out.println(value);
    }

    public static int getIntValue(Map<String, Integer> map, String key, int defaultValueIfNull) {
        Integer value = map.get(key);
        return value == null ? defaultValueIfNull : value;
    }

    public static void executePart01(Class clazz, String inputFile) throws Exception {
        Solution solution = (Solution) clazz.newInstance();
        System.out.println("\n\n\nSTART OF THE PROGRAM");
        long init = System.currentTimeMillis();
        solution.solvePart01(inputFile);
        long timeElapsed = System.currentTimeMillis() - init;
        System.out.printf("END OF THE PROGRAM: %.2f seconds\n\n\n", (timeElapsed / 1000.0));
    }

    public static void executePart02(Class clazz, String inputFile) throws Exception {
        Solution solution = (Solution) clazz.newInstance();
        System.out.println("\n\n\nSTART OF THE PROGRAM");
        long init = System.currentTimeMillis();
        solution.solvePart02(inputFile);
        long timeElapsed = System.currentTimeMillis() - init;
        System.out.printf("END OF THE PROGRAM: %.2f seconds\n\n\n", (timeElapsed / 1000.0));
    }
}
