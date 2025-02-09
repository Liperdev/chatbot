import java.util.Scanner;
import java.util.ArrayList;

public class chatbot {
    public static void menu() {
        System.out.println("1 - Setor de Registro");
        System.out.println("2 - Setor de Suporte Técnico");
        System.out.println("3 - Setor de Dúvidas Gerais");
        System.out.println("4 - Setor de Compras");
        System.out.println("5 - Setor de Reclamações");
        System.out.println("6 - Finalizar");
    }

    public static boolean registros(ArrayList<String> clientes, String cliente) {
        return clientes.stream().anyMatch(c -> c.equalsIgnoreCase(cliente));
    }

    public static void menuSuporte() {
        System.out.println("1 - Acesso à plataforma");
        System.out.println("2 - Solicitação de visita");
        System.out.println("3 - Encerrar");
    }

    public static void agradecimento() {
        System.out.println("Agradecemos por usar nosso chatbot!");
    }

    public static boolean compras(ArrayList<String> compras, String item) {
        return compras.stream().anyMatch(c -> c.equalsIgnoreCase(item));
    }

    public static void reclamacao(ArrayList<String> feedback, String comentario) {
        System.out.println("Sua reclamação: " + feedback);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<String> compras = new ArrayList<>();
        ArrayList<String> feedback = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcaoCliente, opcaoSuporte;
        String consultaCliente, opcaoAdicionar, adicaoCliente, adicaoMaisCliente, encerrarRegistro, duvidaPlataforma, dataVisita;
        String duvidaCliente, consultaCompra, produtoAdicionar, exibirProduto;
        String produto = "";
        String reclamacao = "";
        String maisReclamacao = "";
        String exibirReclamacao;

        clientes.add("Manuel");
        clientes.add("Junior");
        clientes.add("Marcos");
        clientes.add("Rafaela");
        clientes.add("Mateus");

        compras.add("Mouse");
        compras.add("Teclado");

        while (true) {
            menu();
            System.out.print("Digite sua opção: ");
            opcaoCliente = entrada.nextInt();

            while (opcaoCliente < 1 || opcaoCliente > 6) {
                System.out.print("Digite uma opção válida: ");
                opcaoCliente = entrada.nextInt();
            }

            switch (opcaoCliente) {
                case 1:
                    System.out.println("Você escolheu => Setor de Consultar Registro");
                    System.out.print("Consulte o nome do cliente: ");
                    consultaCliente = entrada.next();

                    if (registros(clientes, consultaCliente)) {
                        System.out.println("Cliente encontrado: " + consultaCliente);
                    } else {
                        System.out.println("Cliente não encontrado.");
                        System.out.println("[Sim ou Não] Gostaria de adicioná-lo? ");
                        opcaoAdicionar = entrada.next();

                        if (opcaoAdicionar.equalsIgnoreCase("sim")) {
                            do {
                                System.out.print("Adicionar cliente: ");
                                adicaoCliente = entrada.next();
                                clientes.add(adicaoCliente);
                                System.out.println("Cliente adicionado!");

                                System.out.print("Gostaria de adicionar mais clientes? [Sim ou Não]: ");
                                adicaoMaisCliente = entrada.next();
                            } while (adicaoMaisCliente.equalsIgnoreCase("sim"));

                            System.out.println("Lista de clientes: " + clientes);
                            System.out.print("Encerrar o registro? [Sim ou Não]: ");
                            encerrarRegistro = entrada.next();

                            if (encerrarRegistro.equalsIgnoreCase("sim")) {
                                System.out.println("Encerrando...");
                                return;
                            }
                        } else {
                            System.out.println("Retornando ao menu principal...");
                            return;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Você escolheu => Setor de Suporte Técnico");
                    menuSuporte();
                    System.out.print("Opção: ");
                    opcaoSuporte = entrada.nextInt();

                    while (opcaoSuporte < 1 || opcaoSuporte > 3) {
                        System.out.println("Opção inexistente!");
                        System.out.print("Opção: ");
                        opcaoSuporte = entrada.nextInt();
                    }

                    switch (opcaoSuporte) {
                        case 1:
                            System.out.println("Dúvida ao entrar na plataforma!");
                            System.out.print("Digite sua dúvida: ");
                            duvidaPlataforma = entrada.next();

                            agradecimento();
                            break;

                        case 2:
                            System.out.println("Solicitação de visita!");
                            System.out.print("(ex: 01/01/2025) Digite a data: ");
                            dataVisita = entrada.next();
                            System.out.print("Data desejada: " + dataVisita);
                            System.out.println("Data confirmada!");

                            agradecimento();
                            break;

                        case 3:
                            System.out.println("Retornando ao menu...");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Você escolheu => Setor de Dúvidas Gerais");
                    System.out.print("Digite sua dúvida: ");
                    duvidaCliente = entrada.nextLine();

                    while (duvidaCliente.equals("")) {
                        System.out.println("Campo vazio, digite algo!");
                        System.out.print("Digite sua dúvida: ");
                        duvidaCliente = entrada.nextLine();
                    }

                    System.out.println("Dúvida registrada!");
                    agradecimento();

                    break;

                case 4:
                    System.out.println("Você escolheu => Setor de Compras");
                    System.out.print("Consulte sua compra: ");
                    consultaCompra = entrada.next();

                    if (compras(compras, consultaCompra)) {
                        System.out.println("Compra encontrada: " + consultaCompra);
                        System.out.println("Chegará em poucos dias! ");
                        System.out.println("Aguarde o recebimento em breve da sua compra em breve! ");
                        System.out.println("Finalizando...");
                    } else {
                        System.out.println("Compra não encontrada!");
                        System.out.println("[Sim ou Não] Você gostaria de adicionar uma compra? ");
                        produtoAdicionar = entrada.next();

                        while (produtoAdicionar.equalsIgnoreCase("sim")) {
                            System.out.print("Produto: ");
                            produto = entrada.next();
                            compras.add(produto);

                            System.out.println("[Sim ou Não] Você gostaria de adicionar uma compra? ");
                            produtoAdicionar = entrada.next();
                        }

                        System.out.println("Deseja exibir a lista de compras? ");
                        exibirProduto = entrada.next();

                        if (exibirProduto.equalsIgnoreCase("sim")) {
                            System.out.println(compras);
                        } else {
                            agradecimento();
                            System.out.println("Encerrando...");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Você escolheu => Setor de Reclamações");
                    System.out.println("Deixe sua reclamação aqui!");
                    System.out.print("Reclamação: ");
                    reclamacao = entrada.nextLine().trim();
                    feedback.add(reclamacao);

                    System.out.print("[Sim ou Não] Gostaria de enviar outra reclamação? ");
                    maisReclamacao = entrada.nextLine().trim();

                    while (maisReclamacao.equalsIgnoreCase("sim")) {

                        System.out.print("Reclamação: ");
                        reclamacao = entrada.nextLine().trim();
                        feedback.add(reclamacao);
                        System.out.println("[Sim ou Não] Gostaria de enviar outra reclamação? ");
                        maisReclamacao = entrada.nextLine().trim();

                    }
                    System.out.println("Sua lista de reclamações: ");
                    System.out.println(feedback);
                    break;

                case 6:
                    System.out.println("Finalizando...");
                    return;

                default:
                    System.out.println("Opção não implementada");
            }
        }
    }
}
