package hexlet.code.constraints;

public final class Contains implements Constraint {
    private final String substring;
    public Contains(String substr) {
        this.substring = substr;
    }
    @Override
    public boolean validate(Object value) {
        return ((String) value).contains(this.substring);
    }
}
