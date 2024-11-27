package Biblioteca;

import java.time.LocalDate;
import java.time.Period;

public class GerenciarEmprestimo {

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
        if (user.getPossuiMulta()) {
                  System.out.println("NULL: Possui Multa.");
            return null;

        } else {
            if (Catalogo.disponivel(livro)) {
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

