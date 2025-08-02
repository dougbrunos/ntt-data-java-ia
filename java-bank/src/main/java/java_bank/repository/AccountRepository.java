package java_bank.repository;

import java.util.ArrayList;
import java.util.List;

import java_bank.exception.AccountNotFoundException;
import java_bank.exception.PixInUseException;
import java_bank.model.AccountWallet;
import static java_bank.repository.CommonsRepository.checkFundsForTransaction;

public class AccountRepository {

    private final List<AccountWallet> accounts = new ArrayList<>();

    public AccountWallet create(final List<String> pix, final long initialFunds) {
        if (!accounts.isEmpty()) {
            var pixInUse = accounts.stream().flatMap(a -> a.getPix().stream()).toList();
            for (var p : pix) {
                if (pixInUse.contains(p)) {
                    throw new PixInUseException("O PIX " + p + " já está em uso.");
                }
            }
        }
        var newAccount = new AccountWallet(initialFunds, pix);
        accounts.add(newAccount);
        return newAccount;
    }

    public void deposit(final String pix, final long fundsAmount) {
        var target = findByPix(pix);
        target.addMoney(fundsAmount, "depósito");
    }

    public long withdraw(final String pix, final long amount) {
        var source = findByPix(pix);
        checkFundsForTransaction(source, amount);
        source.reduceMoney(amount);
        return amount;
    }

    public void transferMoney(final String sourcePix, final String targetPix, final long amount) {
        var source = findByPix(sourcePix);
        checkFundsForTransaction(source, amount);
        var target = findByPix(targetPix);
        source.reduceMoney(amount);
        target.addMoney(source.reduceMoney(amount), source.getService(), "transferência de " + sourcePix);
    }

    public AccountWallet findByPix(final String pix) {
        return this.accounts.stream()
                .filter(a -> a.getPix().contains(pix))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Conta não encontrada com o PIX: " + pix));
    }

    public List<AccountWallet> list() {
        return this.accounts;
    }

}
