package com.veike.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    //define the variables
    double y = 0, x = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log Viewer!");
        stage.initStyle(StageStyle.UNDECORATED); //hide the top-bar
        stage.setResizable(false);

        //dragging the window by  mouse click from anywhere
        //first get the positions of the mouse
        scene.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        //set the new position of the mouse to that of the window
        scene.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getSceneY() - y);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //create a new file
        File file = new File("C:\\Users\\vernonthedev\\Documents\\logviewer_logs.txt");
        try{
            file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        launch();
    }
}


