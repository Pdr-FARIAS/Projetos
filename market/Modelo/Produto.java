package market.Modelo;



public class Produto {
    private String nome;
    private Double Preco;
    private int quantidade;
    private static int contador=1;
    private  int id;


    public Produto(String nome, Double preco, int quantidade) {
       this.id=Produto.contador;
        this.nome = nome;
        Preco = preco;
        this.quantidade = quantidade;
        Produto.contador+=1;

    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Produto.contador = contador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "codigo: " + this.getId() +
                "\nNome:" + this.getNome() +
                "\nQuantidade: " + this.getQuantidade() +
                "\nPreço: " + Fromat.doubleParaString(this.getPreco());
    }







}
