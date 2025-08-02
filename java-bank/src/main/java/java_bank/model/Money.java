package java_bank.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Explique todo esse código
// Esse código define uma classe Money que representa uma quantia de dinheiro em um sistema bancário.
// A classe Money contém uma lista de MoneyAudit, que registra transações relacionadas a essa quantia de dinheiro.

@EqualsAndHashCode
@ToString
@Getter
public class Money {

    private final List<MoneyAudit> history = new ArrayList<>(); // Lista de auditoria de transações

    // Construtor que aceita um objeto MoneyAudit e adiciona à lista de histórico
    public Money(final MoneyAudit history) {
        this.history.add(history);
    }

    // Método para adicionar um histórico de transação
    public void addHistory(final MoneyAudit history) {
        this.history.add(history);
    }

}