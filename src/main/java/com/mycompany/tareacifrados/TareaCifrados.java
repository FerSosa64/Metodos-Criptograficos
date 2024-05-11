/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareacifrados;

import java.util.Scanner;

/**
 *
 * @author Fernando Sosa
 */
public class TareaCifrados {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione el metodo de encriptado:");
            System.out.println("1. Cifrado Espartano");
            System.out.println("2. Cifrado Cesar");
            System.out.println("3. Cifrado Vigenere");
            System.out.println("4. Salir");
            int metodo = scanner.nextInt();
            if (metodo == 4) {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.println("Seleccione la accion a realizar:");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            int accion = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el texto:");
            String texto = scanner.nextLine();

            switch (metodo) {
                case 1:
                    System.out.println("Ingrese el numero de filas:");
                    int numFilas = scanner.nextInt();
                    if (accion == 1)
                        System.out.println("Texto encriptado con Cifrado Espartano: " + cifrarEspartano(texto,numFilas));
                    else
                        System.out.println("Texto desencriptado con Cifrado Espartano: " + descifrarEspartano(texto,numFilas));
                    break;
                case 2:
                    System.out.println("Ingrese el numero de filas:");
                    if (accion == 1)
                        System.out.println("Texto encriptado con Cifrado Cesar: " + cifrarCesar(texto));
                    else
                        System.out.println("Texto desencriptado con Cifrado Cesar: " + descifrarCesar(texto));
                    break;
                case 3:
                    System.out.println("Ingrese la clave para el Cifrado Vigenere:");
                    String clave = scanner.nextLine();
                    if (accion == 1)
                        System.out.println("Texto encriptado con Cifrado Vigenere: " + cifrarVigenere(texto, clave));
                    else
                        System.out.println("Texto desencriptado con Cifrado Vigenere: " + descifrarVigenere(texto, clave));
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    public static String cifrarEspartano(String texto, int numFilas) {
        StringBuilder textoCifrado = new StringBuilder();
        for (int i = 0; i < numFilas; i++) {
            for (int j = i; j < texto.length(); j += numFilas) {
                textoCifrado.append(texto.charAt(j));
            }
            textoCifrado.append(" "); 
        }
        return textoCifrado.toString();
    }

    public static String descifrarEspartano(String texto,int numFilas) {
        StringBuilder textoDescifrado = new StringBuilder();
        int filaLength = (int) Math.ceil((double) texto.length() / numFilas);
        for (int i = 0; i < filaLength; i++) {
            for (int j = i; j < texto.length(); j += filaLength) {
                textoDescifrado.append(texto.charAt(j));
            }
        }
        return textoDescifrado.toString().replace(" ", ""); 
    }


    public static String cifrarCesar(String texto) {
        int clave = 3; 
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                resultado.append((char) (((c - base + clave) % 26) + base));
            } else {
                resultado.append(c); 
            }
        }
        return resultado.toString();
    
    }

    public static String descifrarCesar(String texto) {
        int clave = 3;
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                resultado.append((char) (((c - base - clave + 26) % 26) + base));
            } else {
                resultado.append(c); 
            }
        }
        return resultado.toString();
    }


    public static String cifrarVigenere(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        int claveIndex = 0;
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int desplazamiento = clave.charAt(claveIndex) - 'a';
                resultado.append((char) (((c - base + desplazamiento) % 26) + base));
                claveIndex = (claveIndex + 1) % clave.length();
            } else {
                resultado.append(c); 
            }
        }
        return resultado.toString();
    }

    public static String descifrarVigenere(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        int claveIndex = 0;
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int desplazamiento = clave.charAt(claveIndex) - 'a';
                resultado.append((char) (((c - base - desplazamiento + 26) % 26) + base));
                claveIndex = (claveIndex + 1) % clave.length();
            } else {
                resultado.append(c); 
            }
        }
        return resultado.toString();
    }

        
}

