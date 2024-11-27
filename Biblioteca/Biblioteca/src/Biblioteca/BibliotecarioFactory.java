/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author arthu
 */
public class BibliotecarioFactory {
    private static boolean flagDono = true;
    
    public static Bibliotecario criarDono(String nome, String email, String CPF, String endereco, String nickname)
    {
        if(flagDono)
        {
            return new Bibliotecario(nome,email,CPF,endereco,nickname,Integer.MAX_VALUE);
        }
        return null;
    }
    
    public static Bibliotecario criarBibliotecario(String nome, String email, String CPF, String endereco, String nickname)
    {
        return new Bibliotecario(nome,email,CPF,endereco,nickname);
    }
    
    public static Bibliotecario criarBibliotecario(String nome, String email, String CPF, String endereco, String nickname, int nivel)
    {
        return new Bibliotecario(nome,email,CPF,endereco,nickname,nivel);
    }
}
