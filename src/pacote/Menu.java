package pacote;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pojo.Carrinho;
import pojo.Hortalicas;

public class Menu {

    public static ArrayList<String> prod = new ArrayList();
    public static Carrinho carrinho = Carrinho.getInstance();
    public static Scanner scanner = new Scanner(System.in);
    public static int i;

    public Menu() {

        List<Hortalicas> hortalicas = new ArrayList<>();

        String nome;
        int quant;

        int opcaoMenu2 = 0;

        do {
            System.out.println("MENU:");
            System.out.println("1 - CADASTRAR HORTALICAS");
            System.out.println("2 - HORTALIÇAS CADASTRADAS");
            System.out.println("3 - ADICIONAR AO CARRINHO");
            System.out.println("4 - VER CARRINHO");
            System.out.println("0 - SAIR");

            opcaoMenu2 = scanner.nextInt();

            switch (opcaoMenu2) {
                case 1:
                    limpar();
                    scanner.reset();
                    int resposta = 1;
                    while (resposta == 1) {
                        System.out.println("Digite o nome:");
                        nome = scanner.next();

                        System.out.println("Digite a quantidade:");
                        quant = scanner.nextInt();

                        hortalicas.add(new Hortalicas(nome, quant));

                        System.out.println("Deseja cadastrar outra Hortaliça?");
                        System.out.println("1 = SIM / 2 = NÃO");
                        resposta = scanner.nextInt();
                        limpar();
                    }
                    break;

                case 2:
                    limpar();
                    int resposta2 = 2;
                    do {
                        listarHortalicas(hortalicas);
                        System.out.println("SAIR:");
                        System.out.println("1 = SIM / 2 = NÃO");
                        resposta2 = scanner.nextInt();
                        limpar();
                    } while (resposta2 == 2);
                    break;
                case 3:
                    limpar();
                    int resposta1 = 1;
                    int posicao;
                    do {
                        listarHortalicas(hortalicas);
                        System.out.println("SELECIONE OS PRODUTOS PELO ID:");
                        posicao = scanner.nextInt();
                        pegarHortalicas(posicao, hortalicas);

                        System.out.println("DESEJA ADICIONAR OUTRO PRODUTO?");
                        System.out.println("1 = SIM / 2 = NÃO");
                        resposta1 = scanner.nextInt();
                        limpar();
                    } while (resposta1 == 1);

                    carrinho.setProduto(prod);

                    break;
                case 4:
                    listarCarrinho();
                    break;
                default:
                    System.out.println("Digite apenas os números informados");
                    break;
            }
        } while (opcaoMenu2 != 0);
    }

    public static void listarCarrinho() {
        System.out.printf("Itens do Carrinho\n");
        int n = carrinho.getProduto().size();
        for (i = 0; i < n; i++) {
            System.out.printf("Produo: %s\n", carrinho.getProduto().get(i));
        }
    }

    public static void listarHortalicas(List<Hortalicas> hortalicas) {
        System.out.println("Lista das Hortaliças:");
        for (int i = 0; i < hortalicas.size(); i++) {
            System.out.println("ID:" + i + " - " + hortalicas.get(i).getNome() + " - Quantidade:" + hortalicas.get(i).getQuantidade());
        }
    }

    public static void pegarHortalicas(int i, List<Hortalicas> hortalicas) {
        if (hortalicas.get(i).getQuantidade() == 0) {
            System.out.println("Produto Indisponivel");
        } else {
            int quant = hortalicas.get(i).getQuantidade();
            quant = quant - 1;
            hortalicas.get(i).setQuantidade(quant);
            prod.add(hortalicas.get(i).getNome());
        }
    }

    public final static void limpar() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }
}