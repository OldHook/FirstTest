package ru.incbt.mvl.multitest.beans;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class CacheBean {
	private String bankName;
	private String bankAddress;

	@Inject
	Logger logger;
	
	public CacheBean() {
		bankName = "Some Bank";
		bankAddress = "Some address";
	}

	@Lock(LockType.READ)
	public String getBankName() {
		System.out.println("Begin getBankName " + new Date());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End getBankName " + new Date());
		return bankName;
	}

	@Lock(LockType.WRITE)
	public void setBankName(String bankName) {
		System.out.println("Begin setBankName " + new Date());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.bankName = bankName;
		System.out.println("End setBankName " + new Date());
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	@PostConstruct
	private void PostConstructLogger() {
		logger.fine(this.getClass().getSimpleName() + " post construct");
	}
	
	@PreDestroy
	private void PreDestroyLogger() {
		logger.fine(this.getClass().getSimpleName() + " pre destroy");
	}

}
