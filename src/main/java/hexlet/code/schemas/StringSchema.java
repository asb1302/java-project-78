package hexlet.code.schemas;

import hexlet.code.constraints.Constraint;
import hexlet.code.constraints.Contains;
import hexlet.code.constraints.IsString;
import hexlet.code.constraints.MinLength;
import hexlet.code.constraints.Required;

import java.util.ArrayList;

public final class StringSchema implements Schema {
    private final ArrayList<Constraint> constraints = new ArrayList<>();

    public StringSchema() {
        this.constraints.add(new IsString());
    }

    @Override
    public boolean isValid(Object str) {
        for (Constraint constraint: constraints) {
            if (!constraint.validate(str)) {
                return false;
            }
        }

        return true;
    }

    public StringSchema required() {
        this.constraints.add(new Required());

        return this;
    }

    public StringSchema contains(String substr) {
        this.constraints.add(new Contains(substr));

        return this;
    }

    public StringSchema minLength(int min) {
        this.constraints.add(new MinLength(min));

        return this;
    }
}
