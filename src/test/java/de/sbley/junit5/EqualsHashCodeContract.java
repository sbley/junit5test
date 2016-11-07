package de.sbley.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public interface EqualsHashCodeContract<T> {
    T createValue();

    T createEqualValue();

    T createNotEqualValue();

    @Test
    default void reflexive() {
        T value = createValue();
        assertEquals(value, value);
    }

    @Test
    default void symmetric() {
        T value = createValue();
        T equalValue = createEqualValue();
        assertAll(() -> {
            assertEquals(value, equalValue);
        }, () -> {
            assertEquals(equalValue, value);
        });
    }

    @Test
    default void doesNotEqualNull() {
        T value = createValue();
        assertFalse(value.equals(null));
    }

    @Test
    default void doesNotEqualDifferentValue() {
        T value = createValue();
        T differentValue = createNotEqualValue();
        assertNotEquals(value, differentValue);
        assertNotEquals(differentValue, value);
    }
}
