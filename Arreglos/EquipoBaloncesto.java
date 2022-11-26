package Arreglos;

import java.util.Scanner;

import Arreglos.Jugador;

public class EquipoBaloncesto {

    public static void main(String[] args) {

        //pidiendo los datos 
        
         Scanner scan = new Scanner(System.in);
        String nombre;
        String apellido;
        float estatura;
        int edad;
        float velocidad;
        float salto;
        float peso;
        float envergadura;
        
        System.out.println("ingrese la cantidad de jugadores a ingresar:  ");
        int cantidad = scan.nextInt();
        System.out.println("ingrese la cantidad de jugadores a ingresar:  ");
        int cantidad1 = scan.nextInt();
        Jugador j[] = new Jugador[cantidad1];
        for (int i = 0; i < j.length; i++) {
            System.out.println("datos del jugador # "+(i+1));
            System.out.println("ingrese el nombre: ");
            nombre = scan.next();
            System.out.println("ingrese el apellido: ");
            apellido = scan.next();
            System.out.println("ingrese la estatura(cm): ");
            estatura = scan.nextFloat();
            System.out.println("ingrese la edad: ");
            edad = scan.nextInt();
            System.out.println("ingrese la velocidad max(km/h): ");
            velocidad = scan.nextFloat();
            System.out.println("ingrese el alcance de salto(cm): ");
            salto = scan.nextFloat();
            System.out.println("ingrese el peso(kg): ");
            peso = scan.nextFloat();
            System.out.println("ingrese la envergadura: ");
            envergadura= scan.nextFloat();
            j[i] = new Jugador(nombre,apellido,estatura,edad,velocidad,salto,peso,envergadura);
        }
         
        double promedioEstatura, suma = 0;
        //variables para sacar los porcentajes
        double velocidadP, saltoP, pesoP, envergaduraP;
        double sumaV = 0, sumaS = 0, sumaP = 0, sumaE = 0;
        double formulaEnv;
        String capacitadosA = "";
        double[] IMC = new double[5];
        double cm_m;
        Jugador ju ;
        //ingresarlos de manera manual
        //paso 1
        Jugador j1[] = new Jugador[5];
        j1[0] = new Jugador("josue   ", "mojica  ", 185, 21, 31, 102, 86, 192);
        j1[1] = new Jugador("hollman ", "vargas  ", 192, 25, 28, 110, 90, 192);
        j1[2] = new Jugador("fernando", "mendoza ", 188, 28, 30, 100, 85, 195);
        j1[3] = new Jugador("juan    ", "martinez", 196, 26, 33, 98, 100, 210);
        j1[4] = new Jugador("neffer  ", "cano    ", 205, 31, 15, 40, 120, 211);
        //ordenar por el mas rapido
        int k, l, aux;
        for (k = 0; k < j1.length - 1; k++) {
            for (l = 0; l < j1.length - k - 1; l++) {
                if (j1[l + 1].getVelocidad() > j1[l].getVelocidad()) {
                    ju = j1[l + 1];
                    j1[l + 1] = j1[l];
                    j1[l] = ju;
                }
            }
        }
        System.out.println("Lista de jugadores del mas rapido al mas lento: ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("no.          nombre del jugador             estatura(cm)   edad    velocidad max(km/h)     alcance en salto(cm)    peso(kg)     envergadura");
        for (int i = 0; i < j1.length; i++) {
            formulaEnv = 0;
            System.out.println((i + 1) + "" + j1[i]);
            //paso 2
            suma += j1[i].getEstatura();
            formulaEnv = (j1[i].getEstatura() + ((j1[i].getEnvergadura()) * 0.7)) + j1[i].getSalto();
            if (formulaEnv >= 305) {
                capacitadosA += j1[i].getNombre() + " " + j1[i].getApellido() + "\n";
            }
            //calculo de IMC convertimos los cm a metros para poder hacer uso de la formula
            cm_m = j1[i].getEstatura() / 100;
            IMC[i] = j1[i].getPeso() / (Math.pow(cm_m, 2));
            //calculando promedios de los jugadores
            sumaV += j1[i].getVelocidad();
            sumaP += j1[i].getPeso();
            sumaE += j1[i].getEnvergadura();
            sumaS += j1[i].getSalto();
        }
        //metodo burbuja para ordenar segun el IMC
        for (k = 0; k < IMC.length - 1; k++) {
            for (l = 0; l < IMC.length - k - 1; l++) {
                if (IMC[l + 1] < IMC[l]) {
                    aux = (int) IMC[l + 1];
                    IMC[l + 1] = IMC[l];
                    IMC[l] = aux;
                    ju = j1[l + 1];
                    j1[l + 1] = j1[l];
                    j1[l] = ju;
                }
            }
        }
        pesoP = sumaP / 5;
        saltoP = sumaS / 5;
        velocidadP = sumaV / 5;
        envergaduraP = sumaE / 5;
        promedioEstatura = suma / 5;
        String jugadorIdeal = "";
        String NOjugadorIdeal = "";
        //ver quien es el jugador mejor capacitado parametros para elegir al jugador mas completo: (estatura-25%,velocidad-25%,salto-20%,peso-10%,envergadura-20%
        double pesoI, velocidadI, enverI, saltoI, alturaI;
        //con los datos dados no hay nadie con los porcentajes ideales nisiquiera llegan a 25%
        for (int i = 0; i < j1.length; i++) {
            alturaI = (j1[i].getEstatura() / suma) * 100;
            pesoI = (j1[i].getPeso() / sumaP) * 100;
            velocidadI = (j1[i].getVelocidad() / sumaV) * 100;
            saltoI = (j1[i].getSalto() / sumaS) * 100;
            enverI = (j1[i].getEnvergadura() / sumaE) * 100;
            if ((alturaI >= 25) && (velocidadI >= 25) && (saltoI >= 20) && (pesoI >= 10) && (enverI >= 20)) {
                jugadorIdeal += j1[i].getNombre() + " " + j1[i].getApellido() + "\n";
            } else {
                NOjugadorIdeal += "\n" + j1[i].getNombre() + " " + j1[i].getApellido() + "\n"
                        + "altura: " + alturaI + " peso: " + pesoI + " velocidad: " + velocidadI + "\n"
                        + "salto: " + saltoI + " envergadura: " + enverI + "\n"
                        + "_____________________________________________________________";

            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
          System.out.println("peso promedio de los jugadores(Kg): " + pesoP);
            System.out.println("velocidad promedio de los jugadores(Km/h): " + velocidadP);
             System.out.println("salto promedio de los jugadores: (cm)" + saltoP);
        System.out.println("envergadura promedio de los jugadores: " + envergaduraP);
        
            System.out.println("-----------------------------------------------------------------------------------------------");
          System.out.println("Datos del equipo: ");
         System.out.println("el promedio de estatura de la linea titular es de: " + promedioEstatura);
           System.out.println("-----------------------------------------------------------------------------------------------");
         System.out.println("parametros para elegir al jugador mas completo:\n (estatura-25%,velocidad-25%,salto-20%,peso-10%,envergadura-20%");
        System.out.println("los jugadores ideales son: ");
        System.out.println(jugadorIdeal);
        System.out.println("el resto de jugadores son: ");
        System.out.println(NOjugadorIdeal);
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        System.out.println("los jugadores capacitados para pasar por el aro son: ");
        System.out.println(capacitadosA);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("ordenado segun el IMC");
        System.out.println("no.          nombre del jugador             estatura(cm)   edad    velocidad max(km/h)     alcance en salto(cm)    peso(kg)     envergadura");
        for (int i = 0; i < j1.length; i++) {
            System.out.println((i + 1) + "" + j1[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("IMC de cada jugador: ");
        for (int i = 0; i < j1.length; i++) {
            System.out.println(IMC[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public static void burbuja(double[] A) {
        int k, j, aux;
        for (k = 0; k < A.length - 1; k++) {
            for (j = 0; j < A.length - k - 1; j++) {
                if (A[j + 1] < A[j]) {
                    aux = (int) A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
   }
   }
}

