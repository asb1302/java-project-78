package hexlet.code.constraints;

public final class Required implements Constraint {
    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return false;
        }

        return !(value instanceof String) || !value.equals("");
    }
}
