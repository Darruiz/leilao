package leilao;

public class Usuario {
    private int id;
    private String nome;
    private boolean ativo;

    public Usuario() {
        this.id = 0;
        this.nome = "Sem Nome";
        this.ativo = true;
    }

    public Usuario(int id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void exibirID() {
        System.out.println("ID: " + this.id);
    }

    public void exibirNome() {
        System.out.println("Nome: " + this.nome);
    }

    public void exibirAtivo() {
        System.out.println("Ativo: " + (this.ativo ? "Sim" : "Não"));
    }
}