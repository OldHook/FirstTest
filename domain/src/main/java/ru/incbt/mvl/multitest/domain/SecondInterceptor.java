package ru.incbt.mvl.multitest.domain;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logged
@Priority(Interceptor.Priority.APPLICATION+2)
public class SecondInterceptor {
	@Inject
	private Logger logger;

	@AroundConstruct
	private void logAroundConstruct(InvocationContext ic) throws Exception {
		logger.fine("Entering constructor");
		try {
			ic.proceed();
		} finally {
			logger.fine("Exiting constructor");
		}
	}

	@PostConstruct
	public void logPostConstruct(InvocationContext ic) {
		logger.fine("Entering post construct " + ic.getTarget().toString());
		try {
			ic.proceed();
		} catch (Exception e) {
			logger.warning("Ошибка");
			e.printStackTrace();
		} finally {
			logger.fine("Exiting post construct " + ic.getTarget().toString());
		}
	}

	@AroundInvoke
	public Object logAroundInvoke(InvocationContext ic) throws Exception {
		logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		try {
			return ic.proceed();
		} finally {
			logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
		}
	}
}