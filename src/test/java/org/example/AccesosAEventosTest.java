package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccesosAEventosTest {


    private String[][] invitados;

    @BeforeEach
    void cargarMatriz() {
        invitados = new String[][] {
                {"Juan", "19", "VIP", "1", "False"},
                {"Ana", "17", "General", "0", "False"},
                {"Luis", "18", "General", "2", "False"},
                {"Pepe", "13", "False", "0", "False"},
                {"Maria", "20", "General", "0", "False"},
                {"Oscar", "30", "VIP", "3", "False"}
        };
    }

    @Test
    void verificarEdad() {
        assertTrue(AccesosAEventos.verificarEdad(invitados, 0));
        assertFalse(AccesosAEventos.verificarEdad(invitados, 1));
        assertTrue(AccesosAEventos.verificarEdad(invitados, 2));
        assertFalse(AccesosAEventos.verificarEdad(invitados, 3));
        assertTrue(AccesosAEventos.verificarEdad(invitados, 4));
        assertTrue(AccesosAEventos.verificarEdad(invitados, 5));
    }


    @Test
    void verificarBoleto() {
        assertEquals("VIP", AccesosAEventos.verificarBoleto(invitados, 0));
        assertEquals("General", AccesosAEventos.verificarBoleto(invitados, 1));
        assertEquals("General", AccesosAEventos.verificarBoleto(invitados, 2));
        assertEquals("False", AccesosAEventos.verificarBoleto(invitados, 3));
        assertEquals("General", AccesosAEventos.verificarBoleto(invitados, 4));
        assertEquals("VIP", AccesosAEventos.verificarBoleto(invitados, 5));
    }

    @Test
    void validarInvitados() {
        assertTrue(AccesosAEventos.validarInvitados(invitados, 0));
        assertFalse(AccesosAEventos.validarInvitados(invitados, 1));
        assertFalse(AccesosAEventos.validarInvitados(invitados, 2));
        assertFalse(AccesosAEventos.validarInvitados(invitados, 3));
        assertFalse(AccesosAEventos.validarInvitados(invitados, 4));
        assertFalse(AccesosAEventos.validarInvitados(invitados, 5));

    }

    @Test
    void aforoDisponible() {
        String[][] invitadosConDatos = {
                {"Juan", "19", "VIP", "2", "True"},
                {"Ana", "17", "VIP", "1", "True"},
                {"Luis", "18", "General", "0", "True"},
                {"Maria", "22", "General", "0", "False"}
        };

        assertEquals(1, AccesosAEventos.aforoDisponible(invitadosConDatos, "VIP"));
        assertEquals(3, AccesosAEventos.aforoDisponible(invitadosConDatos, "General"));
    }

    @Test
    void permitirEntrada() {
        AccesosAEventos.ingresarPersona(invitados, 0);
        assertEquals("True", invitados[0][4]);
    }

    @AfterEach
    void borrarMatriz () {
    invitados = null;
    }
}