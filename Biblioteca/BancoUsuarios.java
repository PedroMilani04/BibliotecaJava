package Biblioteca;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;

public class BancoUsuarios {
    //Array estatico, pois a classe nao sera instanciada.
    private static ArrayList<UsuarioBiblioteca> usuarios = new ArrayList<UsuarioBiblioteca>();
    
    //adiciona o usuario recebido no array de usuarios
    public static void adicionarUsuario(UsuarioBiblioteca novoUsuario)
    {
        usuarios.add(novoUsuario);
    }
    
    //retorna um emprestimo especifico de um usuario
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

    //retorna um array contendo todos os emprestimos de um usuario
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
    
    //retorna uma reserva especifica de um usuario
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

    //retorna um array contendo todas as reservas de um usuario
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

    //retorna um array com todas as multas de um usuario
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