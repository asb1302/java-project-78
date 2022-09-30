package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {
    private static final int MIN_LENGTH = 3;

    @Test
    void testValidate() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isEqualTo(true);

        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid("")).isEqualTo(false);

        assertThat(schema.isValid(null)).isEqualTo(false);

        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);

        boolean result6 = schema.isValid("hexlet");
        assertThat(result6).isEqualTo(true);

        assertThat(schema.contains("wh").isValid("what does the fox say")).isEqualTo(true);

        assertThat(schema.contains("what").isValid("what does the fox say")).isEqualTo(true);

        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isEqualTo(false);

        assertThat(schema.isValid("what does the fox say")).isEqualTo(false);

        schema = v.string();

        schema.minLength(MIN_LENGTH);

        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);

        assertThat(schema.isValid("wh")).isEqualTo(false);
    }
}
