package com.mycompany.bibliotecafinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecafinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EnumGeneros> generos = new ArrayList();
        Catalogo catalogo = Catalogo.getInstancia();
        GerenciarEmprestimo gerenciarEmprestimo = GerenciarEmprestimo.getInstancia();

        System.out.println("============================================================");
        System.out.println(" ###   ###   ###   #     ###    ##   ###   ####   ##    ##  ");
        System.out.println(" #  #   #    #  #  #      #    #  #   #    #     #  #  #  # ");
        System.out.println(" ###    #    ###   #      #    #  #   #    ###   #     #  # ");
        System.out.println(" #  #   #    #  #  #      #    #  #   #    #     #     #### ");
        System.out.println(" #  #   #    #  #  #      #    #  #   #    #     #  #  #  # ");
        System.out.println(" ###   ###   ###   ####  ###    ##    #    ####   ##   #  # ");
        System.out.println("============================================================");
        
        int opcao;
        do{
            System.out.println("\n==================================");
            System.out.println("#     BIBLIOTECA DE ALEXANDRIA     #");
            System.out.println("# [1] CADASTRAR USUARIO            #");
            System.out.println("# [2] ADICIONAR LIVRO AO CATALOGO  #");
            System.out.println("# [3] REALIZAR EMPRESTIMO          #");
            System.out.println("# [4] RESERVAR LIVRO               #");
            System.out.println("# [5] DEVOLVER LIVRO               #");
            System.out.println("# [6] CONSULTAR LIVROS NO CATALOGO #");
            System.out.println("# [7] CONSULTAR MULTAS DO USUARIO  #");
            System.out.println("# [8] QUITAR MULTA                 #");
            System.out.println("# [9] SOBRE O PROJETO              #");
            System.out.println("# [0] SAIR                         #");
            System.out.print("# ESCOLHA UMA OPCAO PARA PROSSEGUIR: #");
            System.out.println("====================================");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastrar Usuario =====");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereco: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Nickname: ");
                    String nickname = scanner.nextLine();
                    UsuarioBiblioteca usuario = new UsuarioBiblioteca(nome, email, cpf, endereco, nickname);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("===== Adicionar Livro =====");
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Tombo: ");
                    int tombo = scanner.nextInt();
                    System.out.println("Genero (1-TECNOLOGIA, 2-FICCAO): ");
                    int generoOpcao = scanner.nextInt();
                    EnumGeneros genero = (generoOpcao == 1) ? EnumGeneros.COMEDIA : EnumGeneros.FANTASIA;
                    Livro livro = new Livro(titulo, autor, isbn, tombo, generos);
                    catalogo.inserirLivros(titulo, autor, isbn);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 3:
                    System.out.println("===== Realizar Emprestimo =====");
                    System.out.print("ID do Usuario: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titulo do Livro: ");
                    titulo = scanner.nextLine();
                    usuario = BancoUsuarios.buscarUsuarioPorID(idUsuario);
                    livro = livro.getTitulo(titulo);
                    if (usuario != null && livro != null) {
                        usuario.novoEmprestimo(livro);
                    } else {
                        System.out.println("Usuario ou livro nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("===== Reservar Livro =====");
                    System.out.print("ID do Usuario: ");
                    idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titulo do Livro: ");
                    titulo = scanner.nextLine();
                    usuario = BancoUsuarios.buscarUsuarioPorID(idUsuario);
                    livro = livro;
                    if (usuario != null && livro != null) {
                        usuario.novaReserva(livro);
                    } else {
                        System.out.println("Usuario ou livro nao encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("===== Devolver Livro =====");
                    System.out.print("ID do Usuario: ");
                    idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titulo do Livro: ");
                    titulo = scanner.nextLine();
                    usuario = BancoUsuarios.buscarUsuarioPorID(idUsuario);
                    if (usuario != null) {
                        usuario.devolverLivro(titulo);
                    } else {
                        System.out.println("Usuario nao encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("===== Livros no Catalogo =====");
                    for (Livro livro : catalogo.getLivros()) {
                        System.out.println("- " + livro.getTitulo() + " (" + livro.getDisponibilidade() + ")");
                    }
                    break;
                case 7:
                    System.out.println("===== Multas do Usuario =====");
                    System.out.print("ID do Usuario: ");
                    idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    usuario = BancoUsuarios.buscarUsuarioPorID(idUsuario);
                    if (usuario != null) {
                        for (Multa multa : usuario.getMultas()) {
                            System.out.println("- Multa " + multa.getCodMulta() + ": R$" + multa.getValor() + (multa.getisPaga() ? " (Paga)" : " (Não Paga)"));
                        }
                    } else {
                        System.out.println("Usuario não encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("===== Quitar Multa =====");
                    System.out.print("ID do Usuario: ");
                    idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Codigo da Multa: ");
                    String codMulta = scanner.nextLine();
                    usuario = BancoUsuarios.buscarUsuarioPorID(idUsuario);
                    if (usuario != null) {
                        for (Multa multa : usuario.getMultas()) {
                            if (multa.getCodMulta().equals(codMulta)) {
                                multa.quitarMulta();
                                break;
                            }
                        }
                    } else {
                        System.out.println("Usuario ou multa nao encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("========================================================");
                    System.out.println("#             PROJETO DA DISCIPLINA POOII              #");
                    System.out.println("#              Prof. Dr. Danillo Roberto               #");
                    System.out.println("#                                                      #");
                    System.out.println("#                 MEMBROS DO PROJETO:                  #");
                    System.out.println("#  -Arthur Koichi                                      #");
                    System.out.println("#  -Cristian Eidi                                      #");
                    System.out.println("#  -Gustavo Ribeiro                                    #");
                    System.out.println("#  -Henrique Finco                                     #");
                    System.out.println("#  -Julia Sanches                                      #");
                    System.out.println("#  -Nicolas dos Santos                                 #");
                    System.out.println("#  -Pedro Henrique                                     #");
                    System.out.println("#                                                      #");
                    System.out.println("# 'Ser zica e facil, zica mesmo e ser zica do pantano' #");
                    System.out.println("========================================================");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao !=0);

        scanner.close();
    }
}
