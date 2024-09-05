package POOII.BibliotecaJava;

import POOII.BibliotecaJava.Livro;
import POOII.BibliotecaJava.EmprestimoLivro;
import POOII.BibliotecaJava.Reserva;
// import POOII.BibliotecaJava.Catalogo;
import POOII.BibliotecaJava.Multa;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class UsuarioBiblioteca extends Usuario {
    protected String endereco;
    protected boolean possuiMulta;
    //Arrays de emprestimos, reservas e multas. Ou seja, uma lista para cada um desses atributos
    protected ArrayList<EmprestimoLivro> emprestimos = new ArrayList<EmprestimoLivro>();
    protected ArrayList<ReciboReserva> reservas = new ArrayList<ReciboReserva>();
    protected ArrayList<Multa> multas = new ArrayList<Multa>();
    

    public UsuarioBiblioteca(String nome, String email, String CPF){
        super(nome, email, CPF);
        this.endereco = endereco;
        this.possuiMulta = false;
    }

    public int getID(){
        return ID;
    }

    public ArrayList<EmprestimoLivro> getEmprestimos(){
        return this.emprestimos; //Retorna o array por completo
    }

    public ArrayList<Reserva> getReservas(int i){
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
                Reserva reserva = (Reserva) volta; //Mesma coisa de cima, mas com reserva
                reservas.add(reserva); // adiciona no array
            }else{
                System.out.println("Livro não encontrado");
            }
        }

        public void devolverLivro(String titulo){
            for(int i = 0; i < emprestimos.size(); i++){
                if(emprestimos.get(i).getLivro().equals(titulo)){
                    Catalogo.devolverLivro(i); //Deve remover do array lá no catalogo
                    emprestimos.remove(i); //remove do array
                    System.out.println("Livro devolvido com sucesso");
                    return;
                }
            }
            System.out.println("Livro não encontrado");
        }

}
