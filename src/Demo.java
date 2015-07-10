import java.io.IOException;

public class Demo {
    public static final int k = 5;
    public static final int t = 6;

    public static void main(String[] args) throws IOException {
        Part1.main(new String[]{Integer.toString(k), Integer.toString(t)});
        System.out.println("Part1, 2");
        Part2.main(new String[]{});
        System.out.println("Part3");
        Part3.main(new String[]{});
        System.out.println("Part4");
        Part4.main(new String[]{});
        System.out.println("Part5");
        Part5.main(new String[]{});
        System.out.println("Part6");
        Part6.main(new String[]{});
    }
}
