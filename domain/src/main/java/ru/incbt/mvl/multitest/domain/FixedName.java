package ru.incbt.mvl.multitest.domain;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named("First")
//@Interceptors({LoggingInterceptor.class, ProfileInterceptor.class})
@Logged
public class FixedName implements CustomName {
	@Inject
	Logger logger;
	
	private String name;

	public FixedName() {
		name = "First FixedName";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
