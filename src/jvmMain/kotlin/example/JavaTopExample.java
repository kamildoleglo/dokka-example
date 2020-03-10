package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Java example
 */
public class JavaTopExample<T> extends JavaExample {

    private T example;

    public JavaTopExample(String a) {
        super(a);
    }

    /**
     * Funkcja <b>super</b> <p>przeładowana</p> nicnierobiąca {@link House#addFloor() house} {@link String string}
     * @see JavaBaseExample
     *
     * @author Blazej
     * @see JavaBaseExample#baozwa() test
     * @param a Januszek {@link House house}
     * @param b Januszek
     * @return list of String
     * @deprecated
     */
    @Override
    protected List<String> cokolwiek(String a, House b) {
        return new ArrayList<String>();
    }

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }
}
