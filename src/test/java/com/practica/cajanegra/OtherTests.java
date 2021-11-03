package com.practica.cajanegra;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.cajanegra.SingleLinkedListImpl;

@DisplayName("Tests que incluyen los del tipo isEmpty, size y toString")
class OtherTests {

	private SingleLinkedListImpl<String> listaTest; 
	
	@BeforeEach
	public void setUp() { this.listaTest = new SingleLinkedListImpl<String>("A","B","C"); }

	@Nested
	@DisplayName("isEmpty()")
	class isEmpty{
		@Test
		public void isEmptyCasoVacio(){
			assertTrue(listaTest.isEmpty());
		}
		@Test
		public void isEmptyCasoLlenoyDeUnSoloElemento(){ //En los dos casos el código es igual
			assertFalse(listaTest.isEmpty());
		}
	}

	@Nested
	@DisplayName("getSize()"){
		class size{
			@Test
			public void getSizeCasoVacio(){
				assertEquals(0, this.listaTest.size());
			}
			@Test
			public void getSizeCasoUnElemento(){
				assertEquals(1, this.listaTest.size());
			}
			@Test
			public void getSizeCasoDosElementos(){
				assertEquals(2, this.listaTest.size());
			}
			@Test
			public void getSizeCasoLleno() {
				assertEquals(3, this.listaTest.size());
			}

		}


	}

	@Nested
	@DisplayName("toString()"){
		class toString{
					@Test
					public void toString(){
						String toString = listaTest.toString();
						assertTrue(toString.matches("?*[A-Z]*?)");
					}
					@Test
					public void toString(){
						String toString = listaTest.toString();
						assertTrue(toString.contains("ABC"));
			}
		}
	}



}
