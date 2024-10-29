package Biblioteca;
import java.util.Scanner;
import java.util.Hashtable;
import Biblioteca.Usuario;

public class Cadastro {
    protected String email;
    protected String senha;
    protected String confirmacao;
    protected Hashtable<Cadastro, Usuario> ht_cad_for_usu = new Hashtable<Cadastro, Usuario>(); //Criando uma hashtable para armazenar os cadastros e os usuarios (acha o usu usando o cadas)
    protected Hashtable<String, Cadastro> ht_email_for_cad = new Hashtable<String, Cadastro>(); //Criando uma hashtable para armazenar os emails e os cadastros (acha o cadas usando o email)
    protected Hashtable<String, Cadastro> ht_nickname_for_cad = new Hashtable<String, Cadastro>(); //Criando uma hashtable para armazenar os nicknames e os cadastros (acha o cadas usando o nickname)

    //Procurar como fazer uma hashtable pra por nicknames dos emails (maior nota de criatividade, ou entra com o email ou entra com o nickname

    //criar um método que iria mostrar o que no hashtable porém ele será privado, só pra uso interno

    public Cadastro(String email, String senha, String confirmacao){
        this.email = email;
        if(senha.length() >= 8 && senha.equals(confirmacao)){ //Verifica se a senha tem 8 ou mais caracteres e se a senha e a confirmação são iguais
            this.senha = senha;
        }else{
            throw new IllegalArgumentException("Senhas não conferem"); //Bloqueia a criação do objeto por senha e confirmação diferentes
        }
    }

    public String getEmail(){
        return email;
    }

    public void criarConta(){
        String nome;
        String CPF;
        String nickname;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        email = input.nextLine();
        System.out.println("Digite sua senha: ");
        senha = input.nextLine();
        System.out.println("Confirme sua senha: ");
        confirmacao = input.nextLine();
        System.out.println("Digite seu nome: ");
        nome = input.nextLine();
        System.out.println("Digite seu CPF: ");
        CPF = input.nextLine();
        System.out.println("Digite um nickname: "); //procurar no banco de dados se já existe criar dps[...]
        nickname = input.nextLine();
        Cadastro cadastro = new Cadastro(email, senha, confirmacao);
        Usuario usuario = new Usuario(nome, email, CPF, nickname);

        //tecnicamente... é pra funcionar, vamos ver.

        //Se isso funcionar eu sou um gênio
        ht_cad_for_usu.put(cadastro, usuario);
        ht_email_for_cad.put(email, cadastro);
        ht_nickname_for_cad.put(nickname, cadastro);


        System.out.println("Conta criada com sucesso " +nome + "!");
    }

    public Usuario returnUsuarioEmail(String email){
        if(ht_email_for_cad.containsKey(email)){
            Usuario retorna = ht_cad_for_usu.get(ht_email_for_cad.get(email));
            return retorna;
        }else{
            System.out.println("Usuário não encontrado");
            return null;
        }
    }

    public Usuario returnUsuarioNickname(String nickname){
        if(ht_nickname_for_cad.containsKey(nickname)){
            Usuario retorna = ht_cad_for_usu.get(ht_nickname_for_cad.get(nickname));
            return retorna;
        }else{
            System.out.println("Usuário não encontrado");
            return null;
        }
    }

    
    
}
