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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;

@DisplayName("Tests que incluyen los del tipo Reverse y Remove")
class ReverseAndRemoveTests {

	private static SingleLinkedListImpl<String> listaTest,listaVacia,listaUnElemento;
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C","B");
		this.listaVacia = new SingleLinkedListImpl<String>();
		this.listaUnElemento = new SingleLinkedListImpl<String>("A");
	}
	
	@Nested
	@DisplayName("reverse()")
	class reverse{
		@Test
		public void reverseCasoLleno() {
			assertEquals("[B, C, B, A]", listaTest.reverse().toString());
		}
		@Test
		public void reverseCasoVacio() {
			assertEquals("[]", listaVacia.reverse().toString());
		}
		@Test
		public void reverseCasoUnElemento() {
			assertEquals("[A]", listaUnElemento.reverse().toString());
		}
	}
	
	@Nested
	@DisplayName("removeLast()")
	class removeLast{
		@Test
		public void removeLastCasoLLeno() throws EmptyCollectionException {
			listaTest.removeLast();
			assertEquals("[A, B, C]", listaTest.toString());	
		}
		@Test
		public void removeLastCasoVacio() throws EmptyCollectionException {
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				listaVacia.removeLast();
			});
		}
		@Test
		public void removeLastCasoUnElemento() throws EmptyCollectionException {
			listaUnElemento.removeLast();
			assertEquals("[]", listaUnElemento.toString());
		}
	}
	
	@Nested
	@DisplayName("removeLast(tElem) de [A, B, C, B]")
	class removeLasttElem{
		@Test
		public void removeLastA() throws NoSuchElementException, EmptyCollectionException{
			listaTest.removeLast("A");
			assertEquals("[B, C, B]", listaTest.toString());
		}
		@Test
		public void removeLastB() throws NoSuchElementException, EmptyCollectionException{
			listaTest.removeLast("B");
			assertEquals("[A, B, C]", listaTest.toString());
		}
		@Test
		public void removeLastC() throws NoSuchElementException, EmptyCollectionException{
			listaTest.removeLast("C");
			assertEquals("[A, B, B]", listaTest.toString());
		}
		@Test
		public void removeLastD() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				listaTest.removeLast("D");
			});
		}
		@Test
		public void removeLastAEnListaVacía() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				listaVacia.removeLast("A");
			});
		}
	}
	
	
	/*
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
	*/
	


}
