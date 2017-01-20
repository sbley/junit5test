package de.sbley.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The equals method implements an equivalence relation on non-null object references:
 * <ul>
 * <li>It is reflexive: for any non-null reference value x, x.equals(x) should return true.</li>
 * <li>It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if
 * y.equals(x) returns true.</li>
 * <li>It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z)
 * returns true, then x.equals(z) should return true.</li>
 * <li>It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently
 * return true or consistently return false, provided no information used in equals comparisons on the objects is
 * modified.</li>
 * <li>For any non-null reference value x, x.equals(null) should return false.</li>
 * </ul>
 * The equals method for class Object implements the most discriminating possible equivalence relation on objects; that
 * is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same
 * object (x == y has the value true).
 * 
 * Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to
 * maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.
 * 
 * @param <T>
 */
public interface EqualsHashCodeContract<T> {

    T value();

    T equalValue();

    T notEqualValue();

    @Test
    @DisplayName("x.equals(x) should return true")
    default void isReflexive() {
        T value = value();
        assertThat(value.equals(value)).isTrue();
    }

    @Test
    @DisplayName("x.equals(y) should return true if and only if y.equals(x) returns true")
    default void isSymmetric() {
        T value = value();
        T equalValue = equalValue();
        assertAll(() -> assertThat(value.equals(equalValue)).isTrue(),
                () -> assertThat(equalValue.equals(value)).isTrue());
    }

    @Test
    @DisplayName("Multiple invocations of x.equals(y) consistently return true")
    default void isConsistentTrue() {
        T value = value();
        T equalValue = equalValue();
        assertThat(value.equals(equalValue)).isTrue();
        assertThat(value.equals(equalValue)).isTrue();
    }

    @Test
    @DisplayName("Multiple invocations of x.equals(y) consistently return false")
    default void isConsistentFalse() {
        T value = value();
        T notEqualValue = notEqualValue();
        assertThat(value.equals(notEqualValue)).isFalse();
        assertThat(value.equals(notEqualValue)).isFalse();
    }

    @Test
    @DisplayName("x.equals(null) should return false")
    default void returnsFalseForNullValue() {
        assertThat(value().equals(null)).isFalse();
    }

    @Test
    @DisplayName("x.equals(y) should return false if x is different to y")
    default void returnsFalseForNotEqualValue() {
        assertThat(value().equals(notEqualValue())).isFalse();
    }

    @Test
    @DisplayName("x.hashCode() should be equal to y.hashCode()")
    default void hashCodeReturnsTrueIfEqualsReturnsTrue() {
        assertThat(value().hashCode()).isEqualTo(equalValue().hashCode());
    }
}
