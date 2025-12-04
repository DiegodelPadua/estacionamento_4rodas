package br.senai.sp.jandira.estacionamento_rodas.estacionamento_4rodas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Veiculo {
    private String placa;
    private String modelo;
    private String proprietario;
    private LocalDateTime dataHoraEntrada; // Usar LocalDateTime para data e hora

    public Veiculo(String placa, String modelo, String proprietario, LocalDateTime dataHoraEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = proprietario;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    // Getters para acessar os dados
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    // Método auxiliar para formatar a data e hora
    public String getDataHoraEntradaFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHoraEntrada.format(formatter);
    }
}
