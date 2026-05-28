package program;

import exception.BookNotFoundException;
import exception.InvalidEnterException;
import exception.LoanLimitException;
import model.Book;
import model.Librarian;
import model.User;
import service.BookService;
import service.LibrarianService;
import service.UserService;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private final BookService bookService = new BookService();

    private final LibrarianService librarianService = new LibrarianService();

    private final UserService userService = new UserService();

    public void iniciar() {

        while (true) {

            try {

                exibirMenuPrincipal();

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        menuCriar();
                        break;

                    case 2:
                        menuExcluir();
                        break;

                    case 3:
                        menuEmprestar();
                        break;

                    case 4:
                        menuDevolver();
                        break;

                    case 5:
                        System.out.println("Sistema encerrado.");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Digite apenas números.");

            } catch (BookNotFoundException |
                     LoanLimitException |
                     InvalidEnterException e) {

                System.out.println(e.getMessage());
            }
        }
    }

    private void exibirMenuPrincipal() {

        System.out.println("\n========== SISTEMA ==========");

        System.out.println("""
                1 - Criar
                2 - Excluir
                3 - Emprestar Livro
                4 - Devolver Livro
                5 - Sair
                """);
    }

    public void menuCriar() {

        System.out.println("\n===== MENU CRIAR =====");

        System.out.println("""
                1 - User
                2 - Librarian
                3 - Book
                """);

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao){

            case 1:
                criarUser();
                break;

            case 2:
                criarLibrarian();
                break;

            case 3:
                criarBook();
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public void criarUser(){

        System.out.println("Nome do User:");
        String nome = sc.nextLine();

        System.out.println("Idade:");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("ID:");
        int id = Integer.parseInt(sc.nextLine());

        userService.cadastrarUser(nome, idade, id, 0);

        System.out.println("User criado com sucesso.");
    }

    public void criarLibrarian(){

        System.out.println("Nome do Librarian:");
        String nome = sc.nextLine();

        System.out.println("Idade:");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("ID:");
        int id = Integer.parseInt(sc.nextLine());

        librarianService.cadastrarBibliotecaria(
                new Librarian(nome, idade, id)
        );

        System.out.println("Librarian criado com sucesso.");
    }

    public void criarBook(){

        System.out.println("Nome do livro:");
        String nome = sc.nextLine();

        System.out.println("ID do livro:");
        int id = Integer.parseInt(sc.nextLine());

        bookService.createBook(new Book(id, nome));

        System.out.println("Livro criado com sucesso.");
    }

    public void menuExcluir() {

        System.out.println("\n===== MENU EXCLUIR =====");

        System.out.println("""
                1 - User
                2 - Librarian
                3 - Book
                """);

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao){

            case 1:

                System.out.println("Nome do User:");
                String nomeUser = sc.nextLine();

                userService.excluirUser(nomeUser);

                System.out.println("User removido.");
                break;

            case 2:

                System.out.println("Nome do Librarian:");
                String nomeLibrarian = sc.nextLine();

                librarianService.excluirBibliotecaria(nomeLibrarian);

                System.out.println("Librarian removido.");
                break;

            case 3:

                System.out.println("Nome do Book:");
                String nomeBook = sc.nextLine();

                bookService.removeBook(nomeBook);

                System.out.println("Book removido.");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public void menuEmprestar() {

        System.out.println("\n===== MENU EMPRESTAR =====");

        System.out.println("Nome do livro:");
        String nomeLivro = sc.nextLine();

        System.out.println("Nome do usuário:");
        String nomeUser = sc.nextLine();

        User user = userService.verificarUser(nomeUser);

        librarianService.emprestarLivro(nomeLivro, user);

        System.out.println("Livro emprestado com sucesso.");
    }

    public void menuDevolver() {

        System.out.println("\n===== MENU DEVOLVER =====");

        System.out.println("Nome do livro:");
        String nomeLivro = sc.nextLine();

        userService.devolverLivro(nomeLivro);

        System.out.println("Livro devolvido.");
    }
}