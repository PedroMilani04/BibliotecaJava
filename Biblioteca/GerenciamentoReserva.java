package Biblioteca;

import java.util.ArrayList;

// Gerencimaneto Reserva: possui metodos statics para que o usuario utilize
// sendo possivel as seguintes funcionalidades
//
// 1- AdicionarReservaLivro
// cria e retorna um recibo para o usuario, parametros livro e usuario respectivamente
// existe medidas para cuidar de livros reservados e nao reservados, sempre retornando
// um recibo e adicionando um usuario a Reserva do livro em questao
//
// 2- RemoverReservaLivro
// literalmente remove um livro da reserva junto com os usuarios, tomar cuidado com isso kk
//
// 3- RetirarReservaUsandoRecibo
// retorna true ou false, parametro o recibo
// --se for true, o usuario eh removido do arrayUsuarios da reserva, que gerencia um
// livro, entao tomar cuidado que ele sera retirado apos a utilizacao
//
// --se for false, nada acontece lol


// Reserva: cuida de livros individualmente, gerenciando os usuarios e o tempo tambem
// porem como nao possui um sistema de prioridade no momento, o tempo eh indiferente
// para possiveis funcionalidades futuras
// nota: um objeto Reserva eh criado para cada livro, logo uma reserva possui apenas
// um livro e nada mais


// ReservaRecibo: so pra ter ctz q o usuario reservou, os recibos estao dentro dos usuarios

/**
 *
 * @author cristian.eidi_unesp
 */

public class GerenciamentoReserva {
    private static ArrayList<Reserva> gerenciadorReserva = new ArrayList<Reserva>();
    
    // retorna um recibo apos passar o livro e o usuario 
    // os ifs garantem se o livre existe ou nao
    public static ReservaRecibo AdicionarReservaLivro(Livro livro, UsuarioBiblioteca usuario){
        ReservaRecibo recibo = new ReservaRecibo(livro, usuario);
        
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(livro) )
            {
                gerenciadorReserva.get(contador).adicionarUsuarioReserva(usuario);
                // livro ja reservado
                return recibo;
            }
        }
        Reserva livroAReservar = new Reserva(livro, usuario);
        gerenciadorReserva.add(livroAReservar);
        livro.setDisponibilidade(EnumDisponibilidade.RESERVADO);
        return recibo;
        // livro não reservado, logo o usuario é o primeiro
    }
    
    // caso queira remover completamente o livro da reserva
    // nota: remove também os usuarios, utilizar com cuidado
    public static void RemoverReservaLivro(Livro livro ){
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(livro) ){
                gerenciadorReserva.remove(contador);
                // livro removido com sucesso
            }
        }    
    }
    
    // true caso tenha achado o livro e o recibo eh do usuario
    // false caso contrario em qualquer uma das condicoes
    public static boolean RetirarReservaUsandoRecibo(ReservaRecibo recibo ){
        for(int contador = 0; contador < gerenciadorReserva.size(); contador++ ){
            if( gerenciadorReserva.get(contador).getLivro().equals(recibo.getLivro()) && 
                gerenciadorReserva.get(contador).checarSeUsuario(recibo.getUsuario()) )
            { // esse if checa se o recibo bate com o livro e se o livro tem reserva no nome do usuario
                gerenciadorReserva.get(contador).retirarEspecificoUsuario(recibo.getUsuario());
                if(gerenciadorReserva.get(contador).isVazio()){
                    recibo.setDisponibilidade(EnumDisponibilidade.DISPONIVEL);
                }
                
                return true;
                // permitido com sucesso
            }
        }
        return false;
        // nao encontrou o livro
    }
    
    
}
