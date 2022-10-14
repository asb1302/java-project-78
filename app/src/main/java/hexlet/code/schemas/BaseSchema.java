package hexlet.code.schemas;

import java.util.ArrayList;

public abstract class BaseSchema {
    private final ArrayList<Constraint> constraints = new ArrayList<>();

    /**
     * Get constraint.
     *
     * @param constraint constraint
     */
    protected void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    /**
     * Checking if the value matches constraints.
     *
     * @param value checked value
     *
     * @return result of checking
     */
    public boolean isValid(Object value) {
        for (Constraint constraint: constraints) {
            if (!constraint.validate(value)) {
                return false;
            }
        }

        return true;
    }
}
