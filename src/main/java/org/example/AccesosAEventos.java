package org.example;

public class AccesosAEventos {

    public static void main(String[] args) {
        String[][] invitados = new String[10][5];
    }

    public static Boolean verificarEdad(String[][] invitados, int fila) {
        int edad = Integer.parseInt(invitados[fila][1]);
        if (edad >= 18){
            return true;
        }else{
            return false;
        }
    }

    public static String verificarBoleto(String[][] invitados, int fila) {
        String boleto = invitados[fila][2];
        if (boleto.equals("General")) {
            return "General";
        } else if (boleto.equals("VIP")) {
            return "VIP";
        } else {
            return "False";
        }
    }

    public static Boolean validarInvitados(String[][] invitados, int fila) {
        int invitado = Integer.parseInt(invitados[fila][3]);
        String boleto = verificarBoleto(invitados, fila);
        if (boleto.equals("VIP") && 0 <= invitado && invitado <= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static int aforoDisponible(String[][] invitados, String tipoSala) {
        int aforoVIP = 6;
        int aforoGeneral = 4;
        int aforoOcupado = 0;

        for (String[] invitado : invitados) {
            if (invitado[4] != null && invitado[4].equals("True")) {
                String boleto = invitado[2];
                if (tipoSala.equals("VIP") && boleto.equals("VIP")) {
                    aforoOcupado += 1 + Integer.parseInt(invitado[3]);
                } else if (tipoSala.equals("General") && boleto.equals("General")) {
                    aforoOcupado++;
                }
            }
        }

        if (tipoSala.equals("VIP")) {
            return aforoVIP - aforoOcupado;
        } else if (tipoSala.equals("General")) {
            return aforoGeneral - aforoOcupado;
        } else {
            return 0;
        }
    }

    public static void ingresarPersona(String[][] invitados, int fila) {
        invitados[fila][4] = "True";
    }

    public static void removerPersona(String[][] invitados, int fila) {
        invitados[fila][4] = "False";
        if (verificarBoleto(invitados,fila).equals("VIP")){
            invitados[fila][3] = "0";
        }
    }

    public static Boolean permitirEntrada(String[][] invitados, int fila) {

        if (!verificarEdad(invitados,fila)){
            System.out.println("usuario menor de edad");
            return false;
        }

        String boleto = verificarBoleto(invitados,fila);
        if (boleto.equals("False")){
            System.out.println("usurio sin entrada");
            return false;
        }

        if (boleto.equals("VIP")) {
            if (aforoDisponible(invitados, "VIP") < 1 + Integer.parseInt(invitados[fila][3])) {
                System.out.println("Aforo VIP completo");
                return false;
            }
        } else if (boleto.equals("General")) {
            if (aforoDisponible(invitados, "General") < 1) {
                System.out.println("Aforo General completo");
                return false;
            }
        }

        ingresarPersona(invitados,fila);
        System.out.println("Entrada permitida");
        return true;
    }

}