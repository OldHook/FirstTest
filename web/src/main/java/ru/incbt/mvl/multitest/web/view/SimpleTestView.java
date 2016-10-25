package ru.incbt.mvl.multitest.web.view;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import ru.incbt.mvl.multitest.beans.CacheBean;
import ru.incbt.mvl.multitest.domain.CustomName;
import ru.incbt.mvl.multitest.domain.StringGenerator;

@SuppressWarnings("serial")
@CDIView("test")
public class SimpleTestView extends CustomComponent implements View {

	@Inject Logger logger;

	@Inject @Named("First")
	private CustomName customName;

	@Inject StringGenerator stringGenerator;
	@Inject CacheBean cache;

	@Override
	public void enter(ViewChangeEvent event) {
		TextArea text = new TextArea("Log");
		text.setWidth("100%");
		text.setHeight("100%");
		VerticalLayout layout = new VerticalLayout(text);
		layout.setSizeFull();
		layout.setMargin(true);
		layout.setSpacing(true);
		setCompositionRoot(layout);
		
		String sTmp = customName.getName() + customName.toString();
		sTmp += "\r\n" + stringGenerator.generateString();
//		sTmp += "\r\n" + cache.getBankName();
		text.setValue(sTmp);
		logger.info(sTmp);
		
		Button setButton = new Button("SET");  
		Button getButton = new Button("GET");
		layout.addComponent(setButton);
		layout.addComponent(getButton);
		
		setButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				cache.setBankName("BANK NAME " + new Date());
			}
		});

		getButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println(cache.getBankName());
			}
		});
}

}