package Biblioteca;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;

public class BancoUsuarios {
    private static ArrayList<UsuarioBiblioteca> usuarios = new ArrayList<UsuarioBiblioteca>();
    
    public static void adicionarUsuario(UsuarioBiblioteca novoUsuario)
    {
        usuarios.add(novoUsuario);
    }
    
    public static EmprestimoLivro getEmprestimo(int idUsuario, String nomeLivroBuscado)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                for(EmprestimoLivro emprestimoElemento: usuarioElemento.getEmprestimos())
                {
                    //WIP foi seguido a UML de emprestimo em relacao ao tipo do atributo livro, caso mudar do tipo String para Livro, usar o if abaixo:
                    //if(emprestimoElemento.getLivro().getTitulo().equals(nomeLivroBuscado))
                    if(emprestimoElemento.getLivro().equals(nomeLivroBuscado))
                    {
                        return emprestimoElemento;
                    }
                }
            }
        }
        return null;
    }
    
    public static Reserva getReserva(int idUsuario, String nomeLivroBuscado)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                for(Reserva reservaElemento: usuarioElemento.getReservas())
                {
                    //WIP de novo supondo que o atributo dentro de Reserva seja do tipo Livro, caso for String usar o if abaixo:
                    //if(reservaElemento.getLivro().equals(nomeLivroBuscado))
                    if(reservaElemento.getLivro().getTitulo().equals(nomeLivroBuscado))
                    {
                        return reservaElemento;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<Multa> getMultas(int idUsuario)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                return usuarioElemento.getMultas();
            }
        }
        return null;
    }
}