package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.Model.Pedido;
import br.com.alura.mvc.mudi.Model.StatusPedido;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

    @NotBlank(message = "O campo nome do produto é obrigatorio!")
    String nomeProduto;
    @NotBlank(message = "O campo nome do produto é obrigatorio!")
    String urlProduto;
    @NotBlank(message = "O campo nome do produto é obrigatorio!")
    String urlImagem;

    String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();

        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlImage(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setDescricao(descricao);
        pedido.setStatus(StatusPedido.AGUARDANDO);

        return pedido;
    }
}
