package ru.incbt.mvl.multitest.domain;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ShortStringGenerator implements StringGenerator {
	@Override
	public String generateString() {
		return "SHORT";
	}
}
