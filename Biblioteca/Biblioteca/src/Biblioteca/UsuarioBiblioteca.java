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
    
    protected GerenciarEmprestimo gerenciarEmprestimo = GerenciarEmprestimo.getInstancia();
    protected Catalogo catalogo = Catalogo.getInstancia();
    
    public UsuarioBiblioteca(String nome, String email, String CPF, String endereco, String nickname){
        super(nome, email, CPF, nickname);
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
    
    public boolean getPossuiMulta()
    {
        return this.possuiMulta;
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
            EmprestimoLivro volta = gerenciarEmprestimo.realizarEmprestimo(this, catalogo.exibirLivroTitulo(titulo));//a função já diz por só propria o que faz
            if(volta != null){
                emprestimos.add(volta);
                System.out.println("Emprestimo realizado com sucesso");
            }else{

                System.out.println("Emprestimo não realizado");

                //Preciso de uma função do catalogo pra saber o pq não houve emprestimo
            }
        }

        public void novaReserva(String titulo){
            ReservaRecibo volta = GerenciamentoReserva.AdicionarReservaLivro(catalogo.exibirLivroTitulo(titulo), this);
            reservas.add(volta);
            System.out.println("Reserva realizada com sucesso");
        }



        public void devolverLivro(String titulo){
            for(int i = 0; i < emprestimos.size(); i++){
                if(emprestimos.get(i).getLivro().getTitulo().equals(titulo)){ //Se o livro for igual ao titulo passado 
                    Livro aux = emprestimos.get(i).getLivro();
                    catalogo.devolverLivro(aux.getIsbn(),aux.getTombo()); //Deve remover do array lá no catalogo
                    emprestimos.remove(i); //remove do array
                    System.out.println("Livro devolvido com sucesso");
                    return;
                }
            }
            System.out.println("Livro não encontrado");
        }

}
