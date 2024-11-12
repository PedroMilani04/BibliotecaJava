/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca1;

/**
 * @author arthu
 */
public class Utilidade {
    
    private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
    
    /*
    *  Arredonda um valor do tipo double para o valor int mais próximo, caso for um valor X.5 será arredondado para cima.
    */
    public static int arredondarDoubleInt(double valor)
    {
        int valorInteiro = (int)valor;
        valor = valor - valorInteiro;
        if(valor >= 0.5)
        {
            valorInteiro++;
        }
        return valorInteiro;
    }
    
    /*
    *  Gera uma string de caracteres do alfabeto(maiscula e minuscula) e de algarismos,
    *  O tamanho da string é definida pelo parametro
    */
    public static String gerarStringAleatoria(int tamanho)
    {
         StringBuilder stringNova = new StringBuilder(tamanho);
         
         int posicaoAleatoria;
         
         for(int i = 0; i < tamanho; i++)
         {
            posicaoAleatoria  = arredondarDoubleInt(caracteres.length() * Math.random());
            stringNova.append(caracteres.charAt(posicaoAleatoria));
         }
         
         return stringNova.toString();
    }
    
    /*
    *  Calcula um dos digitos ultimos digitos do CPF
    *  o digito calculado depende do parametro, 
    *  caso o valor do parametro for 0, irá ser calculado o penúltimo digito do CPF,
    *  caso o valor do parametro for 1, irá ser calculado o últiomo digo do CPF.
    */
    private static char calcularDigitoCPF(String CPF, int inicio)
    {
        int total = 0;
        int multiplicador = 10;
        for(int i = inicio; i < inicio + 9; i++)
        {
            total = total + Character.getNumericValue(CPF.charAt(i)) * multiplicador;
            multiplicador--;
        }
        
        total = total % 11;

        if(total == 1 || total == 0)
        {
            return '0';
        }
        return Character.forDigit((11 - total), 10);
    }
    
    /*
    *  Verifica se o CPF recebbido pelo parametro é valido ou não.
    *  retorna true ou false
    *  O formato do CPF é abcdefghij e não abc.def.fgh-ij
    */
    public static boolean verificarCPF(String CPF)
    {
        //supondo que o CPF nao tenha . ou -
        if(calcularDigitoCPF(CPF,0) != CPF.charAt(9))
        {
            return false;
        } 

        return calcularDigitoCPF(CPF,1) == CPF.charAt(10);
    }
}
