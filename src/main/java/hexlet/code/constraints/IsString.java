package hexlet.code.constraints;

public final class IsString implements Constraint {
    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return true;
        }

        return value instanceof String;
    }
}
