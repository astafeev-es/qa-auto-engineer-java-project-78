package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public final class StringSchemaTest {

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.minLength(10).minLength(4).isValid("Hexlet"));
        assertFalse(schema.minLength(10).isValid("Hexlet"));
    }

    @Test
    public void testContainsOverwrite() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.contains("wh").contains("hex").isValid("hexlet"));
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void testMinLengthWithoutRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.minLength(10).isValid(""));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid("hexlet"));
    }
}
