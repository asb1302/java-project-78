package hexlet.code.constraints;

import java.util.Map;

public final class SizeOf implements Constraint {
    private final Integer size;

    public SizeOf(Integer s) {
        this.size = s;
    }

    @Override
    public boolean validate(Object value) {
        return ((Map<?, ?>) value).size() == this.size;
    }
}
