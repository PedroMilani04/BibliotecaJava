package com.mycompany.biblioteca1;
import java.time.LocalDate;
import java.time.Period;


// !!! SINGLETON !!!
public class GerenciarEmprestimo {
       private Catalogo catalogo = Catalogo.getInstancia();

    private static GerenciarEmprestimo instancia;

    // Construtor privado para evitar instância externa
    private GerenciarEmprestimo() {
    }

    // Método para obter a instância única
    public static synchronized GerenciarEmprestimo getInstancia() {
        if (instancia == null) {
            instancia = new GerenciarEmprestimo();
        }
        return instancia;
    }

    public EmprestimoLivro realizarEmprestimo(UsuarioBiblioteca user, Livro livro) {
        if (user.possuiMulta) {
                  System.out.println("NULL: Possui Multa.");
            return null;

        } else {
            if (catalogo.getLivro(livro.getIsbn()).equals(EnumDisponibilidade.DISPONIVEL)) { // !!!!!!! Catalogo.disponivel(livro, INSTANCIAR CATALOGO, transforma-lo num singleton, fazer a função disponivel em catalogo
                LocalDate dataComeco = LocalDate.now();
                LocalDate dataFim = dataComeco.plus(Period.ofDays(30));
                return new EmprestimoLivro(livro, user, dataComeco, dataFim);
            }
        }
              System.out.println("NULL: Livro Indisponível.");
        return null;
        
    }
}

// uso: GerenciarEmprestimo gerenciador = GerenciarEmprestimo.getInstancia();

