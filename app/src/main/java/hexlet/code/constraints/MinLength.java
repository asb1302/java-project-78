package hexlet.code.constraints;

public final class MinLength implements Constraint {
    private final int minLength;

    public MinLength(int min) {
        this.minLength = min;
    }
    @Override
    public boolean validate(Object value) {
        return ((String) value).length() >= this.minLength;
    }
}
