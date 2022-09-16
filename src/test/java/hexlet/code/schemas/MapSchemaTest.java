package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    @Test
    void testValidate() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid(null)).isEqualTo(false);

        assertThat(schema.isValid(new HashMap<>())).isEqualTo(true);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(data)).isEqualTo(true);
        assertThat(schema.sizeof(2).isValid(data)).isEqualTo(false);

        data.put("key2", "value2");

        assertThat(schema.isValid(data)).isEqualTo(true);
    }
}
