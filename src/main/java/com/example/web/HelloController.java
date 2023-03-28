package com.example.web;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloController {

    public TextField addHeading;
    public TextField addButton;
    public TextArea addParagraph;
    public VBox website;

    @FXML
    void initialize() {
        String Style = Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm();
        website.getStylesheets().add(Style);
    }

    public void heading(ActionEvent event) {
        if (addHeading.getText().equals("")) return;
        Label heading = new Label(addHeading.getText());
        heading.setId("heading");
        website.getChildren().add(heading);
    }

    public void paragraph(ActionEvent event) {
        if (addParagraph.getText().equals("")) return;
        Label paragraph = new Label(addParagraph.getText());
        paragraph.setId("paragraph");
        website.getChildren().add(paragraph);
    }

    public void picture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        ImageView imageView = new ImageView(fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow()).getAbsolutePath());

        if (imageView.getFitWidth() < imageView.getFitHeight()){
            imageView.setFitHeight(155);
        }
        else {
            imageView.setFitWidth(155);
        }
        imageView.setPreserveRatio(true);
        website.getChildren().add(imageView);
    }

    public void button(ActionEvent event) {
        if (addButton.getText().equals("")) return;
        Button button = new Button(addButton.getText());
        button.setCursor(Cursor.HAND);
        website.getChildren().add(button);
    }

    public void navigation(ActionEvent event) {
        Label home = new Label("Home"), about = new Label("About"), contact = new Label("Contact Us"), signUp = new Label("Sign Up");
        HBox info = new HBox(home, about, contact, signUp);
        info.setSpacing(15);
        website.getChildren().add(info);
    }
    public void exit(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}