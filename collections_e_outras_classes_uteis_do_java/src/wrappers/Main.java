package wrappers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* 
        Wrapper é uma classe que encapsula um tipo primitivo, permitindo que ele seja tratado como um objeto.
        A vantagem de usar Wrappers é que eles permitem que tipos primitivos sejam usados em coleções, como ArrayList.
        Além disso, eles fornecem métodos úteis para manipulação de dados primitivos.
        Por exemplo, a classe Integer possui métodos para conversão e manipulação de números inteiros.
        */

        // Exemplos de wrappers:
        Integer inteiro = 10; // int -> Integer
        Integer it = null;
        Double decimal = 3.14; // double -> Double
        Boolean verdadeiro = true; // boolean -> Boolean

        // Conversão de String para Wrapper
        Integer numero = Integer.valueOf("123");
        Double valorDecimal = Double.valueOf("45.67");

        // Exibindo os valores
        System.out.println("Inteiro: " + inteiro);
        System.out.println("Decimal: " + decimal);
        System.out.println("Booleano: " + verdadeiro);
        System.out.println("Número convertido: " + numero);
        System.out.println("Valor Decimal convertido: " + valorDecimal);

        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(inteiro);
        listaNumeros.add(decimal.intValue()); // Convertendo Double para Integer
        System.out.println("Lista de Números: " + listaNumeros);

    }
}
