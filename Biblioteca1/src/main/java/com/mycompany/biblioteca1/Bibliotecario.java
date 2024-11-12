package com.mycompany.biblioteca1;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;

public class Bibliotecario extends UsuarioBiblioteca{
   private Catalogo catalogo = Catalogo.getInstancia();
   private int nivel;
    Bibliotecario(String nome, String email, String CPF, String endereco, String nickname, int nivel)
    {
        super(nome, email, CPF, endereco, nickname);
        this.nivel = nivel;
    }
    
    Bibliotecario(String nome, String email, String CPF, String endereco, String nickname)
    {
        super(nome, email, CPF, endereco, nickname);
        this.nivel = 0;
    }
    
    public int getNivel()
    {
        return this.nivel;
    }
    
    private void setNivelProprio(int nivel)
    {
        this.nivel = nivel;
    }
    
    public boolean setNivel(Bibliotecario alvo, int nivel)
    {
        if(this.getNivel() > 0 && nivel < this.getNivel())
        {
            alvo.setNivelProprio(nivel);
        }
        return false;
    }
    
    //retorna uma reserva especifica de um usuario
    public ReservaRecibo getReserva(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getReserva(idUsuario,nomeLivroBuscado);
    }

    //retorna um array contendo todas as reservas de um usuario
    public ArrayList<ReservaRecibo> getReservas(int idUsuario)
    {
        return BancoUsuarios.getReservas(idUsuario);
    }

    //retorna um emprestimo especifico de um usuario
    public EmprestimoLivro getEmprestimo(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getEmprestimo(idUsuario, nomeLivroBuscado);
    }

    //retorna um array contendo todos os emprestimos de um usuario
    public ArrayList<EmprestimoLivro> getEmprestimos(int idUsuario)
    {
        return BancoUsuarios.getEmprestimos(idUsuario);
    }
    
    public ArrayList<Multa> getMultas(int idUsuario)
    {
        return BancoUsuarios.getMultas(idUsuario);
    }

    //metodo utilizado para quitar a divida, retorna true caso conseguir e false caso nao conseguir
    public boolean quitarMulta(String codMulta, int idUsuario)
    {
        for(Multa multaElemento : getMultas(idUsuario))
        {
            if(multaElemento.getCodMulta().equals(codMulta))
            {
                multaElemento.quitarMulta();
                return true;
            }
        }
        return false;
    }
    
    //metodo utilizado para adicionar um livro
    public void adicionarLivro(String titulo, String autor, String isbn)
    {
        catalogo.inserirLivros(titulo, autor, isbn);
    }
    
    //metodo utilizado para remover um livro
    public void removerLivro(String isbn, int tombo)
    {
        catalogo.excluirLivro(isbn, tombo);
    }
}