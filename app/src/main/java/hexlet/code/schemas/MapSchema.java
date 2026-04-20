package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        constraints.put("required", m -> m != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        constraints.put("sizeof", m -> m == null || m.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema<?>> schemas) {
        constraints.put("shape", map -> {
            for (Map.Entry<String, ? extends BaseSchema<?>> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object value = map.get(key);
                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
