package POOII.BibliotecaJava;

import java.util.ArrayList;


/**
 *
 * @author cristian.eidi_unesp
 */

public class GerenciamentoReserva {
    private static ArrayList<Reserva> gerenciadorReserva = new ArrayList<Reserva>();
    
    
    public static void AdicionarReservaLivro(Livro livro, UsuarioBiblioteca usuario){
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(livro) ){
                gerenciadorReserva.get(contador).adicionarUsuarioReserva(usuario);
                // livro ja reservado, o usuario entra na fila de reserva
            }
        }
        Reserva livroAReservar = new Reserva(livro, usuario);
        gerenciadorReserva.add(livroAReservar);
        // livro não reservado, logo o usuario é o primeiro
    }
    
    public static void RemoverReservaLivro(Livro livro ){
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(livro) ){
                gerenciadorReserva.remove(contador);
                // livro removido com sucesso
            }
        }    
    }
    
    public static boolean RetirarReservaUsandoRecibo(ReservaRecibo recibo ){
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(recibo.getLivro() ) ){
                gerenciadorReserva.get(contador).retirarEspecificoUsuario(recibo.getUsuario());
                return true;
                // usuario retirado com sucesso
            }
        }
        return false;
    }
    
    
}
