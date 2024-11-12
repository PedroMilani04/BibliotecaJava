package Biblioteca;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;

public class Bibliotecario extends UsuarioBiblioteca{
    Bibliotecario(String nome, String email, String CPF)
    {
        super(nome, email, CPF);
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
        Catalogo.inserirLivros(titulo, autor, isbn);
    }
    
    //metodo utilizado para remover um livro
    public void removerLivro(String isbn, int tombo)
    {
        Catalogo.excluirLivro(isbn);
    }
    
    
}