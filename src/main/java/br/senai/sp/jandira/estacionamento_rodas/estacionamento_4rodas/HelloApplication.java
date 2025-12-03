package br.senai.sp.jandira.estacionamento_rodas.estacionamento_4rodas;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();
        //Definir tamanho da tela
        stage.setWidth(800);
        stage.setHeight(550);

        //Confirmação do encerramento Stage
        stage.setOnCloseRequest(event -> { //o nome EVENT é uma variável eu que escolho
            event.consume();
            fechar();

        });

        //Bloquear o redimensionamento da janela
        stage.setResizable(false);


        Scene scene = new Scene(root);

        //Cabeçalho da tela
        HBox top = new HBox();
        top.setStyle("-fx-padding: 10; -fx-background-color: white;");
        top.setSpacing(20);
        top.setAlignment(Pos.CENTER_LEFT); // Alinha o conteúdo do HBox ao centro-esquerda, para começar o logo/título


//        ImageView logo = new ImageView(new Image("scr/main/resources/br/senai/sp/jandira/estacionamento_rodas/estacionamento_4rodas/image1.png"));
//        logo.setFitWidth(120);
//        logo.setFitHeight(100);
//        top.getChildren().add(logo); // Adiciona o logo ao HBox 'top'

        // Título central
        Label titulo = new Label("Entrada e Saída de Veículos");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        HBox.setHgrow(titulo, Priority.ALWAYS); // Permite que o título cresça horizontalmente
        titulo.setMaxWidth(Double.MAX_VALUE);
        titulo.setAlignment(Pos.CENTER); // Alinha o texto do título ao centro (dentro do seu espaço)

        // Labels do lado direito (Vagas)
        VBox info = new VBox();
        info.setSpacing(5); // Espaçamento menor entre as labels de vagas
        info.setAlignment(Pos.CENTER_RIGHT); // Alinha as labels de vagas à direita dentro do VBox 'info'
        info.setPadding(new Insets(0, 10, 0, 0)); // Adiciona um padding à direita para afastar das bordas

        Label vagasLivres = new Label("10 VAGAS DISPONÍVEIS!");
        vagasLivres.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        Label vagasOcupadas = new Label("40 VAGAS OCUPADAS!");
        vagasOcupadas.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        // Adiciona as labels ao VBox 'info'
        info.getChildren().addAll(vagasLivres, vagasOcupadas);

        // *** CORREÇÃO AQUI: Adicione o título e o VBox 'info' ao HBox 'top' ***
        top.getChildren().addAll(titulo, info);
        // HBox.setMargin(info, new Insets(0, 10, 0, 0)); // Adiciona uma margem à direita para o VBox 'info'

        // Define o HBox 'top' como o TOP do BorderPane 'root'
        root.setTop(top);


        // Ajuste a ordem de show e setScene para ser mais lógico
        stage.setScene(scene);
        stage.setTitle("Estacionamento 4Rodas");
        stage.show();


        //CENTRO: área cinza + botões (HBox)
        HBox center = new HBox();
        center.setSpacing(30);
        center.setStyle("-fx-padding: 20;");
        center.setAlignment(Pos.CENTER); // Centraliza o conteúdo do HBox 'center'

        // Área cinza
        Pane painelCinza = new Pane();
        painelCinza.setStyle("-fx-background-color: lightgray;");
        painelCinza.setPrefSize(400, 200); // Reduzi o tamanho para caber melhor na tela inicial
        HBox.setHgrow(painelCinza, Priority.ALWAYS); // Permite que o painel cinza cresça para preencher o espaço

        // Botões (VBox)
        VBox botoes = new VBox();
        botoes.setSpacing(20);
        botoes.setAlignment(Pos.CENTER); // Centraliza os botões dentro do VBox

        Button btnDeletar = new Button("DELETAR");
        btnDeletar.setStyle("-fx-background-color: darkred; -fx-text-fill: white; -fx-font-size: 12;");
        btnDeletar.setPrefWidth(150);
        btnDeletar.setPrefHeight(30); // Aumentei um pouco a altura

        Button btnSaida = new Button("SAÍDA");
        btnSaida.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16;");
        btnSaida.setPrefWidth(150);
        btnSaida.setPrefHeight(50);

        Button btnEntrada = new Button("ENTRADA");
        btnEntrada.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16;");
        btnEntrada.setPrefWidth(150);
        btnEntrada.setPrefHeight(50);

        // *** AÇÃO DO BOTÃO ENTRADA AQUI ***
        btnEntrada.setOnAction(event -> {
            EntradaVeiculoView entradaView = new EntradaVeiculoView();
            entradaView.showAndWait(); // Abre a nova janela e espera ela ser fechada
            // Qualquer código aqui só será executado após a janela de entrada ser fechada.
            // Por exemplo, você poderia atualizar as vagas aqui.
            System.out.println("Janela de entrada fechada.");
        });

        botoes.getChildren().addAll(btnDeletar, btnSaida, btnEntrada);


        // Montar o centro
        center.getChildren().addAll(painelCinza, botoes);
        root.setCenter(center); // Define o HBox 'center' como o CENTER do BorderPane 'root'


    }

    public static void main(String[] args) {
        launch(args);
    }
    public void fechar() {
        Alert alertaFechar = new Alert(Alert.AlertType.CONFIRMATION,
                "Confirma a saída do sistema? ", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> resposta = alertaFechar.showAndWait();
        if (resposta.isPresent() && resposta.get() == ButtonType.YES)
            Platform.exit();


    }
}