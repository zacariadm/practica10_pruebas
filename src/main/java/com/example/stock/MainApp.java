
package com.example.stock;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(MainApp.class.getResource("/productView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(MainApp.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
