import java.util.List;

public class Tools{
    public static <T> void forEach(List<T> list,Consumer<T> c){
        for (T t:
             list) {
            c.accept(t);
        }
    }
}
