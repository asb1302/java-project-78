package hexlet.code.constraints;

import java.util.Map;

public final class IsMap implements Constraint {
    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return true;
        }

        return value instanceof Map<?, ?>;
    }
}
