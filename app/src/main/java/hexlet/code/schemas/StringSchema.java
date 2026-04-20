package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        constraints.put("required", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        constraints.put("minLength", s -> s == null || s.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        constraints.put("contains", s -> s == null || s.contains(substring));
        return this;
    }
}
