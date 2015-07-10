import java.io.IOException;
import java.util.ArrayList;

public class Part5 {
    static final String INPUT = "task2_output.csv";

    public static void main(String[] args) throws IOException {
        Data.fill(INPUT);
        int x = Data.marksFixed[0].length;
        int y = Data.marksFixed.length;
        //amount of tests skipped by stud #index
        int[] countSkipTests = new int[y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (Data.marksFixed[i][j] == -1) {
                    countSkipTests[i]++;
                }
            }
//            System.out.print(countSkipTests[i] + " ");//debug
        }
//        System.out.println();//debug
        int max = -1;
        for (int i : countSkipTests) {
            if (i > max) max = i;
        }
        //from all tests skipped to 0 tests
        for (int i = x; i > -1; i--) {
            //look over countSkipTests to find index of student skipped i tests
            for (int j = 0; j < y; j++) {
                if (i == countSkipTests[j]) {
                    System.out.print("Lastname_" + (j + 1) + " -> " + countSkipTests[j]);
                    ArrayList<String> tmp = new ArrayList<>();
                    for (int k = 0; k < x; k++) {
                        if (Data.marksFixed[j][k] == -1) {
                            tmp.add("Test_" + (k + 1));
                        }
                    }
                    if (countSkipTests[j] != 0) System.out.println(": " + tmp);
                    else System.out.println();
                }
            }
        }
    }
}
