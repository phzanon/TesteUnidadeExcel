package Entidades;

import Util.Banco;

public class Produto 
{
    private int codigo;
    private String descricao;
    private int quantidade;
    private double valor;

    public Produto(int codigo, String descricao, int quantidade, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto(String descricao, int quantidade, double valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto()
    {
        this(0,"",0,0);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    public boolean atualizarEstoque(int qtde)
    {
        String sql = "update produto set pro_quantidade='"+qtde+"' where pro_cod="+this.getCodigo();
        return Banco.con.manipular(sql);
    }
    
}
