package pojo;

import java.util.ArrayList;

public class Carrinho {

    private static Carrinho instance;

    private ArrayList<String> produtos = new ArrayList();

    private Carrinho() {
        
    }

    public static Carrinho getInstance() {
        if (Carrinho.instance == null) {
            Carrinho.instance = new Carrinho();
        }
        return Carrinho.instance;
    }

    public ArrayList<String> getProduto() {
        return produtos;
    }

    public void setProduto(ArrayList<String> produtos) {
        this.produtos = produtos;
    }
}
