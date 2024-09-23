package leilao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leilao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        ConteudoLeilao conteudoLeilao = null;
        boolean continuar = true;
            //Se continuar == true, irá seguir o fluxo padrão
        while (continuar) {
            //Conteúdo de menu
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Usuários");
            System.out.println("2. Criar ou Alterar Leilão");
            System.out.println("3. Iniciar Leilão com Usuários Cadastrados");
            System.out.println("4. Limpar Usuários e Leilão e Recomeçar do Zero");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastro de usuários
                    System.out.print("Quantos usuários deseja cadastrar? ");
                    int quantidadeUsuarios = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 1; i <= quantidadeUsuarios; i++) {
                        System.out.println("\n=== Cadastro de Usuário " + i + " ===");
                        int idUsuario = i;
                    
                        System.out.print("Digite o nome do usuário: ");
                        if (i == 1) {
                            scanner.nextLine();
                        }
                        String nomeUsuario = scanner.nextLine();
                    
                        boolean ativo = false;
                        boolean entradaValida = false;
                        while (!entradaValida) {
                            System.out.print("O usuário está ativo? (true/false): ");
                            if (scanner.hasNextBoolean()) {
                                ativo = scanner.nextBoolean();
                                entradaValida = true;
                            } else {
                                System.out.println("Entrada inválida! Digite 'true' ou 'false'.");
                                scanner.next();
                            }
                        }
                    
                        usuarios.add(new Usuario(idUsuario, nomeUsuario, ativo));
                        System.out.println("Usuário " + nomeUsuario + " cadastrado com ID " + idUsuario);
                    
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("\nDigite o valor inicial do leilão: ");
                    double lanceInicial = scanner.nextDouble();
                    conteudoLeilao = new ConteudoLeilao(lanceInicial);
                    System.out.println("Leilão criado com sucesso!");
                    break;

                    case 3:
                    if (conteudoLeilao == null || usuarios.isEmpty()) {
                        System.out.println("Você precisa cadastrar um leilão e usuários antes de iniciar o leilão.");
                    } else {
                        // Simulação de leilão
                        System.out.print("\nQuantos lances deseja realizar? ");
                        int quantidadeLances = scanner.nextInt();
                
                        for (int i = 0; i < quantidadeLances; i++) {
                            System.out.println("\n=== Lance " + (i + 1) + " ===");
                            System.out.print("Escolha o ID do usuário que fará o lance: ");
                            int idUsuarioEscolhido = scanner.nextInt();
                            Usuario usuarioEscolhido = usuarios.get(idUsuarioEscolhido - 1);
                
                            System.out.print("Digite o valor do lance: ");
                            double valorLance = scanner.nextDouble();
                            conteudoLeilao.adicionarLance(valorLance, usuarioEscolhido.getNome());
                        }
                
                        conteudoLeilao.setVencedor(conteudoLeilao.getVencedor());
                
                        conteudoLeilao.exibirHistoricoLances();
                        conteudoLeilao.exibirInformacoesLeilao();
                    }
                    break;

                case 4:
                    // Limpar usuários e conteúdo do leilão
                    usuarios.clear();
                    conteudoLeilao = null;
                    System.out.println("Todos os usuários e leilões foram limpos. Você pode recomeçar do zero.");
                    break;

                case 5:
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            if (continuar) {
                System.out.println("\nDeseja continuar? (true/false)");
                continuar = scanner.nextBoolean();
            }
        }

        scanner.close();
    }
}