package com.airline.controller;

//import com.airline.entity.Plane;
import com.airline.entity.Plane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PlaneFX {


    @Autowired
    PlaneController planeController;

    @FXML
    private TextField planeNameField;

    @FXML
    private TextField seatsField;


    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

   // ClassPathXmlApplicationContext context;

    public void register(ActionEvent event) throws SQLException {
     //   context =
       //         new ClassPathXmlApplicationContext("/META-INF/spring/application-context.xml");
        Window owner = submitButton.getScene().getWindow();

        System.out.println(planeNameField.getText());
        System.out.println(seatsField.getText());
        if(planeNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            return;
        }

        if(seatsField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }


        String planeName = planeNameField.getText();
        Integer seats = Integer.parseInt(seatsField.getText());

        Plane plane = new Plane();
        plane.setName(planeName);
        plane.setSeats(seats);
        planeController.insertPlane(plane);


        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + planeNameField.getText());
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
        planeNameField.setText("");
        seatsField.setText("");
    }

    public void cancel(ActionEvent actionEvent) {
       // context.close();
        System.exit(0);

    }
}
