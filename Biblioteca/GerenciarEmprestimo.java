package Biblioteca;
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

    public EmprestimoLivro realizarEmprestimo(USUARIO user, LIVRO livro) {
        if (user.possuiMulta) {
            return null;
        } else {
            if (Catalogo.disponivel(livro)) {
                LocalDate dataComeco = LocalDate.now();
                LocalDate dataFim = dataComeco.plus(Period.ofDays(30));
                return new EmprestimoLivro(livro, user, dataComeco, dataFim);
            }
        }
        return null;
    }
}

// uso: GerenciarEmprestimo gerenciador = GerenciarEmprestimo.getInstancia();

