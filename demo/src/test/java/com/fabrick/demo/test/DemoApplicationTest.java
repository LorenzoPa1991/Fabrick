package com.fabrick.demo.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void testGetClosestApproaches() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fabrick/v1.0/asteroids/3542519")
						.param("fromDate", "1900-01-01")
						.param("toDate", "2000-01-01")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void testGetClosestAirport() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fabrick/v1.0/airports/LIRF")
						.param("closestBy", "1.0")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void testGetClosestStation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/fabrick/v1.0/stations/LIRF")
						.param("closestBy", "1.0")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}