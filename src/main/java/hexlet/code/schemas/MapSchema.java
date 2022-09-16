package hexlet.code.schemas;

import hexlet.code.constraints.IsMap;
import hexlet.code.constraints.SizeOf;

public final class MapSchema extends BaseSchema implements Schema {
    public MapSchema() {
        this.addConstraint(new IsMap());
    }

    public MapSchema sizeof(int size) {
        this.addConstraint(new SizeOf(size));

        return this;
    }
}
