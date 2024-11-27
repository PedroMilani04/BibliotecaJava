package com.mycompany.bibliotecafinal;
/**
 *
 * @author arthu
 */
public class BibliotecarioFactory {
    private static int flagDono = 0;
    
    public static Bibliotecario criarDono(String nome, String email, String CPF, String endereco, String nickname)
    {
        if(flagDono < 2)
        {
            flagDono++;
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
