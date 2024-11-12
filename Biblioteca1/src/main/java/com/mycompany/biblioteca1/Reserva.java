package com.mycompany.biblioteca1;

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

import java.time.LocalDate;
import java.util.ArrayList;



/**
 *
 * @author cristian.eidi_unesp
 */
public class Reserva {

    private Livro livroReservado;
    private ArrayList<UsuarioBiblioteca> arrayUsuarios;
    private ArrayList<LocalDate> arrayTempo; // para manter track dos usuarios e seus respectivos tempos
    
    public Reserva( Livro livro, UsuarioBiblioteca usuario ) {
        this.livroReservado = livro;
        
        
        arrayUsuarios = new ArrayList<UsuarioBiblioteca>();
        arrayUsuarios.add( usuario );
        
        arrayTempo = new ArrayList<LocalDate>();
        arrayTempo.add( LocalDate.now() );
        
    }

    public Livro getLivro(){
        return this.livroReservado;
    }
    
    public boolean checarSeUsuario(UsuarioBiblioteca usuario){
        for( int contador = 0, numeroDeUsuarios = arrayUsuarios.size(); contador < numeroDeUsuarios ; contador++ ){
            if( usuario.equals(arrayUsuarios.get(contador)) ){
                return true;
            }
        }
        return false;
    }
    
    
    public void adicionarUsuarioReserva( UsuarioBiblioteca usuario ){
        arrayUsuarios.add(usuario);
        arrayTempo.add( LocalDate.now() );
        
    }
    
    public UsuarioBiblioteca retirarEspecificoUsuario( UsuarioBiblioteca usuario ){
        for( int contador = 0, numeroDeUsuarios = arrayUsuarios.size(); contador < numeroDeUsuarios ; contador++ ){
            if( usuario.equals(arrayUsuarios.get(contador)) ){
                UsuarioBiblioteca temporario = arrayUsuarios.get(contador);
                arrayUsuarios.remove(contador);
                arrayTempo.remove(contador);
                return temporario;
            }
        }
        // caso nao encontre o usuario, returna o proximo
        return retirarProximoUsuario();
    }
    
    
    public boolean isVazio(){
        return arrayUsuarios.isEmpty();
    }
    
    // provavelmente tudo aq em baixo é inutil, mas caso eu precise vou ta usando fds
    
    public UsuarioBiblioteca retirarProximoUsuario(){
        UsuarioBiblioteca temporario = arrayUsuarios.get(0);
        arrayUsuarios.remove(0);
        arrayTempo.remove(0);
        return temporario;
    }
    
    
    public UsuarioBiblioteca checarProximoUsuario(){
        return arrayUsuarios.get(0);
    }
    
    public LocalDate checarProximoTempo(){
        return arrayTempo.get(0);
    }
    
    
    public UsuarioBiblioteca checarUltimoUsuario(){
        return arrayUsuarios.get(arrayUsuarios.size());
    }
    
    public LocalDate checarUltimoTempo(){
        return arrayTempo.get(arrayTempo.size());
    }
    
}
