package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        constraints.put("required", n -> n != null);
        return this;
    }

    public NumberSchema positive() {
        constraints.put("positive", n -> n == null || n > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        constraints.put("range", n -> n == null || (n >= min && n <= max));
        return this;
    }
}
