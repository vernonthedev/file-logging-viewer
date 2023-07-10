

package com.veike.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {
    @FXML
    private TextArea myTextContent;

    @FXML
    private Button saveContentBtn;

    //get access to the class used for choosing files
    FileChooser fileChooser = new FileChooser();


    //a button to handle the close function on the window
    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void openFileContent(MouseEvent event) {

        //show the opening file dialog in anew stage
        File file = fileChooser.showOpenDialog(new Stage());
        //try reading the file line by line using the scanner class
        try{
            Scanner scanner = new Scanner(file);
            //if the file has more than one line then append all the data onto the text file
            while(scanner.hasNextLine()){
                myTextContent.appendText(scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        myTextContent.setVisible(true);

    }

    //method to save the newly written content onto disk
    @FXML
    void saveContent(MouseEvent event) {
        File file = fileChooser.showSaveDialog(new Stage());
        //only save the file if we have any content inside it
        try{
            if(file != null){
                saveOnSystem(file, myTextContent.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //the method that runs even before the application has fully started
    //acts as an initialization method for the variables and the data to be used in the application
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set the initial folder where the file will search for the files from
        fileChooser.setInitialDirectory(new File("C:\\Users\\vernonthedev\\Documents\\"));
    }

    //method to help on saving the newly typed in info into the computer as a file
    public void saveOnSystem(File file, String content){
        try{
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
