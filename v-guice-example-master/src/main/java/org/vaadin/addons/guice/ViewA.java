package org.vaadin.addons.guice;

import com.google.inject.Inject;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ViewA extends VerticalLayout implements View {

	private SessionScopedBean bean;
	private Label label;

	@Override
	public void enter(ViewChangeEvent event) {

		label.setValue(bean.getSessionScopedData());
	}
	
	@Inject
	public ViewA(SessionScopedBean bean) {
		
		addComponent(new Label("ViewA"));
		
		this.bean = bean;
		this.label = new Label();
		addComponent(label);

	}
}
