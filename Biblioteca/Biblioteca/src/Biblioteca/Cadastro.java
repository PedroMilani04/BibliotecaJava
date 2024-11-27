package Biblioteca;
import java.util.Scanner;
import java.util.Hashtable;


public class Cadastro {
    protected String email;
    protected String senha;
    protected String confirmacao;
    protected int lvl; //lvl do usuario, 1  = usuario biblioteca, 2 = usuario bibliotecario
    private static Hashtable<Cadastro, Usuario> ht_cad_for_usu = new Hashtable<Cadastro, Usuario>(); //Criando uma hashtable para armazenar os cadastros e os usuarios (acha o usu usando o cadas)
    private static Hashtable<String, Cadastro> ht_email_for_cad = new Hashtable<String, Cadastro>(); //Criando uma hashtable para armazenar os emails e os cadastros (acha o cadas usando o email)
    private static Hashtable<String, Cadastro> ht_nickname_for_cad = new Hashtable<String, Cadastro>(); //Criando uma hashtable para armazenar os nicknames e os cadastros (acha o cadas usando o nickname)
    //Procurar como fazer uma hashtable pra por nicknames dos emails (maior nota de criatividade, ou entra com o email ou entra com o nickname //////////FEITO!!!!

    //criptografar talvez? (não é necessário, mas é uma boa prática)

    //Criar verificação de CPF tanto aqui como na classe usuario, talvez fazer com que n bata já na função a senha incompativel com a confirmação e menos de 8 (FEITO!!)
    //Adicionar isso dps (boa gpt lindo perfeito!!!!) 9FEITO !!

    //00:04 e ninguém imagina como tá a mente do palhaço

    //criar um método que iria mostrar o que no hashtable porém ele será privado, só pra uso interno

    //Criação do Dono para fazer outros bibliotecarios


    // Bloco de inicialização estático
    static {
        Cadastro adminMaster = new Cadastro("adm@adm.com", "adminbiblioteca", "adminbiblioteca");
        Bibliotecario dono = new Bibliotecario("ADM", "adm@adm.com", "1111111111", "...", "ADM", Integer.MAX_VALUE);
        ht_cad_for_usu.put(adminMaster, dono);
        ht_email_for_cad.put("adm@adm.com", adminMaster);
        ht_nickname_for_cad.put("ADMIN", adminMaster);
    }

    public Cadastro(String email, String senha, String confirmacao){
        this.email = email;
        if(senha.length() >= 8 && senha.equals(confirmacao)){ //Verifica se a senha tem 8 ou mais caracteres e se a senha e a confirmação são iguais
            this.senha = senha;
        }else{
            throw new IllegalArgumentException("Senhas não conferem"); //Bloqueia a criação do objeto por senha e confirmação diferentes
        }
    }

    public Cadastro(){
        //Construtor vazio 
    }

    public String getSenha(){
        return senha;
    }

    public String getEmail(){
        return email;
    }

    public void criarConta(){ //Criação de conta e verificação de dados para não bater em outro na hora de criar
        String nome;
        String CPF;
        String nickname;
        String endereco;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        email = input.nextLine();

        while(ht_email_for_cad.containsKey(email)){
            System.out.println("Email já cadastrado. Por favor, escolha outro.");
            email = input.nextLine();
        }

        System.out.println("Digite seu nome: ");
        nome = input.nextLine();

        System.out.println("Digite seu CPF: ");
        CPF = input.nextLine();

        while(CPF.length() != 11){
            System.out.println("CPF inválido, tente novamente");
            CPF = input.nextLine();
        }

        System.out.println("Digite seu endereço: ");
        endereco = input.nextLine();

        System.out.println("Digite sua senha: ");
        senha = input.nextLine();

        while(senha.length() <= 8){
            System.out.println("Senha muito curta, tente novamente");
            senha = input.nextLine();
        }

        System.out.println("Confirme sua senha: ");
        confirmacao = input.nextLine();

        while(!senha.equals(confirmacao)){
            System.out.println("Senhas não conferem, tente novamente");
            System.out.println("Digite sua senha: ");
            senha = input.nextLine();
            System.out.println("Confirme sua senha: ");
            confirmacao = input.nextLine();
        }

        System.out.println("Digite um nickname: "); //procurar no banco de dados se já existe criar dps[...] (FEITO)
        nickname = input.nextLine();

        while(ht_nickname_for_cad.containsKey(nickname)) {
            System.out.println("Nickname já cadastrado. Por favor, escolha outro.");
            nickname = input.nextLine();
        }

        Cadastro cadastro = new Cadastro(email, senha, confirmacao);

        UsuarioBiblioteca usuarioBi = new UsuarioBiblioteca(nome, email, CPF, endereco, nickname);
        ht_cad_for_usu.put(cadastro, usuarioBi);
        
        //tecnicamente... é pra funcionar, vamos ver.

        //Se isso funcionar eu sou um gênio
        ht_email_for_cad.put(email, cadastro);
        ht_nickname_for_cad.put(nickname, cadastro);


        System.out.println("Conta criada com sucesso " +nome + "!");
    }

    public void CriarADM(Bibliotecario bi){
        String nome;
        String CPF;
        String nickname;
        String endereco;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        email = input.nextLine();

        while(ht_email_for_cad.containsKey(email)){
            System.out.println("Email já cadastrado. Por favor, escolha outro.");
            email = input.nextLine();
        }

        System.out.println("Digite seu nome: ");
        nome = input.nextLine();

        System.out.println("Digite seu CPF: ");
        CPF = input.nextLine();

        while(CPF.length() != 11){
            System.out.println("CPF inválido, tente novamente");
            CPF = input.nextLine();
        }

        System.out.println("Digite seu endereço: ");
        endereco = input.nextLine();

        System.out.println("Digite sua senha: ");
        senha = input.nextLine();

        while(senha.length() <= 8){
            System.out.println("Senha muito curta, tente novamente");
            senha = input.nextLine();
        }

        System.out.println("Confirme sua senha: ");
        confirmacao = input.nextLine();

        while(!senha.equals(confirmacao)){
            System.out.println("Senhas não conferem, tente novamente");
            System.out.println("Digite sua senha: ");
            senha = input.nextLine();
            System.out.println("Confirme sua senha: ");
            confirmacao = input.nextLine();
        }

        System.out.println("Digite um nickname: "); //procurar no banco de dados se já existe criar dps[...] (FEITO)
        nickname = input.nextLine();

        while(ht_nickname_for_cad.containsKey(nickname)) {
            System.out.println("Nickname já cadastrado. Por favor, escolha outro.");
            nickname = input.nextLine();
        }

        Cadastro cadastro = new Cadastro(email, senha, confirmacao);

        Bibliotecario bibliotecario = new Bibliotecario(nome, email, CPF, endereco, nickname);
        ht_cad_for_usu.put(cadastro, bibliotecario);
        
        //tecnicamente... é pra funcionar, vamos ver.

        //Se isso funcionar eu sou um gênio
        ht_email_for_cad.put(email, cadastro);
        ht_nickname_for_cad.put(nickname, cadastro);
    }
    

    public static boolean verificarEmailESenha(String email, String senha) {
        if (ht_email_for_cad.containsKey(email)) {
            Cadastro cadastro = ht_email_for_cad.get(email);
            return cadastro.getSenha().equals(senha);
        }
        return false;
    }

    public static Usuario returnUsuarioEmail(String email) {
        Cadastro cad = ht_email_for_cad.get(email);
        return ht_cad_for_usu.get(cad);
    }

    public static boolean verificarNicknameESenha(String nickname, String senha) {
        if (ht_nickname_for_cad.containsKey(nickname)) {
            Cadastro cadastro = ht_nickname_for_cad.get(nickname);
            return cadastro.getSenha().equals(senha);
        }
        return false;
    }

    public static Usuario returnUsuarioNickname(String nickname) {
        Cadastro cad = ht_nickname_for_cad.get(nickname);
        return ht_cad_for_usu.get(cad);
    }
}