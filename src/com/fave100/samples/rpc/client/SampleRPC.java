package com.fave100.samples.rpc.client;

import com.fave100.samples.rpc.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SampleRPC implements EntryPoint {

	private final PersonServiceAsync messageService = GWT.create(PersonService.class);

	public void onModuleLoad() {
		final Button sendButton = new Button("Get GWT RPC");
		final Label statusLabel = new Label();

		sendButton.addStyleName("sendButton");

		// Add button and status label
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(statusLabel);
		
		sendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				messageService.getRandomPerson(new AsyncCallback<Person>() {

					@Override
					public void onFailure(Throwable caught) {
						statusLabel.setText("Oops, we encountered an error");						
					}

					@Override
					public void onSuccess(Person person) {
						statusLabel.setText("Retrieved random person: " + person.getFirstName() + " " + person.getLastName());						
					}
				});
				
			}
		});
	}
}
