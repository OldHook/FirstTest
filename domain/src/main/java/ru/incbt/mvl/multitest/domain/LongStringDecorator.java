package ru.incbt.mvl.multitest.domain;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class LongStringDecorator implements StringGenerator {
	@Inject
	@Delegate
	private StringGenerator stringGenerator;

	public String generateString() {
		String longString = stringGenerator.generateString() + " LONG";
		return longString;
	}
}