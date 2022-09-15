package hexlet.code.constraints;

public final class Range implements Constraint {
    private final Integer minimum;
    private final Integer maximum;

    public Range(Integer min, Integer max) {
        this.minimum = min;
        this.maximum = max;
    }
    @Override
    public boolean validate(Object value) {
        return (Integer) value >= minimum && (Integer) value <= maximum;
    }
}
