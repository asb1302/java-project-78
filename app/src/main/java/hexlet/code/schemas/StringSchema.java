package hexlet.code.schemas;

import hexlet.code.constraints.Contains;
import hexlet.code.constraints.IsString;
import hexlet.code.constraints.MinLength;

public final class StringSchema extends BaseSchema implements Schema {
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
}
