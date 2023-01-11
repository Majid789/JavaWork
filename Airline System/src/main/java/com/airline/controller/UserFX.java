package com.airline.controller;

//import com.airline.entity.User;
import com.airline.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class UserFX {


    @Autowired
    UserController userController;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNoField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker dobField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    // ClassPathXmlApplicationContext context;

    public void register(ActionEvent event) throws SQLException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //   context =
        //         new ClassPathXmlApplicationContext("/META-INF/spring/application-context.xml");
        Window owner = submitButton.getScene().getWindow();

        System.out.println(firstNameField.getText());
        System.out.println(lastNameField.getText());
        System.out.println(phoneNoField.getText());
        System.out.println(emailField.getText());
        System.out.println(dobField.getValue().toString());
        if(firstNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your First Name");
            return;
        }

        if(lastNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Last Name");
            return;
        }

        if(phoneNoField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Phone Number");
            return;
        }

        if(emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Email");
            return;
        }

        String FirstName = firstNameField.getText().toString();
        String  LastName = lastNameField.getText().toString();
        Long phoneNo= Long.valueOf(phoneNoField.getText());
        String email = emailField.getText().toString();
        LocalDate dob = dobField.getValue();

        User user= new User();
        user.setFirstName(FirstName);
        user.setLastName(LastName);
        user.setPhone(phoneNo);
        user.setEmail(email);
        java.util.Date dt=Date.from(dob.atStartOfDay(defaultZoneId).toInstant());
        Date newDate=new Date(dt.getTime());
        user.setDob(newDate);

        userController.insertPayment(user);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + firstNameField.getText());
        clearFields();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public void clearFields(){
        firstNameField.setText("");
        lastNameField.setText("");
        phoneNoField.setText("");
        emailField.setText("");

    }

    public void cancel(ActionEvent actionEvent) {
        // context.close();
        System.exit(0);

    }
}
