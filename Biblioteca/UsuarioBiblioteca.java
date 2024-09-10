package Biblioteca;

import Biblioteca.Livro;
import Biblioteca.EmprestimoLivro;
import Biblioteca.Reserva;
import Biblioteca.ReservaRecibo;
import Biblioteca.BancoUsuarios;
import Biblioteca.Catalogo; // Proximo a ser adc
import Biblioteca.Multa;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class UsuarioBiblioteca extends Usuario {
    protected String endereco;
    protected boolean possuiMulta;
    //Arrays de emprestimos, reservas e multas. Ou seja, uma lista para cada um desses atributos
    protected ArrayList<EmprestimoLivro> emprestimos;
    protected ArrayList<ReservaRecibo> reservas;
    protected ArrayList<Multa> multas;
    

    public UsuarioBiblioteca(String nome, String email, String CPF){
        super(nome, email, CPF);
        this.endereco = endereco;
        this.possuiMulta = false;
        this.emprestimos = new ArrayList<EmprestimoLivro>();
        this.reservas = new ArrayList<ReservaRecibo>();
        this.multas = new ArrayList<Multa>();
        BancoUsuarios.adicionarUsuario(this);
    }

    public int getID(){
        return ID;
    }

    public ArrayList<EmprestimoLivro> getEmprestimos(){
        return this.emprestimos; //Retorna o array por completo
    }

    public ArrayList<ReservaRecibo> getReservas(){
        return this.reservas; //Mesma coisa de cima
    }

    public ArrayList<Multa> getMultas(){
        return this.multas; // The same...
    }

    public void setEndereco(String endereco){
        this.endereco = endereco; //caso erre na hora do cadastro
    }

    public String getEndereco(){
        return endereco;
    }

        public void novoEmprestimo(String titulo){
            Object volta =  Catalogo.getLivro(titulo); //Object para saber oq voltar, pode retornar um reserva ou emprestimo, pior caso NULL.
            if(volta instanceof EmprestimoLivro){
                EmprestimoLivro emprestimo = (EmprestimoLivro) volta; //Casting de volta para EmprestimoLivro, ou seja, afirmando que volta é um emprestimo
                emprestimos.add(emprestimo); //Adiciona no array
            }if(volta instanceof Reserva){
                ReservaRecibo reserva = (ReservaRecibo) volta; //Mesma coisa de cima, mas com reserva
                reservas.add(reserva); // adiciona no array
            }else{
                System.out.println("Livro não encontrado");
            }
        }

        public void devolverLivro(String titulo){
            for(int i = 0; i < emprestimos.size(); i++){
                if(emprestimos.get(i).getLivro().getTitulo().equals(titulo)){ //Se o livro for igual ao titulo passado 
                    Catalogo.devolverLivro(emprestimos.get(i).getLivro()); //Deve remover do array lá no catalogo
                    emprestimos.remove(i); //remove do array
                    System.out.println("Livro devolvido com sucesso");
                    return;
                }
            }
            System.out.println("Livro não encontrado");
        }

}
