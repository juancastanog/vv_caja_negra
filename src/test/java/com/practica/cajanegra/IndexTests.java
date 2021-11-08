package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

// Clase que comprueba el comportamiento de getAtPos y indexOf
@DisplayName("Tests que incluyen los del tipo indexOf y getAtPos")
class IndexTests {

    private SingleLinkedListImpl<String> listaTest;

    @BeforeEach
    public void setUp() {
        this.listaTest = new SingleLinkedListImpl<String>("A", "B", "M", "Y", "Z");
    }

    //Indica la posición donde se encuentra la primera aparición de elem desde el principio de la lista (las posiciones empiezan en 1).

    @ParameterizedTest(name = "indexOf {0}")
    @ValueSource(strings = {"A", "B", "M", "Y", "Z", "@", "[", "W"})
    public void indexOf(String elem) {
        int primPos = 1;
        boolean encontrado = false;
        // Dado que no podemos confiar en el funcionamiento de getAtPos dado que aun no se ha comprobado,
        // utilizamos una estructura de datos auxiliar

        for (Iterator iterator = listaTest.iterator(); iterator.hasNext() && !encontrado; ) {
            String actString = (String) iterator.next();
            if (actString.equals(elem)) {
                encontrado = true;
            } else if (!encontrado) {
                primPos++;
            }
        }
        if (encontrado) {
            assertEquals(primPos, this.listaTest.indexOf(elem));
        } else {
            Assertions.assertThrows(NoSuchElementException.class, () -> {
                this.listaTest.indexOf(elem);
            });
        }
    }

    // Devuelve el elemento de la posición pos
    @ParameterizedTest(name = "getAtPos {0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void getAtPos(int pos) {
        // Posicion invalida
        if (pos <= 0 || pos > listaTest.size()) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                this.listaTest.getAtPos(pos);
            });
        }
        // Posicion valida, buscamos elemento
        else {
            boolean encontrado = false;
            int posAct = 0;
            String indexString = "";
            for (Iterator iterator = listaTest.iterator(); iterator.hasNext() && !encontrado; ) {
                indexString = (String) iterator.next();
                posAct++;
                if (posAct == pos) {
                    encontrado = true;
                }
            }
            assertEquals(indexString, this.listaTest.getAtPos(pos));

        }
    }

}
