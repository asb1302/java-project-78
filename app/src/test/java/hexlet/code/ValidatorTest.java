package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ValidatorTest {
    @Test
    void stringTest() {
        Object stringSchema = new Validator().string();
        assertInstanceOf(StringSchema.class, stringSchema);
    }
}
