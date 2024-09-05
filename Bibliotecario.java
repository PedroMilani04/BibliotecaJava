package POOII.BibliotecaJava;

/**
 *
 * @author arthu
 */
public class Bibliotecario extends UsuarioBiblioteca{
    Bibliotecario(String nome, String email, String CPF)
    {
        super(nome, email, CPF);
    }

    public Reserva getReserva(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getReserva(idUsuario,nomeLivroBuscado);
    }

    public EmprestimoLivro getEmprestimo(int idUsuario, String nomeLivroBuscado)
    {
        return BancoUsuarios.getEmprestimo(idUsuario,nomeLivroBuscado);
    }
    
    public ArrayList<Multa> getMultas(int idUsuario)
    {
        return BancoUsuarios.getMultas(idUsuario);
    }

    public boolean cancelarMulta(String codMulta, int idUsuario)
    {
        for(Multa multaElemento : getMultas(idUsuario))
        {
            if(multaElemento.getCodMulta().equals(codMulta))
            {
                multaProcurada.setPaga(true);
                return true;
            }
        }
        return false;
    }
    
    public void adicionarLivro(Livro novoLivro)
    {
        Catalogo.adicionarLivro(novoLivro);
    }
    
    public void removerLivro(Livro excluirLivro)
    {
        Catalogo.removerLivro(excluirLivro);
    }
    
    
}