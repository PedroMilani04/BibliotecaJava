package POOII.BibliotecaJava;

import POOII.BibliotecaJava.Livro;
import POOII.BibliotecaJava.EmprestimoLivro;
import POOII.BibliotecaJava.Reserva;
import POOII.BibliotecaJava.Catalogo;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class UsuarioBiblioteca extends Usuario {
    protected String endereco;
    protected ArrayList<EmprestimoLivro> emprestimos = new ArrayList<EmprestimoLivro>();
    protected ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    

    public UsuarioBiblioteca(String nome, String email, String CPF){
        super(nome, email, CPF);
        this.endereco = endereco;
    }

    public int getID(){
        return ID;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return endereco;
    }

        public void novoEmprestimo(String titulo){
            Object volta =  Catalogo.getLivro(titulo);
            if(volta instanceof EmprestimoLivro){
                EmprestimoLivro emprestimo = (EmprestimoLivro) volta; //Casting de volta para EmprestimoLivro
                emprestimos.add(emprestimo);
            }if(volta instanceof Reserva){
                Reserva reserva = (Reserva) volta;
                reservas.add(reserva);
            }else{
                System.out.println("Livro não encontrado");
            }
        }

        public void devolverLivro(String titulo){
            for(int i = 0; i < emprestimos.size(); i++){
                if(emprestimos.get(i).getLivro().equals(titulo)){
                    emprestimos.remove(i);
                    Catalogo.devolverLivro(titulo);
                    System.out.println("Livro devolvido com sucesso");
                    return;
                }
            }
            System.out.println("Livro não encontrado");
        }

}
