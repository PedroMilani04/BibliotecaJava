
package Biblioteca;

/**
 *
 * @author arthu
 */

import java.util.ArrayList;
public class Titulo {
    private ArrayList<Livro> copias;
    
    Titulo(Livro novoLivro)
    {
        copias = new ArrayList<Livro>();
        copias.add(novoLivro);
    }
    
    public ArrayList<Livro> getCopias()
    {
        return this.copias;
    }
    
    public Livro getExemplar()
    {
        return this.copias.get(0);
    }
    
    public void adicionarCopia(Livro novaCopia)
    {
        this.copias.add(novaCopia);
    }
    
    public void removerCopia(Livro novaCopia)
    {
        for(int i = 0; i < copias.size(); i++)
        {
            if(copias.get(i).getIsbn().equals(novaCopia.getIsbn()))
            {
                copias.remove(i);
            }
        }
    }
}
