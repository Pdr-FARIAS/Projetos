package market.viwer;

import market.Modelo.Fromat;
import market.Modelo.Produto;
import market.Modelo.Verificar;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Markett {

    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        Markett.menu();

    }

    public static void menu() {

        JOptionPane.showInternalMessageDialog(null, "============================================" +
                "\n===============Seja BEM-VINDO (a)============="
                + "\n=============== Ao SuperMarket==============="
                + "\n=============================================");

        String entrada = JOptionPane.showInputDialog("selecione umas das opçoes abaixo" +
                "\ncadastrar  " + "\nListar  " + "\nComprar " + "\nVisualizar " + "\nSair");
        String entarda1 = entrada.toUpperCase();

        Verificar.Verificar(entarda1);

    }

    public static void cadastrarProduto() {
        String nome = JOptionPane.showInputDialog("informe o nome do produto");
        String preço = JOptionPane.showInputDialog("informe o preço do produto ");
        String quantidade = JOptionPane.showInputDialog("informe a quantidade desse produto");
        Double preço1 = Double.parseDouble(preço);
        int quantidade1 = Integer.parseInt(quantidade);
        Produto produto = new Produto(nome, preço1, quantidade1);
        Markett.produtos.add(produto);
        JOptionPane.showInternalMessageDialog(null, "o produto" + produto.getNome() + "foi cadastrado com sucesso.");
        Fromat.pausar(2);
        Markett.menu();


    }

    public static void ListarProduto() {
        if (Markett.produtos.size() > 0) {
            for (Produto p : Markett.produtos) {
                JOptionPane.showInternalMessageDialog(null, p + "\n");
            }

        } else {
            JOptionPane.showInternalMessageDialog(null, "Nao tem produtos ");
        }
        Fromat.pausar(2);
        Markett.menu();


    }

    public static void CompararProduto() {
        if (Markett.carrinho.size() > 0) {
            for (Produto p : Markett.produtos) {
                JOptionPane.showInternalMessageDialog(null, p);
            }
            String codigo = JOptionPane.showInputDialog("QUAL É O CODIGO DO PRODUTO");
            int cod = Integer.parseInt(codigo);
            boolean tem = false;
            for (Produto p : Markett.produtos) {
                if (p.getId() == cod) {
                    int quant = 0;
                    try {
                        quant = Markett.carrinho.get(p);
                        Markett.carrinho.put(p, quant + 1);

                    } catch (NullPointerException e) {
                        Markett.carrinho.put(p, 1);
                    }
                    JOptionPane.showInternalMessageDialog(null, "o produto " + p.getNome() + "FOI ADD NO CARRINHO");
                    tem = true;


                    if (tem) {
                        String novo = JOptionPane.showInputDialog("deseja add novos produtos ao carrinho" + "\n1 para sim 2 para nao");
                        int novo1 = Integer.parseInt(novo);
                        if (novo1 == 1) {
                            Markett.CompararProduto();
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "AGUARDE ENQUANTO FECHAMOS A FATURA");
                            Fromat.pausar(2);
                            Markett.fecharPedido();

                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(null, "nao foi encontrado o codigo do produto " + codigo);
                        Fromat.pausar(2);
                        Markett.menu();
                    }

                } else {
                    JOptionPane.showInternalMessageDialog(null, "AINDA NAO TEM PRODUTOS NESSE MERCADO.");
                    Fromat.pausar(2);
                    Markett.menu();
                }


            }
        }
    }

    public static void VizualizarCarrinho() {
        if (Markett.carrinho.size() > 0) {
            for (Produto p : Markett.carrinho.keySet()) {
                JOptionPane.showInternalMessageDialog(null, "PODUTO :" + p + "\nQuantidade de produtos " + Markett.carrinho.get(p));
            }


        } else {
            JOptionPane.showInternalMessageDialog(null, "Nao tem produtos  no carrinho ainda");
        }
        Fromat.pausar(2);
        Markett.menu();

    }

    public static void fecharPedido() {
        double valortotal = 0.0;
        for (Produto p : Markett.carrinho.keySet()) {
            int quant = Markett.carrinho.get(p);
            valortotal += p.getPreco() * quant;

        }
        JOptionPane.showInternalMessageDialog(null, "sua fatura é de :" + Fromat.doubleParaString(valortotal));
        Markett.carrinho.clear();
        JOptionPane.showInternalMessageDialog(null, "OBRIGADO PELA COMPRA VOLTE SEMPRE");
        Fromat.pausar(5);
        Markett.menu();
    }


}

