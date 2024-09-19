import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        String nome = "Rafael";
        String tipoConta = "Corrente";
        double saldo = 2500;
        System.out.println("********************************************\n");
        System.out.println("Dados Iniciais do Cliente:");
        System.out.println("Nome:               " + nome);
        System.out.println("Tipo de Conta:      " + tipoConta);
        System.out.println("Saldo Inicial:      R$" + String.format("%.2f.", saldo));
        System.out.println("\n********************************************");
       
        Scanner leitura = new Scanner(System.in); // lê os dados do teclado
        
        
        while (true) {  // Loop para manter o menu até o usuário decidir encerrar
            
            mostrarOpcoes(); // monstra as opções do método private static void mostrarOpcoes()
            
            System.out.print("\nDigite a opção desejada (1-4): \n");
            
            if (!leitura.hasNextInt()) {
                System.out.println("Opção inválida! Favor digitar uma opção válida (1-4).");
                leitura.next(); // Limpa a entrada inválida
                continue; // Volta para o início do loop
            }
            
            int opcoes = leitura.nextInt(); // registra a opção digitada pelo usuário
            
            if (opcoes <= 0 || opcoes >= 5) {
                System.out.println("Opção inválida! Favor digitar uma opção válida (1-4).");
                continue; // Volta para o início do loop
            } 
            switch (opcoes) {
                case 1:
                    System.out.printf("Você digitou a (opção 1).\n\nSeu saldo é de R$%.2f.\n", saldo);
                    break;
                case 2:
                    System.out.println("Você digitou a (opção 2).\n\nQual valor em Reais deseja informar?");
                    double receber = leitura.nextDouble(); // variável do valor recebido
                    saldo += receber; // Atualiza o saldo
                    System.out.printf("\nVocê recebeu R$%.2f.", receber);
                    System.out.printf("\nSeu saldo agora é de R$%.2f.\n", saldo);
                    break;
                case 3:
                    System.out.println("Você digitou a (opção 3).\n\nQual valor em Reais deseja informar?");
                    double transferir = leitura.nextDouble(); // variável do valor transferido
                    if (transferir > saldo) { //se não houver saldo suficiente
                        System.out.println("Não há saldo suficiente para efetuar essa operação.\nRetornando ao menu.");
                    } else {
                    saldo -= transferir; // Atualiza o saldo
                    System.out.printf("\nVocê transferiu R$%.2f.", transferir);
                    System.out.printf("\nSeu saldo agora é de R$%.2f.\n", saldo);
                    }
                    break;
                case 4:
                    System.out.println("Você digitou a (opção 4).\n\nAplicação Encerrada!\n");
                    leitura.close(); // Fecha o Scanner
                    return; // Encerra o programa
            }
            
        }
           
    }
    private static void mostrarOpcoes() {
        System.out.println("\n1- Consultar Saldos");
        System.out.println("2- Receber Valor");
        System.out.println("3- Transferir Valor");
        System.out.println("4- Encerrar Aplicação");
    }
}
