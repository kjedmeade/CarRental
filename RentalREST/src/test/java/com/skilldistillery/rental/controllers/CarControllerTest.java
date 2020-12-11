package com.skilldistillery.rental.controllers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.rental.entities.Car;


@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
class CarControllerTest {
	
	
//This is the basic format but was unable to run my controller tests

	
//	  private String baseUrl = "http://localhost:8090/";
//
//
//	  @Test
//	  public void testListAllCars() throws IOException{
//	    TestRestTemplate restTest = new TestRestTemplate();
//	    ResponseEntity<Car> response = restTest.getForEntity(baseUrl + "api/cars", Car.class);
//	    assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));
//	    ObjectMapper mapper = new ObjectMapper();
//	    // map to a Collection of Car objects
//	    List<Car> cars = mapper.readValue((DataInput) response.getBody(),  mapper.getTypeFactory().constructCollectionType(List.class, Car.class));
//	    assertThat( cars.get(0).getType(), is("Sedan"));
//	  }
//	  
//	  


	
}




  