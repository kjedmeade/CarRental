package com.skilldistillery.rental.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.rental.entities.Customer;
import com.skilldistillery.rental.entities.Customer;
import com.skilldistillery.rental.repositories.CustomerRepository;
import com.skilldistillery.rental.services.CustomerService;

@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
class CustomerControllerTest {
	
	  private String baseUrl = "http://localhost:8090/";

		//This is the basic format but was unable to run my controller tests


//	  @Test
//	  public void testListAllCustomers() throws IOException{
//	    TestRestTemplate restTest = new TestRestTemplate();
//	    ResponseEntity<Customer> response = restTest.getForEntity(baseUrl + "api/customers", Customer.class);
//	    assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));
//	    ObjectMapper mapper = new ObjectMapper();
//	    // map to a Collection of Customer objects
//	    List<Customer> customers = mapper.readValue((DataInput) response.getBody(),  mapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
//	    assertThat( customers.get(0).getFirstName(), is("Mary"));
//	  }
//	  
	  

	
}
