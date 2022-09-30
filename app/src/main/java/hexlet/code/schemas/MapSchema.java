package hexlet.code.schemas;

import hexlet.code.constraints.IsMap;
import hexlet.code.constraints.Shape;
import hexlet.code.constraints.SizeOf;

import java.util.Map;

public final class MapSchema extends BaseSchema implements Schema {
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
}
