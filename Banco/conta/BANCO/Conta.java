package Banco.conta.BANCO;

import Banco.conta.Cliente;


public class Conta {
    private static int codigo = 1;
    private int numero;
    private Cliente cliente;
    private double saldo = 0.0;
    private double limite = 0.0;
    private double saldoTotal;

    public int getNumero() {
        return numero;
    }

    public Conta(Cliente cliente) {
        this.numero = Conta.codigo;
        this.cliente = cliente;
        Conta.codigo += 1;
        this.atualizaSaldoTotal();
    }

    public Banco.conta.Cliente getCliente() {
        return cliente;
    }

    public void setCliente( Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    private void atualizaSaldoTotal() {
        this.setSaldoTotal(this.getSaldo() + this.getLimite());
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            this.atualizaSaldoTotal();
            System.out.println("Deposito realizado com sucesso");

        } else {
            System.out.println("Erro ao efetuar o deposito .Tent novamente");
        }


    }

    public void tranferir(Conta conta, Double valor) {

        if (valor > 0 && this.saldoTotal >= valor) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                conta.setSaldo(conta.getSaldo() + valor);
                this.atualizaSaldoTotal();
                conta.atualizaSaldoTotal();
                System.out.println("tranferencia efetuada com sucesso ");
            } else {
                double restante = this.getSaldo() - valor;
                this.limite = getLimite() - restante;
                this.setSaldo(0.0);
                conta.setSaldo(this.getSaldo() + restante);
                this.atualizaSaldoTotal();
                conta.atualizaSaldoTotal();
                System.out.println("tranferencia efetuada com sucesso ");
            }

        } else {
            System.out.println("tranferencia nao efetuada");
        }

    }


    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldoTotal() >= valor) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                this.atualizaSaldoTotal();
                System.out.println("saldo efetuado com sucesso ");
            } else {
                double restante = this.getSaldo() - valor;
                this.setLimite(this.getLimite() - restante);
                this.setSaldo(0.0);
                this.atualizaSaldoTotal();
                System.out.println("saque efetuado com sucesso");
            }

        } else {
            System.out.println("saque nao realizado . tente novamente ");
        }


    }



}
