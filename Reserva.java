/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.util.ArrayList;
/**
 *
 * @author cristian.eidi_unesp
 */
public class Reserva {

    private Livro livroReservado;
    private ArrayList<UsuarioBiblioteca>;
    
    public boolean reservarLivro(Livro livro){ // adicionado = true, ja ter na reserva = false
        for( int contador = 0; contador < numeroLivroReservados; contador ++){
            if( livro.equals(livroReservados.get(contador)) ){
                return false;
            }
        }
        livroReservados.add(livro);
        return true;
    }
    
    public boolean cancelarReservarLivro(Livro livro){ // cancelado = true, nao encontrou = false
        for( int contador = 0; contador < numeroLivroReservados; contador ++){
            if( livro.equals(livroReservados.get(contador)) ){
                livroReservados.remove(contador);
                return true;
            }
        }
        return false;
    }
    
    
}
