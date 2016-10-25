package ru.incbt.mvl.multitest.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
//@SecondFixedNameQualifier
@Named("Second")
public class SecondFixedName implements CustomName {
	private String name;
	
	public SecondFixedName() {
		name = "Second FixedName";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@PostConstruct
	private void PostConstruct() {
		System.out.println("PostConstruct "+this);
	}
	
	@PreDestroy
	private void PreDestroy() {
		System.out.println("PreDestroy "+this);
	}
}
