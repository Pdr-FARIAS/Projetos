package market.Modelo;
import market.viwer.Markett;


import market.viwer.opçao;

import javax.swing.*;



public class Verificar {


    public static Void Verificar(String entrada) {
      opçao op;
      op=opçao.valueOf(entrada);

        if (op==opçao.CADASTRAR) {
           Markett.cadastrarProduto();

        } else if (op == opçao.LISTAR) {
            Markett.ListarProduto();

        } else if (op == opçao.COMPRAR) {
           Markett.CompararProduto();

        } else if (op == opçao.VISUALIZAR) {
           Markett.VizualizarCarrinho();

        } else if (op==opçao.SAIR)
        {
            JOptionPane.showInternalMessageDialog(null, "Volte sempre ");
            Fromat.pausar(2);
            System.exit(0);
        }else {
            JOptionPane.showInternalMessageDialog(null,"Opçao invalida.");
            Fromat.pausar(2);
            Markett.menu();
        }
        return null;
    }
}


