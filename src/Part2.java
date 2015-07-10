import java.io.*;

public class Part2 {
    static final String INPUT = "task1_output.csv";
    static final String OUTPUT = "task2_output.csv";

    public static void main(String[] args) throws IOException {
        Data.fill(INPUT);
        Writer wTests = new OutputStreamWriter(new FileOutputStream(OUTPUT), "Cp1251");
        System.out.println(Data.header1);
        System.out.println(Data.header2);
        for (int i = 0; i < Data.tests.size(); i++) {
            wTests.write(";");
            wTests.write(Integer.toString(Data.questionsCount.get(i)));
        }
        wTests.write(System.lineSeparator());
        for (int i = 1; i < Data.tests.size() + 1; i++) {
            wTests.write(";Test_" + i);
        }
        wTests.write(System.lineSeparator());
        for (int i = 0; i < Data.marks.length; i++) {
            System.out.print("Lastname_" + (i + 1));
            wTests.write("Lastname_" + (i + 1));
            for (int j = 0; j < Data.marks[0].length; j++) {
                int markOnTest = Data.marks[i][j];
                int curQC = Data.questionsCount.get(j);

                //gen possible sequence
                int closestMark = 0;
                int closestDist = 100;
                for (int k = 0; k < curQC + 1; k++) {
                    int numInSeq = Math.round((float) k / curQC * 100);
                    int curNumberDist = Math.abs(markOnTest - numInSeq);
                    if (curNumberDist < closestDist) {
                        closestDist = curNumberDist;
                        closestMark = numInSeq;
                    }
                }
                if (markOnTest != 0) System.out.print("; " + markOnTest + " -> " + closestMark);
                else System.out.print("; skip   ");

                wTests.write(";");
                if (markOnTest != 0) wTests.write(Integer.toString(closestMark));
            }
            if (i != Data.marks.length - 1) {
                wTests.write(System.lineSeparator());
            }
            System.out.println();
        }
        wTests.close();
    }
}
