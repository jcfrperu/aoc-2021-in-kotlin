import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 implements Solution {

    public static void main(String[] args) throws Exception {
//        String inputFile = "src/inputs/Day03_test.txt";
        String inputFile = "src/inputs/Day03.txt";

        U.executePart01(Day03.class, inputFile);
//        U.executePart02(Day03.class, inputFile);
    }

    @Override
    public void solvePart02(String inputFile) throws Exception {

        List<String> linesInput = U.readInput(inputFile);

        int oxygen = iterate(linesInput, '1', '0');
        int co2 = iterate(linesInput, '0', '1');

        U.println(oxygen * co2);
    }

    private int iterate(List<String> linesInput, char char01, char char02) {

        List<String> lines = new ArrayList<>(linesInput);

        int result = 0;
        for (int i = 0; i < linesInput.size(); i++) {

            final int fi = i;
            final long ones = lines.stream().filter(it -> it.charAt(fi) == '1').count();
            final long zeros = (long) lines.size() - ones;

            if (ones >= zeros) {
                lines = lines.stream().filter(it -> it.charAt(fi) == char01).collect(Collectors.toList());
            } else {
                lines = lines.stream().filter(it -> it.charAt(fi) == char02).collect(Collectors.toList());
            }

            if (lines.size() == 1) {
                result = toInteger(lines.get(0));
                break;
            }
        }

        return result;
    }

    @Override
    public void solvePart01(String inputFile) throws Exception {

        List<String> lines = U.readInput(inputFile);

        int lineWidth = lines.get(0).length();

        int gamma = 0;
        int epsilon = 0;

        int factor = 1; // 1, 2, 4, 8, 16, 32, 64 ...

        for (int i = lineWidth - 1; i >= 0; i--) {

            final int fi = i;
            final long ones = lines.stream().filter(it -> it.charAt(fi) == '1').count();
            final long zeros = (long) lines.size() - ones;

            if (ones == zeros) {
                throw new RuntimeException("strange case: number of ones and zeros are equal");
            } else if (ones > zeros) {
                gamma += factor;
            } else {
                epsilon += factor;
            }

            factor *= 2;
        }

        U.println(gamma * epsilon);
    }

    private int toInteger(String binary) {
        int result = 0;
        int factor = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += factor;
            }
            factor *= 2;
        }
        return result;
    }
}
