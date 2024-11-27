package Biblioteca;

public class Logger {
    public void imprimir(Titulo titulo){
        System.out.println("Nome : " + titulo.getNome()+"\n");
        System.out.println("Autor: " + titulo.buscarAutor()+"\n");
        System.out.println("Generos: ");
        for(int i=0; i<titulo.tamanhoGeneros();i++){
            if(i==titulo.tamanhoGeneros()+1){
                System.out.println(titulo.pegarGenero(i)+";\n ");
            }else{
                System.out.println(titulo.pegarGenero(i)+", ");
            }
        }
        System.out.println("ISBN: " + titulo.pegarISBN());
        System.out.println("Cópias disponíveis: "+ titulo.getDisponivel()+"\n");
        System.out.println("Cópias reservadas: " + titulo.getEmprestimo()+"\n");
        int totais =titulo.getDisponivel()+titulo.getEmprestimo();
        System.out.println("Cópias totais: "+ totais +"\n" );
    }
}
