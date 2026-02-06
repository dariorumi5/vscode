package com.ilerna.pruebas;
import java.util.ArrayList;


/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
    public static final double IVA = 0.21;
    public static final double PORCENTAJE_DESCUENTO = 0.10;
    public static final double GASTOS_ENVIO = 15.95;
    public static final double DESCUENTO_UMBRAL = 100.0;
    public static final double PRECIO_MONITOR = 150.0;
    public static final double PRECIO_TECLADO = 50.0;
    public static final double UMBRAL_ENVIO = 500.0;
 
    public static void main(String[] args) {
        ProcesadorPedidos proc = new ProcesadorPedidos();
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        nombres.add("Monitor");
        precios.add(PRECIO_MONITOR);
        
        nombres.add("Teclado");
        precios.add(PRECIO_TECLADO);
        
        double resultado = proc.procesar(nombres, precios);
        System.out.println("Total a pagar: " + resultado);
    }
    public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double total = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            total = total + precios.get(i);
        }
        
        // Lógica de descuento
        if (total > DESCUENTO_UMBRAL) {
            System.out.println("Descuento aplicado.");
            total = total - (total * PORCENTAJE_DESCUENTO); 
        }
        
        // Cálculo de impuestos
        double totalConImpuestos = total + (total * IVA);
        
        // Gastos de envío
        if (totalConImpuestos < UMBRAL_ENVIO) {
            totalConImpuestos = totalConImpuestos + GASTOS_ENVIO;
        }
        
        return totalConImpuestos;
    }
}

