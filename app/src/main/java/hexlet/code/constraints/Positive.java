package hexlet.code.constraints;

public final class Positive implements Constraint {
    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return true;
        }

        return (Integer) value > 0;
    }
}
