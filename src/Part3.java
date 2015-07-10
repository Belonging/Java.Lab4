import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part3 {
    static final String INPUT = "task2_output.csv";

    public static void main(String[] args) throws IOException {
        Data.fill(INPUT);
        int x = Data.marks[0].length;
        int y = Data.marks.length;
        List<Integer> nonSortAvgs = new ArrayList<>();
        int avg;
        for (int i = 0; i < y; i++) {
            int sum = 0;
            for (int j = 0; j < x; j++) {
                sum += Data.marks[i][j];
            }
            avg = Math.round((float) sum / x);
            nonSortAvgs.add(avg);
        }
//        System.out.println(nonSortAvgs);//debug
        List<Integer> sortAvgs = new ArrayList<>(nonSortAvgs);
        Collections.sort(sortAvgs);
//        System.out.println(sortAvgs);//debug
        List<Integer> toSkipOuter = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            List<Integer> toSkipInner = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                if (sortAvgs.get(i).equals(nonSortAvgs.get(j)) && !toSkipOuter.contains(sortAvgs.get(i))) {
                    toSkipInner.add(sortAvgs.get(i));
                    System.out.println("Lastname_" + (j + 1) + " ==> " + nonSortAvgs.get(j));
                }
            }
            toSkipOuter.addAll(toSkipInner);
        }
    }
}
