package leilao;

import java.util.ArrayList;
import java.util.List;

public class ConteudoLeilao {
    private double lanceInicial;
    private List<Double> historicoLances;
    private double maiorLance;
    private String vencedor;

    // Construtor
    public ConteudoLeilao(double lanceInicial) {
        this.lanceInicial = lanceInicial;
        this.historicoLances = new ArrayList<>();
        this.maiorLance = lanceInicial;
        this.vencedor = "Nenhum vencedor ainda";
    }

    // Getters e Setters
    public double getLanceInicial() {
        return lanceInicial;
    }

    public void setLanceInicial(double lanceInicial) {
        this.lanceInicial = lanceInicial;
        if (historicoLances.isEmpty()) {
            this.maiorLance = lanceInicial;
        }
    }

    public List<Double> getHistoricoLances() {
        return historicoLances;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public void adicionarLance(double lance, String nomeParticipante) {
        if (lance > maiorLance) {
            historicoLances.add(lance);
            maiorLance = lance;
            vencedor = nomeParticipante;
            System.out.println("Novo maior lance de " + nomeParticipante + ": " + lance);
        } else {
            System.out.println("Lance de " + nomeParticipante + " foi inferior ao maior lance.");
        }
    }

    public void exibirHistoricoLances() {
        System.out.println("Histórico de lances:");
        for (Double lance : historicoLances) {
            System.out.println("Lance: " + lance);
        }
    }

    public void exibirInformacoesLeilao() {
        System.out.println("Lance Inicial: " + lanceInicial);
        System.out.println("Maior Lance: " + maiorLance);
        System.out.println("Vencedor Atual: " + vencedor);
    }
}