package hexlet.code.constraints;

public final class IsNumber implements Constraint {
    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return true;
        }

        return value instanceof Integer;
    }
}
