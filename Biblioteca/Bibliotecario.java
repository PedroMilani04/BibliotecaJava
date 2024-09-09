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

    public ReservaRecibo getReserva(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getReserva(idUsuario,nomeLivroBuscado);
    }

    public ArrayList<ReservaRecibo> getReservas(int idUsuario)
    {
        return BancoUsuarios.getReservas(idUsuario);
    }

    public EmprestimoLivro getEmprestimo(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getEmprestimo(idUsuario, String nomeLivroBuscado);
    }

    public ArrayList<EmprestimoLivro> getEmprestimos(int idUsuario)
    {
        return BancoUsuarios.getEmprestimos(idUsuario);
    }
    
    public ArrayList<Multa> getMultas(int idUsuario)
    {
        return BancoUsuarios.getMultas(idUsuario);
    }

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
    
    public void adicionarLivro(Livro novoLivro)
    {
        Catalogo.adicionarLivro(novoLivro);
    }
    
    public void removerLivro(Livro excluirLivro)
    {
        Catalogo.removerLivro(excluirLivro);
    }
    
    
}