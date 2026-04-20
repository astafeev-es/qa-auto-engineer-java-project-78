package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import java.util.HashMap;
import java.util.Map;

public final class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        // StringSchema examples
        var stringSchema = v.string();
        System.out.println("String valid (empty): " + stringSchema.isValid("")); // true
        stringSchema.required();
        System.out.println("String valid (required + empty): " + stringSchema.isValid("")); // false
        stringSchema.minLength(5).contains("hexlet");
        System.out.println("String valid ('hexlet'): " + stringSchema.isValid("hexlet")); // true

        // NumberSchema examples
        var numberSchema = v.number();
        System.out.println("Number valid (null): " + numberSchema.isValid(null)); // true
        numberSchema.required().positive().range(10, 20);
        System.out.println("Number valid (15): " + numberSchema.isValid(15)); // true
        System.out.println("Number valid (-5): " + numberSchema.isValid(-5)); // false

        // MapSchema examples
        var mapSchema = v.map();
        System.out.println("Map valid (null): " + mapSchema.isValid(null)); // true
        mapSchema.required().sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        System.out.println("Map valid (2 items): " + mapSchema.isValid(data)); // true

        // Shape example
        var shapeSchema = v.map();
        Map<String, BaseSchema<?>> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        shapeSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        System.out.println("Shape human1 valid: " + shapeSchema.isValid(human1)); // true
    }
}
