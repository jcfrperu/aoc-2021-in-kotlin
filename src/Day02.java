import java.util.List;

public class Day02 implements Solution {

    public static void main(String[] args) throws Exception {
//        String inputFile = "src/inputs/Day02_test.txt";
        String inputFile = "src/inputs/Day02.txt";

//        U.executePart01(Day02.class, inputFile);
        U.executePart02(Day02.class, inputFile);
    }

    @Override
    public void solvePart02(String inputFile) throws Exception {
        List<String> lines = U.readInput(inputFile);

        int aim = 0;
        int horizontal = 0;
        int depth = 0;
        for (String instruction : lines) {
            if (instruction.startsWith("forward ")) {

                int x = U.toInt(instruction.split(" ")[1]);

                horizontal += x;
                depth += aim * x;

            } else if (instruction.startsWith("up ")) {
                aim -= U.toInt(instruction.split(" ")[1]);
            } else if (instruction.startsWith("down ")) {
                aim += U.toInt(instruction.split(" ")[1]);
            } else {
                throw new RuntimeException("instruction not recognized " + instruction);
            }
        }

        U.println(horizontal * depth);
    }


    @Override
    public void solvePart01(String inputFile) throws Exception {

        List<String> lines = U.readInput(inputFile);

        int upDown = 0;
        int forward = 0;
        for (String instruction : lines) {
            if (instruction.startsWith("forward ")) {
                forward += U.toInt(instruction.split(" ")[1]);
            } else if (instruction.startsWith("up ")) {
                upDown -= U.toInt(instruction.split(" ")[1]);
            } else if (instruction.startsWith("down ")) {
                upDown += U.toInt(instruction.split(" ")[1]);
            } else {
                throw new RuntimeException("instruction not recognized " + instruction);
            }
        }

        U.println(forward * upDown);
    }
}
