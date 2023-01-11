package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Window;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

@Component
public class UserFx {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    UserController userController;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passField;

    @FXML
    private TextField phoneField;

    @FXML
    private DatePicker dobField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    Window owner;

    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        owner=submitButton.getScene().getWindow();

        System.out.println(nameField.getText());
        System.out.println(emailField.getText());
        System.out.println(passField.getText());
        System.out.println(phoneField.getText());
        System.out.println(dobField.getValue());

        if(nameField.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter the Name");
            return;
        }

        if(emailField.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter the Email");
            return;
        }

        if(passField.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter the Password");
            return;
        }

        if(phoneField.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter the Phone Number");
            return;
        }

        String Name=nameField.getText();
        String Email=emailField.getText();
        String Password=passField.getText();
        String Phone=phoneField.getText();
        LocalDate Date=dobField.getValue();

        User user=new User();
        user.setName(Name);
        user.setEmail(Email);
        user.setPassword(Password);
        user.setPhone(Phone);
        user.setBirthDate(Date);

        userController.insertRecord(user);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + nameField.getText());

        clearField();
        Stage stage= (Stage) submitButton.getScene().getWindow();
        stage.close();
        showAddressWindow();
    }
    public void showAddressWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/Address_View.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public void clearField()
    {
        nameField.setText("");
        emailField.setText("");
        passField.setText("");
        phoneField.setText("");
    }

    public void cancel(ActionEvent event)
    {
      // System.exit(0);
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
