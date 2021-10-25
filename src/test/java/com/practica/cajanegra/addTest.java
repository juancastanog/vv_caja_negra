package com.practica.cajanegra;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class addTest {
	private SingleLinkedListImpl<String> listaTest; 
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C");
	}
	
	
	// Metodo addLast, admite  cualquier tipo de input siempre y cuando éste sea una string.
	@ParameterizedTest(name="addLast {0} in list")
	@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "[","1938"})
	public void addLast(String s) {
		this.listaTest.addLast(s);
		assertEquals("[A, B, C, " + s + "]", this.listaTest.toString());
	}

	@ParameterizedTest(name="addFirst {0} in list")
	@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
	public void addFirst(String s) {
		this.listaTest.addFirst(s);
		assertEquals("["+s+", A, B, C " + "]", this.listaTest.toString());
	}
	
	
	@ParameterizedTest(name="addAtPos {0} in list")
	@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["})
	public void addAtPos(String s) {
		this.listaTest.addLast(s);
		assertEquals("[A, B, C, " + s + "]", this.listaTest.toString());
	}
	
	
	@ParameterizedTest(name="addLast {0} in list")
	@MethodSource("provideParameters")
	@ValueSource(strings= {"@", "A", "B", "M", "Y", "Z", "["}, ints = {0,1,50,500})
	public void addNTimes(String s,int i) {
		this.listaTest.addNTimes(s,i);
		for (int j = 0; j < i; j++) {
			s+= s;
		}
		assertEquals("[A, B, C, " + s + "]", this.listaTest.toString());
	}
	
	
	private static Stream<Arguments> provideParameters() {
		int [] validPos = {-1,0,1,50,500,501};
		String[] myStrings = {"@", "A", "B", "M", "Y", "Z", "["};
		Stream myStream = Stream.empty();
		for (int i : validPos) {
			for (String string : myStrings) {
				myStream = Stream.of(string,i);
			}
			
		}
	    return myStream;
}
	}
