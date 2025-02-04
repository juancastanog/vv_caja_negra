package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests que incluyen los del tipo Reverse y Remove")
class ReverseAndRemoveTests {


	private static SingleLinkedListImpl<String> listaTest,listaVacia,listaUnElemento,listaTodosPosiblesElementos;
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C","B");
		this.listaVacia = new SingleLinkedListImpl<String>();
		this.listaUnElemento = new SingleLinkedListImpl<String>("A");
		this.listaTodosPosiblesElementos = new SingleLinkedListImpl<String>("A","B","M","B","Y","Z");
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
	@DisplayName("removeLast(tElem) de [A, B, M, B, Y, Z] y de una lista vac�a")
	class removeLasttElem{
		
		@Test
		public void removeLastA() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("A");
			assertEquals("[B, M, B, Y, Z]", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastB() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("B");
			assertEquals("[A, B, M, Y, Z]", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastM() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("M");
			assertEquals("[A, B, B, Y, Z]", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastY() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("Y");
			assertEquals("[A, B, M, B, Z]", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastZ() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("Z");
			assertEquals("[A, B, M, B, Y]", listaTodosPosiblesElementos.toString());
		}
		@ParameterizedTest(name = "removeLast{0}")
	    @ValueSource(strings = {"@","[","W"})
		public void removeLastNoSuchElement(String s) throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				listaTodosPosiblesElementos.removeLast(s);
			});
		}
		@Test
		public void removeLastAEnListaVacia() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				listaVacia.removeLast("A");
			});
		}
		
	}
	
		

}
