import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String nome = "Jacqueline Oliveira";
        double saldoInicial = 2500.00;
        String tipoConta = "Conrrente";
        double saldoAtualizado = saldoInicial;


        System.out.println("****************************************");
        System.out.println("Dados iniciais do cliente:\n\n");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo inicial: R$ " + saldoInicial);
        System.out.println("****************************************\n\n");

        Scanner sc = new Scanner(System.in);

        String menu = """
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                """;

        int opcao = 0;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Saldo: R$ " + saldoAtualizado + "\n");
            } else if (opcao == 2) {
                double valorRecebido;
                System.out.println("Informe o valor a receber: ");
                valorRecebido = sc.nextDouble();

                if (valorRecebido < 0) {
                    System.out.println("Valor invalido!\n");
                } else {
                    saldoAtualizado = recebeTransferencia(valorRecebido, saldoInicial);
                }
            } else if (opcao == 3) {
                System.out.println("Informe o valor a transferir: ");
                double valorTransferido = sc.nextDouble();

                if (valorTransferido < 0) {
                    System.out.println("Valor invalido, não pode enviar valores negativos!\n");
                } else if (saldoAtualizado < 0 || valorTransferido > saldoAtualizado) {
                    System.out.println("Saldo insuficiente para realizar a transferencia\n");
                } else {
                    saldoAtualizado = fazTransferencia(saldoAtualizado, valorTransferido);
                    System.out.println("O valor de R$ " + valorTransferido + " foi transferido com sucesso!\n");
                }
            } else if (opcao == 4) {
                System.out.println("Finalizando o programa...");
            } else {
                System.out.println("Opção inválida\n");
            }
        }
        sc.close();
    }

    static double recebeTransferencia(double valorRecebido, double saldoInicial) {
        return saldoInicial + valorRecebido;
    }

    static double fazTransferencia(double saldoAtualizado, double valorTransferido) {
        return saldoAtualizado - valorTransferido;
    }
}