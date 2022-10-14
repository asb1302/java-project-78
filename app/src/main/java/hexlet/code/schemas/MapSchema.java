package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema implements Schema {
    public MapSchema required() {
        this.addConstraint(new Required());

        return this;
    }
    public MapSchema() {
        this.addConstraint(new IsMap());
    }

    public MapSchema sizeof(int size) {
        this.addConstraint(new SizeOf(size));

        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.addConstraint(new Shape(schemas));

        return this;
    }

    private static final class IsMap implements Constraint {
        public boolean validate(Object value) {
            if (value == null) {
                return true;
            }

            return value instanceof Map<?, ?>;
        }
    }

    private static final class Required implements Constraint {
        public boolean validate(Object value) {
            return value != null;
        }
    }

    private static final class SizeOf implements Constraint {
        private final Integer size;

        SizeOf(Integer s) {
            this.size = s;
        }

        public boolean validate(Object value) {
            return ((Map<?, ?>) value).size() == this.size;
        }
    }

    private static final class Shape implements Constraint {
        private final Map<String, BaseSchema> schemas;

        Shape(Map<String, BaseSchema> constraintSchemas) {
            this.schemas = constraintSchemas;
        }

        public boolean validate(Object value) {
            for (Map.Entry<String, BaseSchema> entry : this.schemas.entrySet()) {
                if (!((Map<?, ?>) value).containsKey(entry.getKey())) {
                    return false;
                }

                Object validateValue = ((Map<?, ?>) value).get(entry.getKey());
                BaseSchema schema = entry.getValue();

                if (!schema.isValid(validateValue)) {
                    return false;
                }
            }

            return true;
        }
    }
}
