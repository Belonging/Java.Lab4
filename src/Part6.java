import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part6 {
    static final String INPUT = "task2_output.csv";

    public static void main(String[] args) throws IOException {
        Data.fill(INPUT);
        int x = Data.marksFixed[0].length;
        int y = Data.marksFixed.length;
        List<Integer> nonSortAvgs = new ArrayList<>();
        int avg;
        for (int i = 0; i < x; i++) {
            int sum = 0;
            for (int j = 0; j < y; j++) {
                sum += Data.marks[j][i];
            }
            avg = Math.round((float) sum / y);
            nonSortAvgs.add(avg);
        }
//        System.out.println(nonSortAvgs);//debug
        List<Integer> sortAvgs = new ArrayList<>(nonSortAvgs);
        Collections.sort(sortAvgs);
//        System.out.println(sortAvgs);//debug
        List<Integer> toSkipOuter = new ArrayList<>();
        for (int i = x - 1; i > -1; i--) {
            List<Integer> toSkipInner = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                if (sortAvgs.get(i).equals(nonSortAvgs.get(j)) && !toSkipOuter.contains(sortAvgs.get(i))) {
                    toSkipInner.add(sortAvgs.get(i));
                    System.out.println("Test_" + (j + 1) + " ==> " + nonSortAvgs.get(j));
                }
            }
            toSkipOuter.addAll(toSkipInner);
        }
    }
}
