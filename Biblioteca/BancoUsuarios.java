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
                    if(emprestimoElemento.getLivro().getTitulo().equals(nomeLivroBuscado))
                    {
                        return emprestimoElemento;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<EmprestimoLivro> getEmprestimos(int idUsuario)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                return usuarioElemento.getEmprestimos();
            }
        }
        return null;
    }
    
    public static ReservaRecibo getReserva(int idUsuario, String nomeLivroBuscado)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                for(ReservaRecibo reservaElemento: usuarioElemento.getReservas())
                {
                    if(reservaElemento.getLivro().getTitulo().equals(nomeLivroBuscado))
                    {
                        return reservaElemento;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<ReservaRecibo> getReservas(int idUsuario)
    {
        for(UsuarioBiblioteca usuarioElemento : usuarios)
        {
            if(usuarioElemento.getID() == idUsuario)
            {
                return usuarioElemento.getReservas();
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