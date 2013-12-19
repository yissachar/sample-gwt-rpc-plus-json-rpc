package com.fave100.samples.rpc.client;

import com.fave100.samples.rpc.shared.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersonServiceAsync {
	void getRandomPerson(AsyncCallback<Person> asyncCallback);
}