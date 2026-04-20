package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final Map<String, Predicate<T>> constraints = new LinkedHashMap<>();

    @SuppressWarnings("unchecked")
    public final boolean isValid(Object value) {
        if (!constraints.containsKey("required")) {
            if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                return true;
            }
        }

        for (Predicate<T> predicate : constraints.values()) {
            if (!predicate.test((T) value)) {
                return false;
            }
        }
        return true;
    }
}
