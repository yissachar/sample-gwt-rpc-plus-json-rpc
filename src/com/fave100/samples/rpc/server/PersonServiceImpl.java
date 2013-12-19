package com.fave100.samples.rpc.server;

import com.fave100.samples.rpc.client.PersonService;
import com.fave100.samples.rpc.shared.Person;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {

	public Person getRandomPerson() {
		String[] firstNames = {"John", "Mike", "Bob", "Jack", "Arthur", "Jerry", "Doug", "Frank"};
		String[] lastNames = {"Worthington", "Stone", "Smith", "Black", "Rosen", "Kent"};
		
		String firstName = firstNames[(int) (Math.random() * firstNames.length)];
		String lastName = lastNames[(int) (Math.random() * lastNames.length)];
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		return person;
	}
}