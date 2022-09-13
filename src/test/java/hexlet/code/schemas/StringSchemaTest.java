package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {
    private static final int TEST_NUMBER = 3;

    @Test
    void testValidate() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        boolean result1 = schema.isValid("");
        assertThat(result1).isEqualTo(true);

        boolean result2 = schema.isValid(null);
        assertThat(result2).isEqualTo(true);

        schema.required();

        boolean result3 = schema.isValid("");
        assertThat(result3).isEqualTo(false);

        boolean result4 = schema.isValid(null);
        assertThat(result4).isEqualTo(false);

        boolean result5 = schema.isValid("what does the fox say");
        assertThat(result5).isEqualTo(true);

        boolean result6 = schema.isValid("hexlet");
        assertThat(result6).isEqualTo(true);

        boolean result7 = schema.contains("wh").isValid("what does the fox say");
        assertThat(result7).isEqualTo(true);

        boolean result8 = schema.contains("what").isValid("what does the fox say");
        assertThat(result8).isEqualTo(true);

        boolean result9 = schema.contains("whatthe").isValid("what does the fox say");
        assertThat(result9).isEqualTo(false);

        boolean result10 = schema.isValid("what does the fox say");
        assertThat(result10).isEqualTo(false);

        schema = v.string();

        schema.minLength(TEST_NUMBER);

        boolean result11 = schema.isValid("what does the fox say");
        assertThat(result11).isEqualTo(true);

        boolean result12 = schema.isValid("wh");
        assertThat(result12).isEqualTo(false);
    }
}
