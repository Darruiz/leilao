package leilao;

public class Lance {
    private Usuario usuario;
    private ConteudoLeilao leilao;
    private double valor;

    public Lance(Usuario usuario, ConteudoLeilao leilao, double valor) {
        this.usuario = usuario;
        this.leilao = leilao;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ConteudoLeilao getLeilao() {
        return leilao;
    }

    public void setLeilao(ConteudoLeilao leilao) {
        this.leilao = leilao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void exibirDetalhesLance() {
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Valor do Lance: " + valor);
        leilao.exibirInformacoesLeilao();
    }
}