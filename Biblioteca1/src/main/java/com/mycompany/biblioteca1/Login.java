/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca1;

public class Login {
    protected Proxy proxy = new Proxy();

    public Login(){
        //Construtor vazio
    }

    public Usuario loginEmail(String email, String senha){
        Usuario usu = proxy.verificacaoEmail(email, senha);
        if(usu != null){
            System.out.println("Login efetuado com sucesso");
            if(usu instanceof UsuarioBiblioteca){
                return (UsuarioBiblioteca)usu;
            }
            else{
                return (Bibliotecario)usu;
            }
        }
        else{
            System.out.println("Email ou senha incorretos");
            return null;
        }
    }

    public Login loginNickname(String nickname, String senha){
        Usuario usu = proxy.verificacaoNickname(nickname, senha);
        if(usu != null){
            System.out.println("Login efetuado com sucesso");
            return this;
        }
        else{
            System.out.println("Nickname ou senha incorretos");
            return null;
        }
    }


    
}
