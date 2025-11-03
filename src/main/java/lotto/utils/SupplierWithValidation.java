package lotto.utils;

@FunctionalInterface
public interface SupplierWithValidation<T> {
    T get() throws IllegalArgumentException;
}
