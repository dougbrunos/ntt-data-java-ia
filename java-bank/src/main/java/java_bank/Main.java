package java_bank;

import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import java_bank.exception.AccountNotFoundException;
import java_bank.exception.NoFundsEnoughException;
import java_bank.model.AccountWallet;
import java_bank.repository.AccountRepository;
import java_bank.repository.InvestmentRepository;

public class Main {

    private final static AccountRepository accountRepository = new AccountRepository();
    private final static InvestmentRepository investmentRepository = new InvestmentRepository();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Java Bank!");
        while (true) { 
            System.out.println("Selecione a operação desejada:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Criar um investimento");
            System.out.println("3 - Fazer um investimento");
            System.out.println("4 - Depositar na conta");
            System.out.println("5 - Sacar da conta");
            System.out.println("6 - Transferir entre contas");
            System.out.println("7 - Investir");
            System.out.println("8 - Sacar investimento");
            System.out.println("9 - Listar contas");
            System.out.println("10 - Listar investimentos");
            System.out.println("11 - Listar carteiras de investimento");
            System.out.println("12 - Atualizar investimentos");
            System.out.println("13 - Histórico de contas");
            System.out.println("14 - Sair");
            var option = scanner.nextInt();
            switch (option) {
                case 1: createAccount();
                case 2: createInvestment();
                case 3: createWalletInvestment();
                case 4: deposit();
                case 5: withdraw();
                case 6: transferToAccount();
                case 7: incInvestment();
                case 8: rescueInvestment();
                case 9: accountRepository.list().forEach(System.out::println);
                case 10: investmentRepository.list().forEach(System.out::println);
                case 11: investmentRepository.listWallets().forEach(System.out::println);
                case 12: {
                    investmentRepository.updateAmount();
                    System.out.println("Investimentos atualizados com sucesso!");
                }
                case 13: checkHistory();
                case 14: System.exit(0);
                default: System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void createAccount() {
        System.out.println("Informe as chaves pix (separadas por ';'): ");
        var pixKeys = Arrays.stream(scanner.next().split(";")).toList();
        System.out.println("Informe o valor inicial da conta: ");
        var amount = scanner.nextLong();
        var wallet = accountRepository.create(pixKeys, amount);
        System.out.println("Conta criada com sucesso! Detalhes da conta: " + wallet);
    }

    private static void createInvestment() {
        System.out.println("Informe a taxa do investimento: ");
        var tax = scanner.nextInt();
        System.out.println("Informe o valor inicial de deposito: ");
        var initialFunds = scanner.nextLong();
        var investment = investmentRepository.create(tax, initialFunds);
        System.out.println("Investimento criado com sucesso! Detalhes do investimento: " + investment);
    }

    private static void withdraw() {
        System.out.println("Informe a chave pix da conta: ");
        var pix = scanner.next();
        System.out.println("Informe o valor a ser sacado: ");
        var amount = scanner.nextLong();
        try {
            accountRepository.withdraw(pix, amount);
            System.out.println("Saque realizado com sucesso!");
        } catch (AccountNotFoundException | NoFundsEnoughException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deposit() {
        System.out.println("Informe a chave pix da conta: ");
        var pix = scanner.next();
        System.out.println("Informe o valor a ser depositado: ");
        var amount = scanner.nextLong();
        try {
            accountRepository.deposit(pix, amount);
            System.out.println("Depósito realizado com sucesso!");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void transferToAccount() {
        System.out.println("Informe a chave pix de origem: ");
        var source = scanner.next();
        System.out.println("Informe a chave pix de destino: ");
        var target = scanner.next();
        System.out.println("Informe o valor a ser transferido: ");
        var amount = scanner.nextLong();
        try {
            accountRepository.transferMoney(source, target, amount);
            System.out.println("Transferência realizada com sucesso!");
        } catch (AccountNotFoundException | NoFundsEnoughException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createWalletInvestment() {
        System.out.println("Informe a chave pix da conta: ");
        var pix = scanner.next();
        var account = accountRepository.findByPix(pix);
        System.out.println("Informe o ID do investimento: ");
        var id = scanner.nextInt();
        var investmentWallet = investmentRepository.initInvestment(account, id);
        System.out.println("Conta de investimento criada com sucesso! Detalhes: " + investmentWallet);
    }

    private static void incInvestment() {
        System.out.println("Informe a chave pix da conta para investimento: ");
        var pix = scanner.next();
        System.out.println("Informe o valor a ser investido: ");
        var amount = scanner.nextLong();
        try {
            investmentRepository.deposit(pix, amount);
            System.out.println("Investimento realizado com sucesso!");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void rescueInvestment() {
        System.out.println("Informe a chave pix da conta para resgatar investimento: ");
        var pix = scanner.next();
        System.out.println("Informe o valor a ser sacado: ");
        var amount = scanner.nextLong();
        try {
            investmentRepository.withdraw(pix, amount);
            System.out.println("Saque realizado com sucesso!");
        } catch (AccountNotFoundException | NoFundsEnoughException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkHistory() {
        System.out.println("Informe a chave pix da conta para verificar o extrato: ");
        var pix = scanner.next();
        AccountWallet wallet;
        try {
            wallet = accountRepository.findByPix(pix);
            var audit = wallet.getFinancialTransactions();
            var group = audit.stream()
                    .collect(Collectors.groupingBy(t -> t.createdAt().truncatedTo(SECONDS)));
            group.forEach((date, transactions) -> {
                System.out.println("Data: " + date);
                transactions.forEach(t -> System.out.println("  " + t));
            });
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }

}