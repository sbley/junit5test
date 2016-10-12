package de.sbley.junit5;

import java.util.List;
import java.util.function.BooleanSupplier;

public class EmptyListSupplier implements BooleanSupplier {

	private List<String> list;

	public static EmptyListSupplier isEmpty(List<String> list) {
		return new EmptyListSupplier(list);
	}

	private EmptyListSupplier(List<String> list) {
		this.list = list;
	}

	@Override
	public boolean getAsBoolean() {
		return list.isEmpty();
	}

}
