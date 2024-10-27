package Banco.conta.BANCO;

import Banco.conta.Cliente;
import market.Modelo.helper;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Interfase {
    static String nome = "Banco Pedro";
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contas;

    public static void main(String[] args) {
        Interfase.contas = new ArrayList<Conta>();
        Interfase.menu();
    }

    public static void menu() {
        int opçao = 0;
        System.out.println("=========================================================");
        System.out.println("========================ATM==============================");
        System.out.println("=======================" + Interfase.nome + "================");
        System.out.println("=============================================================");
        System.out.println("selecione uma das opçoes ");
        System.out.println("1 - criar conta ");
        System.out.println("2 - tranferencia  ");
        System.out.println("3 - depositar ");
        System.out.println("4 - sacar ");
        System.out.println("5 - listar conta");
        System.out.println("6 - sair do sistema");


        try {
            opçao = Integer.parseInt(Interfase.teclado.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("opçao invalida");
            helper.pausar(1);
            Interfase.menu();
        }
        switch (opçao) {
            case 1:
                Interfase.criarConta();
                break;
            case 2:
                Interfase.transferir();
                break;
            case 3:
                Interfase.deposito();
                break;
            case 4:
                Interfase.sacar();
                break;
            case 5:
                Interfase.listarConta();
                break;
            case 6:
                System.out.println("Até a proxima");
                helper.pausar(2);
                System.exit(0);

            default:
                System.out.println("Opçao invalida .");
                helper.pausar(2);
                Interfase.menu();

                break;

        }
    }


    public static void criarConta() {

        System.out.println("informe os seguintes itens");
        System.out.println("NOME DO CLIENTE");
        String nome = Interfase.teclado.nextLine();
        System.out.println("qual seria o endereço do cliente");
        String endereço = Interfase.teclado.nextLine();
        System.out.println("qual é o cpf do cliente ");
        String cpf = Interfase.teclado.nextLine();
        System.out.println("Informe a data de nacimento do cliente ");
        String data_nacimento = Interfase.teclado.nextLine();

        Cliente cliente = new Cliente(nome, endereço, helper.Stringparadate(data_nacimento), cpf);
        Conta conta = new Conta(cliente);
        Interfase.contas.add(conta);
        System.out.println("Conta criada com sucesso ");
        System.out.println("Dados da conta criada são:\n" + conta);
        helper.pausar(2);
        Interfase.menu();

    }

    public static void transferir() {
        System.out.println("Informe o numeor da conta da sua conta :");
        int numero_co=Interfase.teclado.nextInt();
        Conta conta1=Interfase.busca(numero_co);
        if (conta1!=null){
            System.out.println("informe o numero da conta destino:");
            int numero_cd=Interfase.teclado.nextInt();
            Conta conta2=Interfase.busca(numero_cd);
            if (conta2 !=null){
                System.out.println(" informe o valor a ser tranferido ");
                Double valor=Interfase.teclado.nextDouble();
                conta1.tranferir(conta2,valor);


            }else {
                System.out.println("nao foi encontrado a conta do destinatario  "+numero_cd);


            }

        }else {
            System.out.println("nao foi encontrado a conta "+numero_co);
            helper.pausar(3);
            Interfase.menu();
        }


    }
    public static void deposito(){
        System.out.println("informe o numero da conta aqual o deposito sera realizado ");
        int numeroc=Interfase.teclado.nextInt();
        Conta conta=Interfase.busca(numeroc);
        if(conta!=null){
            System.out.println("qual o valor a ser depositado");
            Double valor=Interfase.teclado.nextDouble();
            conta.depositar(valor);


        }else {
            System.out.println("numero da conta invalido favor digitar um valor correto ");
            helper.pausar(3);
            Interfase.menu();
        }

    }
    public static  void sacar(){
        System.out.println("informe o numero da conta aqual  sera realizado o saque ");
        int numeroc=Interfase.teclado.nextInt();
        Conta conta=Interfase.busca(numeroc);
        if(conta!=null){
            System.out.println("qual o valor a ser sacado");
            Double valor=Interfase.teclado.nextDouble();
            conta.sacar(valor);


        }else {
            System.out.println("numero da conta invalido favor digitar um valor correto ");
            helper.pausar(3);
            Interfase.menu();
        }



    }
    public static void listarConta(){
        if (Interfase.contas.size()>0){
            System.out.println("listagem de contas");
            System.out.println();
            for (Conta conta:Interfase.contas){
                System.out.println(conta);
                System.out.println();
                helper.pausar(1);

            }
            System.out.println();

        }else {
            System.out.println("nao existem contas cadastradas ");
            helper.pausar(3);
            Interfase.menu();
        }

    }
    private static Conta busca(int num){
        Conta c=null;
        if(Interfase.contas.size()>0){
            for (Conta conta:Interfase.contas){
                if(conta.getNumero()==num){
                    c=conta;

                }
            }

        }return c;

    }

}
