package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests que incluyen los del tipo Reverse y Remove")
class ReverseAndRemoveTests {

<<<<<<< HEAD
	private static SingleLinkedListImpl<String> listaTest,listaVacia,listaUnElemento,listaTodosPosiblesElementos;
	
	@BeforeEach
	public void setUp() {
		this.listaTest = new SingleLinkedListImpl<String>("A","B","C","B");
		this.listaVacia = new SingleLinkedListImpl<String>();
		this.listaUnElemento = new SingleLinkedListImpl<String>("A");
		this.listaTodosPosiblesElementos = new SingleLinkedListImpl<String>("A","B","M","B","Y","Z","@","[");
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
	@DisplayName("removeLast(tElem) de [A, B, M, B, Y, Z, @, [] y de una lista vacía")
	class removeLasttElem{
		
		@Test
		public void removeLastA() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("A");
			assertEquals("[B, M, B, Y, Z, @, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastB() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("B");
			assertEquals("[A, B, M, Y, Z, @, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastM() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("M");
			assertEquals("[A, B, B, Y, Z, @, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastY() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("Y");
			assertEquals("[A, B, M, B, Z, @, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastZ() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("Z");
			assertEquals("[A, B, M, B, Y, @, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastArroba() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("@");
			assertEquals("[A, B, M, B, Y, Z, []", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastCorchete() throws NoSuchElementException, EmptyCollectionException{
			listaTodosPosiblesElementos.removeLast("[");
			assertEquals("[A, B, M, B, Y, Z, @]", listaTodosPosiblesElementos.toString());
		}
		@Test
		public void removeLastW() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				listaTodosPosiblesElementos.removeLast("W");
			});
		}
		@Test
		public void removeLastAEnListaVacia() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				listaVacia.removeLast("A");
			});
		}
		
	}
	
		/*
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
		public void removeLastW() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				listaTest.removeLast("W");
			});
		}
		@Test
		public void removeLastAEnListaVacía() throws NoSuchElementException, EmptyCollectionException{
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				listaVacia.removeLast("A");
			});
		}
		*/
		
=======
    private static SingleLinkedListImpl<String> listaTest, listaVacia, listaUnElemento;

    @BeforeEach
    public void setUp() {
        this.listaTest = new SingleLinkedListImpl<String>("A", "B", "C", "B");
        this.listaVacia = new SingleLinkedListImpl<String>();
        this.listaUnElemento = new SingleLinkedListImpl<String>("A");
    }

    @Nested
    @DisplayName("reverse()")
    class reverse {
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
    class removeLast {
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
    class removeLasttElem {
        @Test
        public void removeLastA() throws NoSuchElementException, EmptyCollectionException {
            listaTest.removeLast("A");
            assertEquals("[B, C, B]", listaTest.toString());
        }

        @Test
        public void removeLastB() throws NoSuchElementException, EmptyCollectionException {
            listaTest.removeLast("B");
            assertEquals("[A, B, C]", listaTest.toString());
        }

        @Test
        public void removeLastC() throws NoSuchElementException, EmptyCollectionException {
            listaTest.removeLast("C");
            assertEquals("[A, B, B]", listaTest.toString());
        }

        @Test
        public void removeLastD() throws NoSuchElementException, EmptyCollectionException {
            Assertions.assertThrows(NoSuchElementException.class, () -> {
                listaTest.removeLast("D");
            });
        }

        @Test
        public void removeLastAEnListaVacia() throws NoSuchElementException, EmptyCollectionException {
            Assertions.assertThrows(EmptyCollectionException.class, () -> {
                listaVacia.removeLast("A");
            });
        }
    }
	
	
>>>>>>> 8ae876a52834ea0aea5c6959c094d2efed21772b
	/*
	// DUDA EN ESTE Mï¿½TODO
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
						// debe hacer el mï¿½todo)
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
