package com.airline.controller;

/*import com.airline.entity.Flight;
import com.airline.entity.Payment;*/
import com.airline.entity.Flight;
import com.airline.entity.Plane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.@Override;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class FlightFX implements Initializable{


    @Autowired
    PlaneController planeController;

    @Autowired
    FlightController flightController;

    @FXML
    private ComboBox<String> planeField;

    @FXML
    private TextField departureField;

    @FXML
    private TextField arrivalField;

    @FXML
    private TextField economyAdultField;

    @FXML
    private TextField BusinessAdultField;

    @FXML
    private TextField economyChildField;


    @FXML
    private TextField BusinessChildField;


    @FXML
    private DatePicker departureDateField;


    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    List<Plane> option;

    // ClassPathXmlApplicationContext context;

    @Override
    public void initialize(URL fxmlFieldLocation, ResourceBundle resourceBundle)
    {
        option=planeController.findAll();
        for (int i = 0; i < option.size(); i++) {
            System.out.println(option.get(i));
        }
        System.out.println();
        for (int i = 0; i < option.size(); i++) {
            planeField.getItems().add(option.get(i).getName());
        }
    }


    public void register(ActionEvent event) throws SQLException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //   context =
        //         new ClassPathXmlApplicationContext("/META-INF/spring/application-context.xml");
        Window owner = submitButton.getScene().getWindow();

        /*List<Plane> list=planeField.getValue().findAll();
        System.out.println(list);
        String Values=planeField.getValue().findAll();
        System.out.println(planeField.getValue().findAll());*/
      //  System.out.println(Values);
        System.out.println(planeField.getValue().toString());
        System.out.println(departureField.getText());
        System.out.println(arrivalField.getText());
        System.out.println(economyAdultField.getText());
        System.out.println(BusinessAdultField.getText());
        System.out.println(economyChildField.getText());
        System.out.println(BusinessChildField.getText());
       // System.out.println(planeIdField.getText());
        System.out.println(departureDateField.getValue().toString());
        if(departureField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter the Departure Time");
            return;
        }

        if(arrivalField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Arrival Time");
            return;
        }

        if(economyAdultField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Economy Adult Ticket Price");
            return;
        }

        if(BusinessAdultField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Business Adult Ticket Price");
            return;
        }

        if(economyChildField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Economy Child Ticket Price");
            return;
        }

        if(BusinessChildField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Business Child Ticket Price");
            return;
        }

        /*if(planeIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Plane Id");
            return;
        }
*/
        int SelectedPlaneId=0;
        String planeName=planeField.getValue().toString();
        for (int i = 0; i < option.size(); i++) {
            Plane p=option.get(i);
            if(p.getName().equals(planeName))
            {
                SelectedPlaneId=p.getId();
            }
        }

        String departure = departureField.getText().toString();
        String  arrival = arrivalField.getText().toString();
        String economyAPrice = economyAdultField.getText().toString();
        String  businessAPrice = BusinessAdultField.getText().toString();
        String economyCPrice = economyChildField.getText().toString();
        String  businessCPrice = BusinessChildField.getText().toString();
        LocalDate expiryDate = departureDateField.getValue();
        Flight flight = new Flight();
        flight.setDeparture(departure);
        flight.setArrival(arrival);
        flight.setEconomyAdultPrice(economyAPrice);
        flight.setBusinessAdultPrice(businessAPrice);
        flight.setEconomyChildPrice(economyCPrice);
        flight.setBusinessChildPrice(businessCPrice);
        java.util.Date dt=Date.from(expiryDate.atStartOfDay(defaultZoneId).toInstant());
        Date newDate=new Date(dt.getTime());
        flight.setDepartureDate(newDate);
        flight.setPlanePlane(SelectedPlaneId);
       // flight.setPlanePlane(plane);

        flightController.insertPayment(flight);


        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + departureField.getText());
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
        departureField.setText("");
       arrivalField.setText("");
       economyAdultField.setText("");
        BusinessAdultField.setText("");
        economyChildField.setText("");
        BusinessChildField.setText("");
     //   planeIdField.setText("");
    }

    public void cancel(ActionEvent actionEvent) {
        // context.close();
        System.exit(0);

    }
}
