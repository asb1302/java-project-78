package hexlet.code.constraints;

public final class Positive implements Constraint {
    @Override
    public boolean validate(Object value) {
        return (Integer) value > 0;
    }
}
