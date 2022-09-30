package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    private static final int NUMBER_1 = 100;
    private static final int NUMBER_2 = -5;
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

    @Test
    void testValidateShape() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", NUMBER_1);
        assertThat(schema.isValid(human1)).isEqualTo(true);

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isEqualTo(true);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isEqualTo(false);

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", NUMBER_2);
        assertThat(schema.isValid(human4)).isEqualTo(false);

        schemas.put("name", v.string().required().contains("ya"));

        Map<String, Object> human5 = new HashMap<>();
        human5.put("name", "Valya");
        human5.put("age", NUMBER_1);
        assertThat(schema.isValid(human5)).isEqualTo(true);
    }
}
