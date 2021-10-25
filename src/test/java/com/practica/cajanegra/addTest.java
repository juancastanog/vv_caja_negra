package com.practica.cajanegra;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class addTest {
	private SingleLinkedListImpl<String> listaTest; 
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C");
	}
	
	@DisplayName("Single test successful")
	@Test
	void testSingleSuccessTest() {
		assertEquals("patata","patata");
	}
	
	@ParameterizedTest(name="addLast {0} in list")
	@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "[","1938"})
	public void addLast(String s) {
		this.listaTest.addLast(s);
		assertEquals("[A, B, C, " + s + "]", this.listaTest.toString());
	}

	
}
