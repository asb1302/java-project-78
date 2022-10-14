package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema implements Schema {
    public NumberSchema() {
        this.addConstraint(new IsNumber());
    }

    public NumberSchema required() {
        this.addConstraint(new Required());

        return this;
    }

    public NumberSchema positive() {
        this.addConstraint(new Positive());

        return this;
    }

    public NumberSchema range(int min, int max) {
        this.addConstraint(new Range(min, max));

        return this;
    }

    private static final class IsNumber implements Constraint {
        public boolean validate(Object value) {
            if (value == null) {
                return true;
            }

            return value instanceof Integer;
        }
    }

    private static final class Required implements Constraint {
        public boolean validate(Object value) {
            return value != null;
        }
    }

    private static final class Positive implements Constraint {
        public boolean validate(Object value) {
            if (value == null) {
                return true;
            }

            return (Integer) value > 0;
        }
    }

    private static final class Range implements Constraint {
        private final Integer minimum;
        private final Integer maximum;

        Range(Integer min, Integer max) {
            this.minimum = min;
            this.maximum = max;
        }
        public boolean validate(Object value) {
            return (Integer) value >= minimum && (Integer) value <= maximum;
        }
    }
}
