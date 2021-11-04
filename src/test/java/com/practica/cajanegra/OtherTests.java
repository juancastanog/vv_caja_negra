package com.practica.cajanegra;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;

@DisplayName("Tests que incluyen los del tipo isEmpty, size y toString")
class OtherTests {

	private SingleLinkedListImpl<String> listaTest,listaVacia,listaUnElemento; 
	
	@BeforeEach
	public void setUp() { 
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C");
		this.listaVacia = new SingleLinkedListImpl<String>();
		this.listaUnElemento = new SingleLinkedListImpl<String>("A");
	}

	@Nested
	@DisplayName("isEmpty()")
	class isEmpty{
		@Test
		public void isEmptyCasoVacio(){
			assertTrue(listaVacia.isEmpty());
		}
		@Test
		public void isEmptyCasoLlenoyDeUnSoloElemento(){ //En los dos casos el código es igual
			assertFalse(listaUnElemento.isEmpty());
		}
	}

	@Nested
	@DisplayName("getSize()")
	class size{
		@Test
		public void getSizeCasoVacio(){
			assertEquals(0, listaVacia.size());
		}
		@Test
		public void getSizeCasoUnElemento(){
			assertEquals(1, listaUnElemento.size());
		}
		@Test
		public void getSizeCasoLleno() {
			assertEquals(3, listaTest.size());//Comprobar el get size con 50?
		}
	}


	@Nested
	@DisplayName("toString() de [A, B, C]")
	class toString{
		@Test
		public void toStringCasoVacio(){
			assertEquals("[]",listaVacia.toString());
		}

		@Test
		public void toStringCasoLleno() {
			assertEquals("[A, B, C]",listaTest.toString());
		}
	}

}
