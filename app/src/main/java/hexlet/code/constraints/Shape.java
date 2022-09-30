package hexlet.code.constraints;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public final class Shape implements Constraint {
    private final Map<String, BaseSchema> schemas;

    public Shape(Map<String, BaseSchema> constraintSchemas) {
        this.schemas = constraintSchemas;
    }

    @Override
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
