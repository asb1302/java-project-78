package hexlet.code.schemas;

import hexlet.code.constraints.Range;
import hexlet.code.constraints.Positive;
import hexlet.code.constraints.IsNumber;

public final class NumberSchema extends BaseSchema implements Schema {
    public NumberSchema() {
        this.addConstraint(new IsNumber());
    }

    public NumberSchema positive() {
        this.addConstraint(new Positive());

        return this;
    }

    public NumberSchema range(int min, int max) {
        this.addConstraint(new Range(min, max));

        return this;
    }
}
