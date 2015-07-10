import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    static ArrayList<Integer> questionsCount;
    static ArrayList<String> tests;
    static int[][] marks;
    static int[][] marksFixed;
    static String header1;
    static String header2;

    public static void fill(String Source) throws IOException {
        if (Source.length() == 0) return;
        List<String> raw = Files.readAllLines(Paths.get(Source),
                Charset.forName("Cp1251"));
        ArrayList<String> questionsStr;
        questionsStr = new ArrayList<>(Arrays.asList(raw.get(0).split(";")));
        questionsStr.remove(0);
        header1 = raw.get(0);
        questionsCount = new ArrayList<>();
        for (String s : questionsStr) {
            questionsCount.add(Integer.parseInt(s));
        }
        tests = new ArrayList<>(Arrays.asList(raw.get(1).split(";")));
        tests.remove(0);
        header2 = raw.get(1);

        int y = raw.size() - 2;
        int x = questionsStr.size();
        marks = new int[y][x];
        marksFixed = new int[y][x];
        for (int i = 0; i < y; i++) {
            ArrayList<String> tmp = new ArrayList<>(Arrays.asList(raw.get(i + 2).split(";")));
            tmp.remove(0);
            ArrayList<String> student = new ArrayList<>();
            if (questionsCount.size() > tmp.size()) {
                for (int j = 0; j < questionsCount.size(); j++) {
                    if (j < tmp.size()) {
                        student.add(tmp.get(j));
                    } else {
                        student.add("");
                    }
                }
            } else {
                student = tmp;
            }
//            System.out.println(student);//debug
            for (int j = 0; j < x; j++) {
                if (student.get(j).length() != 0) {
                    marks[i][j] = Integer.parseInt(student.get(j));
                    //for task4+
                    marksFixed[i][j] = Integer.parseInt(student.get(j));
                } else {
                    marksFixed[i][j] = -1;
                }
            }
        }
    }
}
