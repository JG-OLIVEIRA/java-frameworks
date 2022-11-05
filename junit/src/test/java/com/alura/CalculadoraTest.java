package com.alura;
import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    
    @Test
    public void deveriaSomarDoisNumerosPositivos(){
        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);

        Assert.assertEquals(10, soma);
    }

    @Test
    public void deveriaSomarDoisNumerosNegativos(){
        Calculadora calc = new Calculadora();
        int soma = calc.somar(-3, -7);

        Assert.assertEquals(-10, soma);
    }
}
