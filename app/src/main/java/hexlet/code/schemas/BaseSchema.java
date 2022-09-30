package hexlet.code.schemas;

import hexlet.code.constraints.Constraint;

import java.util.ArrayList;

public abstract class BaseSchema {
    private final ArrayList<Constraint> constraints = new ArrayList<>();

    /**
     * Get constraints.
     *
     * @return constraints.
     */
    public ArrayList<Constraint> getConstraints() {
        return constraints;
    }

    /**
     * Get constraint.
     *
     * @param constraint constraint
     */
    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    /**
     * Set constraints.
     *
     * @param constraintList constraints.
     */
    public void setConstraints(ArrayList<Constraint> constraintList) {
        this.constraints.addAll(constraintList);
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
