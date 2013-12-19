package com.fave100.samples.rpc.client;

import com.fave100.samples.rpc.shared.Person;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("person")
public interface PersonService extends RemoteService {
	Person getRandomPerson();
}
