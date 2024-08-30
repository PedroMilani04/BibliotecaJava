package POOII.BibliotecaJava;

public class Principal {
    public static void main(String[] args) {
 
        
        UsuarioBiblioteca u = new UsuarioBiblioteca("João", "teste@huas.com", "12312312313"); //Não é interessante criar todos objetos direto, caso 1 de erro
        UsuarioBiblioteca u1 = new UsuarioBiblioteca("Lais", "teste@gemail.com", "12312312313");//Nenhum outro que irá se criado vai ser salvo, o programa para
        Usuario u2 = new Usuario("Nic", "lais@unesp.br", "12312312312");//(Justificativa: Comando para dar argumento ilegal)
        System.out.println("Id: " + u.getID() + " Nome: " + u.getNome());
        System.out.println("Id: " + u1.getID() + " Nome: " + u1.getNome());
        System.out.println("Id: " + u2.getID() + " Nome: " + u2.getNome());
    }
}