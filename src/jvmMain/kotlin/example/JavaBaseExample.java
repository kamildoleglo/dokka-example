package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Java example
 */
public class JavaBaseExample {

    /**
     * Jakieś randomowe property
     */
    public String aa;

    public JavaBaseExample(String a) {
        aa = a;
    }

    /**
     * Funkcja nicnierobiąca
     */
    protected List<String> cokolwiek(String a, House b) {
        return new ArrayList<String>();
    }

    /**
     * Funkcja nicnierobiąca2
     */
    public List<String> cokolwiek2(String a, House b) {
        return new ArrayList<String>();
    }

    class JavaExampleSubClass {

        public void Cokolwiek2(ParticularClock clock) {

        }
    }

    public void baozwa() {}
}
