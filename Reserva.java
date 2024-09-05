package com.mycompany.mavenproject2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import POOII.BibliotecaJava.UsuarioBiblioteca;
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

    public void adicionarUsuarioReserva( UsuarioBiblioteca usuario ){
        arrayUsuarios.add(usuario);
        arrayTempo.add( LocalDate.now() );
        
    }
    
    
    public UsuarioBiblioteca retirarProximoUsuario(){
        UsuarioBiblioteca temporario = arrayUsuarios.get(0);
        arrayUsuarios.remove(0);
        arrayTempo.remove(0);
        return temporario;
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
    
    public void exibirTodosUsuarios(){
        int contadorTamanho = arrayUsuarios.size(), ano,mes,dia ;
        
        for( int contador = 0; contador < contadorTamanho; contador++ ){
            
            String nome = arrayUsuarios.get(contador).getNome();
            System.out.println("Nome do Usuario: " + nome);
            
            ano = arrayTempo.get(contador).getYear();
            mes = arrayTempo.get(contador).getMonthValue();
            dia = arrayTempo.get(contador).getDayOfMonth();
            System.out.println("Data: " + dia + "/" + mes + "/" + ano);
        }
    }
}
