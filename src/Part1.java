import java.io.*;
import java.util.Random;

public class Part1 {

    static final String OUTPUT = "task1_output.csv";
    static int k;
    static int t;

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            k = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        } else {
            k = 5;
            t = 6;
        }
        Random rng = new Random();
        Writer wTests = new OutputStreamWriter(new FileOutputStream(OUTPUT), "Cp1251");
        for (int i = 1; i < t + 1; i++) {
            wTests.write(";");
            wTests.write(Integer.toString(rng.nextInt(8) + 7));
        }
        wTests.write(System.lineSeparator());
        for (int i = 1; i < t + 1; i++) {
            wTests.write(";Test_" + i);
        }
        wTests.write(System.lineSeparator());
        for (int i = 1; i < k + 1; i++) {
            wTests.write("Lastname_" + i);
            for (int j = 1; j < t + 1; j++) {
                wTests.write(";");
                int rng1 = rng.nextInt(100);
                if (rng1 % 5 != 0)
                    wTests.write(Integer.toString(rng1));
            }
            if (i != k) wTests.write(System.lineSeparator());
        }
        wTests.close();
    }
}
