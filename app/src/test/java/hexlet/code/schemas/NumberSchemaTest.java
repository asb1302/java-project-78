package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {
    private static final int NUMBER_1 = 5;
    private static final int NUMBER_2 = 10;
    private static final int NUMBER_3 = -10;
    private static final int NUMBER_4 = 4;
    private static final int NUMBER_5 = 11;

    @Test
    void testValidate() {
        Validator v = new Validator();

        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid(null)).isEqualTo(false);

        assertThat(schema.isValid(NUMBER_2)).isEqualTo(true);

        assertThat(schema.isValid("5")).isEqualTo(false);

        assertThat(schema.positive().isValid(NUMBER_2)).isEqualTo(true);

        assertThat(schema.positive().isValid(NUMBER_3)).isEqualTo(false);

        schema.range(NUMBER_1, NUMBER_2);

        assertThat(schema.isValid(NUMBER_1)).isEqualTo(true);

        assertThat(schema.isValid(NUMBER_2)).isEqualTo(true);

        assertThat(schema.isValid(NUMBER_4)).isEqualTo(false);

        assertThat(schema.isValid(NUMBER_5)).isEqualTo(false);
    }
}
