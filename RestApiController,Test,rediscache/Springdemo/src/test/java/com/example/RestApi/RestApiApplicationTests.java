package com.example.RestApi;

import com.example.RestApi.controller.PersonController;
import com.example.RestApi.entity.Person;
import com.example.RestApi.service.Impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@SpringBootTest
class RestApiApplicationTests {
	@InjectMocks
	private PersonController personController;

	@Mock
	private PersonServiceImpl personService;


	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void contextLoads() {
	}

	@Test
	public void testCreatePerson() {
		Person person = new Person();
		person.setId(Long.valueOf("101"));
		person.setFirstName("Keerthi");
		person.setLastName("Devi");


		when(personService.createPerson(any(Person.class))).thenReturn(person);

		ResponseEntity<Person> responseEntity = personController.addPerson(person);


		verify(personService).createPerson(any(Person.class));

		assertEquals(201, responseEntity.getStatusCodeValue());
		assertEquals(person, responseEntity.getBody());
	}
	@Test
	public void testAllUsers() {
		List<Person> personList = new ArrayList<>();

		Person person1 = new Person();
		person1.setId(1L);
		person1.setFirstName("Devi");
		person1.setLastName("Venke");
		personList.add(person1);

		Person person2 = new Person();
		person2.setId(2L);
		person2.setFirstName("Maha");
		person2.setLastName("Sethu");
		personList.add(person2);


		when(personService.getAllPersons()).thenReturn(personList);

		List<Person> response = personController.getAllPersons().getBody();

		assertEquals(personList, response);
	}

}