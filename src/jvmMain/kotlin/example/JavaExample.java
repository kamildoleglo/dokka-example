package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Java example
 */
public class JavaExample extends JavaBaseExample {

    public JavaExample(String a) {
        super(a);
    }

    /**
     * Funkcja przeładowana nicnierobiąca
     * @param a ddd
     * @param b ddd
     */
    @Override
    protected List<String> cokolwiek(String a, House b) {
        return new ArrayList<String>();
    }

    protected void tralala() {}

    private void Mytralala() {}
}
