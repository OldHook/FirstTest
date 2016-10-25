package ru.incbt.mvl.multitest.web;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("mytheme")
@CDIUI("")
@Widgetset("ru.incbt.mvl.multitest.web.MyAppWidgetset")
public class MyUI extends UI {
	@Inject
	private CDIViewProvider viewProvider;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Navigator navigator = new Navigator(this, this);
		navigator.addProvider(viewProvider);
		navigator.navigateTo("test");
	}

}
