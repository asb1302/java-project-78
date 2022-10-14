package hexlet.code.schemas;

public final class StringSchema extends BaseSchema implements Schema {
    public StringSchema required() {
        this.addConstraint(new Required());

        return this;
    }

    public StringSchema() {
        this.addConstraint(new IsString());
    }

    public StringSchema contains(String substr) {
        this.addConstraint(new Contains(substr));

        return this;
    }

    public StringSchema minLength(int min) {
        this.addConstraint(new MinLength(min));

        return this;
    }

    private static final class IsString implements Constraint {
        public boolean validate(Object value) {
            if (value == null) {
                return true;
            }

            return value instanceof String;
        }
    }

    private static final class Required implements Constraint {
        public boolean validate(Object value) {
            if (value == null) {
                return false;
            }

            return !(value instanceof String && ((String) value).isEmpty());
        }
    }

    private static final class Contains implements Constraint {
        private final String substring;
        Contains(String substr) {
            this.substring = substr;
        }
        public boolean validate(Object value) {
            return ((String) value).contains(this.substring);
        }
    }

    private static final class MinLength implements Constraint {
        private final int minLength;

        MinLength(int min) {
            this.minLength = min;
        }
        public boolean validate(Object value) {
            return ((String) value).length() >= this.minLength;
        }
    }
}
