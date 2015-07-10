import java.io.IOException;
import java.util.ArrayList;

public class Part4 {
    static final String INPUT = "task2_output.csv";

    public static void main(String[] args) throws IOException {
        Data.fill(INPUT);
        int x = Data.marksFixed[0].length;
        int y = Data.marksFixed.length;
        //amount of studs skipped test #index
        int[] countSkip = new int[x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (Data.marksFixed[j][i] == -1) {
                    countSkip[i]++;
                }
            }
//            System.out.print(countSkip[i] + " ");//debug
        }
//        System.out.println();//debug
        int max = -1;
        for (int i : countSkip) {
            if (i > max) max = i;
        }
        //from all studs skipped to 1 stud
        for (int i = y; i > 0; i--) {
            //look over countSkip to find index of test skipped by i studs
            for (int j = 0; j < x; j++) {
                if (i == countSkip[j]) {
                    System.out.print("Test_" + (j + 1) + " -> ");
                    ArrayList<String> tmp = new ArrayList<>();
                    for (int k = 0; k < y; k++) {
                        if (Data.marksFixed[k][j] == -1) {
                            tmp.add("Lastname_" + (k + 1));
                        }
                    }
                    System.out.println(tmp);
                }
            }
        }
    }
}
