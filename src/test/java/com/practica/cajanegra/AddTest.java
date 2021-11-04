package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@DisplayName("Tests que incluyen los del tipo addLast, addFirst, addAtPos y addNTimes")
class AddTest {
    private SingleLinkedListImpl<String> listaTest;

    @BeforeEach
    public void setUp() {
        this.listaTest = new SingleLinkedListImpl<String>("A", "B", "C");
    }


    // Metodo addLast, admite  cualquier tipo de input siempre y cuando �ste sea una string.
    @ParameterizedTest(name = "addLast {0} in list")
    @ValueSource(strings = {"@", "A", "B", "M", "Y", "Z", "["})
    public void addLast(String s) {
        this.listaTest.addLast(s);
        assertEquals("[A, B, C, " + s + "]", this.listaTest.toString());
    }


    // Metodo addFirst, no a�ade los elementos en la primera posicion
    @ParameterizedTest(name = "addFirst {0} in list")
    @ValueSource(strings = {"@", "A", "B", "M", "Y", "Z", "["})
    public void addFirst(String s) {
        this.listaTest.addFirst(s);
        assertEquals("[" + s + ", A, B, C " + "]", this.listaTest.toString());
    }

    // Metodo addAtPos Inserta el elemento en la posici�n p, desplazando los elementos a partir de esa posici�n.
    // Si la lista tiene menos de p elementos lo insertar� como �ltimo elemento.
    @ParameterizedTest(name = "addAtPos {0} {1} in list")
    @CsvFileSource(resources = "/AddAtPos.csv", numLinesToSkip = 0)
    public void addAtPos(int pos, String s) {

        // Posicion valida
        if (pos > 0) {
            List<String> myList = new ArrayList<String>(Arrays.asList(this.listaTest.toString().split(",")));
            //Caso primer elemento, borramos corchete del elemento anterior
            if (pos == 1) {
                myList.set(0, myList.get(0).replace('[', Character.MIN_VALUE));
                myList.add(0, "[" + s);
            } else if (pos >= listaTest.size()) {
                if (pos == listaTest.size()) {
                    myList.add(listaTest.size() - 1, s);
                } else {
                    myList.set(listaTest.size() - 1, myList.get(listaTest.size() - 1).replace(']', Character.MIN_VALUE));
                    myList.add(listaTest.size(), s + "]");
                }
            } else {
                myList.add(pos - 1, s);
            }
            String aux, finalString = "";
            for (int j = 0; j < myList.size(); j++) {
                aux = myList.get(j).trim();
                finalString += (j < myList.size() - 1) ? aux + ", " : aux + "";
            }
            this.listaTest.addAtPos(s, pos);
            assertEquals(finalString, this.listaTest.toString());
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                this.listaTest.addAtPos(s, pos);
            });
        }
    }

    //Metodo addNTimes
    @ParameterizedTest(name = "addNTimes {0} {1} times in list")
    @CsvFileSource(resources = "/AddNTimes.csv", numLinesToSkip = 0)
    public void addNTimes(int i, String s) {
        //Construimos la string esperada
        String aux = "";
        if (i > 0) {
            for (int j = 0; j < i; j++) {
                //Si no estamos ante el elemento final insertamos ,
                aux += (j < i - 1) ? s + ", " : s + "";
            }
            this.listaTest.addNTimes(s, i);
            assertEquals("[A, B, C, " + aux + "]", this.listaTest.toString());
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                this.listaTest.addNTimes(s, i);
            });
        }
    }

}
	
	
