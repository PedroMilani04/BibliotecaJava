package POOII.BibliotecaJava;

public class Principal {
    public static void main(String[] args) {
 
        
        UsuarioBiblioteca u = new UsuarioBiblioteca("João", "12345678910", "lais@unesp.br");
        UsuarioBiblioteca u1 = new UsuarioBiblioteca("Lais", "12345678910", "lais@unesp.br");
        Usuario u2 = new Usuario("Nic", "lais@unesp.br", "12345678910");
        System.out.println("Id: " + u.getID() + " Nome: " + u.getNome());
        System.out.println("Id: " + u1.getID() + " Nome: " + u1.getNome());
        System.out.println("Id: " + u2.getID() + " Nome: " + u2.getNome());
    }
}