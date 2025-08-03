package br.com.dio.model;

public class Space {

    private Integer actual;
    private final int expected;
    private final boolean fixed;

    public Space(final int expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;
        if (fixed){
            actual = expected;
        }
    }

    public Space(int expected, int i, int j) {
        // Initialize 'expected' with the provided value
        this.expected = expected;
        // Assume 'fixed' is true for spaces initialized with expected values and coordinates
        this.fixed = (expected != 0); // Assuming 0 means an empty/non-fixed space initially
        if (this.fixed) {
            this.actual = expected;
        } else {
            this.actual = null; // Or some default for non-fixed, empty spaces
        }
    }

    public Integer getValue() {
        return actual;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(final Integer actual) {
        if (fixed) return;
        this.actual = actual;
    }

    public void clearSpace(){
        setActual(null);
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isCorrect() {
        return actual != null && actual.equals(expected);
    }

    public boolean isEmpty() {
        return actual == null;
    }
}