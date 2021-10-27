package com.practica.cajanegra;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;

class ReverseAndRemoveTests {

	private static SingleLinkedListImpl<String> listaTest,listaVacia,listaUnElemento;
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C","A","B");
		this.listaVacia = new SingleLinkedListImpl<String>();
		this.listaUnElemento = new SingleLinkedListImpl<String>("A");
	}
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	public void reverse(SingleLinkedListImpl<String> lista) {
		StringBuilder builder = new StringBuilder(lista.toString());
		builder=builder.reverse(); 
		builder=builder.deleteCharAt(0);
		builder=builder.deleteCharAt(builder.length()-1);
		String finalString="";
		for(int i=0;i<builder.length();++i){
	        if(Character.isWhitespace(builder.charAt(i))){
	        	builder.deleteCharAt(i);
	            i--;
	        }
	        if(Character.isAlphabetic(builder.charAt(i))) {
	        	if(i==builder.length()-1)
	        		finalString += builder.toString().charAt(i);
	        	else {
	        		finalString += builder.toString().charAt(i)+", ";
	        		builder.deleteCharAt(i);
	        	}
	        }
	    }
		assertEquals("["+finalString+"]", lista.reverse().toString());
	}
	
	@ParameterizedTest
	@MethodSource("provideParameters")
	public void removeLast(SingleLinkedListImpl<String> lista) throws EmptyCollectionException {
		StringBuilder builder = new StringBuilder(lista.toString());
		if(!builder.isEmpty()) {
			builder = builder.deleteCharAt(0);
			builder = builder.deleteCharAt(builder.length() - 1);
			for (int i = 0; i < 3; i++) {
				builder = builder.deleteCharAt(builder.length() - 1);
			}
			lista.removeLast();
			assertEquals("[" + builder.toString() + "]", lista.toString());
		}
		else {
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				lista.removeLast();
			});
		}
	}
	
	// DUDA EN ESTE MÉTODO
	@ParameterizedTest(name="removeLast {0} in list")
    @CsvFileSource(resources = "/RemoveLastTelem.csv", numLinesToSkip = 0)
	public void removeLast(String s) throws NoSuchElementException, EmptyCollectionException  {
		StringBuilder builder = new StringBuilder(this.listaTest.toString());
		if(!builder.isEmpty()) {
			builder = builder.deleteCharAt(0);
			builder = builder.deleteCharAt(builder.length() - 1);
			boolean aux = false;
			for (int i = builder.length() - 1; i >= 0; i--) {
				if (builder.charAt(i) == s.charAt(0) && !aux) {
					if (i == builder.length() - 1) {
						builder = builder.deleteCharAt(builder.length() - 1);
						i--;
						builder = builder.deleteCharAt(builder.length() - 1);
						i--;
						builder = builder.deleteCharAt(builder.length() - 1);
						i--;
					} else { // cuando es el primero de la lista se carga toda la lista
						builder = builder.deleteCharAt(i);
						builder = builder.deleteCharAt(i);
						builder = builder.deleteCharAt(i);
					} // CUANDO hay mas de un elemento repetido, en vez de eliminar el
						// ultimo elimina todas las apariciones del elemento (no es lo que
						// debe hacer el método)
					aux = true;
				}
			}
			if (aux) {
				this.listaTest.removeLast(s);
				assertEquals("[" + builder.toString() + "]", this.listaTest.toString());
			} else {
				Assertions.assertThrows(NoSuchElementException.class, () -> {
					this.listaTest.removeLast(s);
				});
			}
		}
		else {
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				this.listaTest.removeLast(s);
			});
		}
	}
	
	private static Stream<Arguments> provideParameters() {
	    return Stream.of(
	            Arguments.of(listaTest),
	            Arguments.of(listaVacia),
	            Arguments.of(listaUnElemento)
	    );
	}


}
