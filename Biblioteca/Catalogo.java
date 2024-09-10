/*

 */
package Biblioteca;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;

public class Catalogo {
    private static ArrayList<Titulo> titulos = new ArrayList<Titulo>();
    
    public static Titulo buscarTitulo(String tituloAlvo)
    {
        for(int i = 0; i < titulos.size(); i++)
        {
            //WIP getExemplar eh um metodo que retorna a primeira copia de um livro, provavelmente no futuro vou mudar para um nome melhor
            if(titulos.get(i).getExemplar().getTitulo().equals(tituloAlvo))
            {
                return titulos.get(i);
            }
        }
        return null;
    }
    
    //WIP temporariamente void, pois nao ha verificacao de insercao
    public static void adicionarTitulo(Titulo novoTitulo)
    {
        titulos.add(novoTitulo);
    }
    
    public static void removerTitulo(Titulo tituloAlvo)
    {
        for(int i = 0; i < titulos.size(); i++)
        {
            if(titulos.get(i).getExemplar().getTitulo().equals(tituloAlvo.getExemplar().getTitulo()))
            {
                titulos.remove(i);
            }
        }
    }
    
    public static ReservaRecibo reservarLivro(Livro livro, UsuarioBiblioteca usuario)
    {
        return GerenciamentoReserva.AdicionarReservaLivro(livro,usuario);
    }
    
    //WIP temporariamente void, pois nao ha verificacao de retorno
    public static void devolverLivro(Livro livroDevolvido)
    {
        livroDevolvido.setDisponibilidade(EnumDisponibilidade.DISPONIVEL);
    }
    
    //WIP temporariamente void, pois nao ha verificacao de retorno
    public static void adicionarLivro(String titulo, String autor, String isbn)
    {
        Titulo tituloLivro = buscarTitulo(titulo);
        if(tituloLivro != null)
        {
            Livro novoLivro = new Livro(titulo, autor, isbn, tituloLivro.getCopias().size()+1);
            tituloLivro.adicionarCopia(novoLivro);
        }
        else
        {
            //WIP o tombo esta atualmente comecando no valor 1
            Livro novoLivro = new Livro(titulo, autor, isbn, 1);
            tituloLivro = new Titulo(novoLivro);
            adicionarTitulo(tituloLivro);
        }
    }
    
    public static void removerLivro(Livro livroAlvo)
    {
        Titulo tituloLivro = buscarTitulo(livroAlvo.getTitulo());
        if(tituloLivro != null)
        {
            if(tituloLivro.getCopias().size() == 1)
            {
                removerTitulo(tituloLivro);
            }
            else
            {
                tituloLivro.removerCopia(livroAlvo);
            }
        }
    }
    
    public boolean disponivel(Livro livroAlvo)
    {
        boolean flag = false;
        Titulo tituloLivro = buscarTitulo(livroAlvo.getTitulo());
        if(tituloLivro != null)
        {
            for (Livro copiaLivro : tituloLivro.getCopias()) 
            {
                if(copiaLivro.getDisponibilidade().equals(EnumDisponibilidade.DISPONIVEL))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
