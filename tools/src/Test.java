import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,23,4,5,5,6);
        Tools.forEach(list, i -> System.out.println(i));
    }
}
