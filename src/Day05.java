import java.util.ArrayList;
import java.util.List;

public class Day05 implements Solution {

    public static void main(String[] args) throws Exception {
        String inputFile = "src/inputs/Day05_test.txt";
//        String inputFile = "src/inputs/Day05.txt";

        U.executePart01(Day05.class, inputFile);
//        U.executePart02(Day05.class, inputFile);
    }

    @Override
    public void solvePart02(String inputFile) throws Exception {

        List<String> linesInput = U.readInput(inputFile);

    }

    @Override
    public void solvePart01(String inputFile) throws Exception {

        List<String> inputLines = U.readInput(inputFile);
        List<Line> lines = readLines(inputLines);
        System.out.println(lines);
    }

    public List<Line> readLines(List<String> inputLines) {

        List<Line> lines = new ArrayList<>();
        for (String inputLine : inputLines) {
            String[] split = inputLine.split("->");
            String[] point01Str = split[0].split(",");
            String[] point02Str = split[1].split(",");

            lines.add(new Line(
                    new Point(U.toInt(point01Str[0]), U.toInt(point01Str[1])),
                    new Point(U.toInt(point02Str[0]), U.toInt(point01Str[1]))));
        }

        return lines;
    }

    static class Grid {
        int[][] values;

        Grid(int[][] values) {
            this.values = values;
        }
    }

    static class Line {
        Point init;
        Point end;

        public Line(Point init, Point end) {
            this.init = init;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "init=" + init +
                    ", end=" + end +
                    '}';
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
