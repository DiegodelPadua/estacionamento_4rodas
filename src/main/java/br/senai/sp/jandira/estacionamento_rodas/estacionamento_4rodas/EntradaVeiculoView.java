package br.senai.sp.jandira.estacionamento_rodas.estacionamento_4rodas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EntradaVeiculoView {


    private Stage stage;

    public EntradaVeiculoView() {
        // Cria um novo Stage (janela) para a tela de entrada
        stage = new Stage();
        stage.setTitle("Cadastro de Entrada de Veículo");
        stage.setWidth(800); // Ajustado para ser mais largo
        stage.setHeight(550); // Ajustado para ser mais alto

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false); // Impede que o usuário redimensione a janela

        // --- Layout Principal: BorderPane ---
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f0f0f0;"); // Cor de fundo cinza claro

        // --- TOP: Logo e Título ---
        HBox topHeader = new HBox(20); // Espaçamento entre logo e título
        topHeader.setPadding(new Insets(20, 20, 20, 20));
        topHeader.setAlignment(Pos.CENTER_LEFT);

        // Logo
//
//        StackPane logoContainer = new StackPane(logo);
//        logoContainer.setPrefSize(100, 80); // Tamanho fixo para o container
//        logoContainer.setStyle("-fx-background-color: blue; -fx-border-color: deepskyblue; -fx-border-width: 2;");
//        topHeader.getChildren().add(logoContainer);

        // Título da Página
        Label tituloPagina = new Label("Cadastro de entrada de veículo:");
        tituloPagina.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: black;");
        topHeader.getChildren().add(tituloPagina);

        root.setTop(topHeader);


        // --- CENTER: Formulário e Botão ENTRADA ---
        HBox centerContent = new HBox(50); // Espaçamento entre formulário e botão ENTRADA
        centerContent.setPadding(new Insets(0, 20, 0, 80)); // Padding para alinhar com a imagem
        centerContent.setAlignment(Pos.CENTER_LEFT); // Alinha o conteúdo do HBox ao centro-esquerda

        // Formulário (GridPane)
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(25); // Espaçamento vertical maior entre as linhas
        //formGrid.setAlignment(Pos.CENTER_LEFT); // Alinhe o GridPane dentro do HBox
        formGrid.setPadding(new Insets(0, 0, 0, 0)); // Remover padding extra, o HBox já tem

        // Label e TextField para Placa
        Label placaLabel = new Label("Placa do Veículo:");
        placaLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        TextField placaField = new TextField("XXX-0X00"); // Texto padrão como na imagem
        placaField.setPrefWidth(200);
        placaField.setPrefHeight(40); // Aumentar altura
        placaField.setStyle("-fx-background-color: darkgray; -fx-text-fill: white; -fx-font-size: 16px; -fx-alignment: center;");
        placaField.setEditable(false); // Como na imagem, parece não editável

        // Label e TextField para Modelo
        Label modeloLabel = new Label("Modelo do carro:");
        modeloLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        TextField modeloField = new TextField();
        modeloField.setPrefWidth(200);
        modeloField.setPrefHeight(40);
        modeloField.setStyle("-fx-background-color: darkgray;");

        // Label e TextField para Nome do proprietário
        Label proprietarioLabel = new Label("Nome do proprietário:");
        proprietarioLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        TextField proprietarioField = new TextField();
        proprietarioField.setPrefWidth(200);
        proprietarioField.setPrefHeight(40);
        proprietarioField.setStyle("-fx-background-color: darkgray;");

        // Label e TextField para Data e hora de entrada
        Label dataHoraLabel = new Label("Data e hora de entrada:");
        dataHoraLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        TextField dataHoraField = new TextField(); // Você pode preencher isso automaticamente
        dataHoraField.setPrefWidth(200);
        dataHoraField.setPrefHeight(40);
        dataHoraField.setStyle("-fx-background-color: darkgray;");

        formGrid.add(placaLabel, 0, 0);
        formGrid.add(placaField, 1, 0);
        formGrid.add(modeloLabel, 0, 1);
        formGrid.add(modeloField, 1, 1);
        formGrid.add(proprietarioLabel, 0, 2);
        formGrid.add(proprietarioField, 1, 2);
        formGrid.add(dataHoraLabel, 0, 3);
        formGrid.add(dataHoraField, 1, 3);

        // Botão ENTRADA (maior, como na imagem)
        Button btnEntradaGrande = new Button("ENTRADA");
        btnEntradaGrande.setPrefSize(200, 100); // Tamanho grande
        btnEntradaGrande.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
        btnEntradaGrande.setOnAction(e -> {
            // Lógica para registrar entrada
            System.out.println("Registrar entrada...");
            stage.close(); // Fecha a janela após registrar
        });

        centerContent.getChildren().addAll(formGrid, btnEntradaGrande);
        root.setCenter(centerContent);

        // --- BOTTOM: Botão VOLTAR ---
        HBox bottomBar = new HBox();
        bottomBar.setPadding(new Insets(20));
        bottomBar.setAlignment(Pos.BOTTOM_LEFT);

        Button btnVoltar = new Button("<< VOLTAR");
        btnVoltar.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-weight: bold;");
        btnVoltar.setOnAction(e -> stage.close()); // Fecha a janela

        bottomBar.getChildren().add(btnVoltar);
        root.setBottom(bottomBar);


        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    public void showAndWait() {
        stage.showAndWait();
    }
}