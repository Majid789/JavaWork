package com.airline.controller;

/*import com.airline.entity.Payment;
import com.airline.entity.Plane;*/
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
public class PaymentFX {


    /*@Autowired
    PaymentController paymentController;*/

    @FXML
    private TextField paymentMethodField;

    @FXML
    private TextField creditCardNoField;

    @FXML
    private DatePicker expiryDateField;

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

        System.out.println(paymentMethodField.getText());
        System.out.println(creditCardNoField.getText());
        System.out.println(expiryDateField.getValue().toString());
        if(paymentMethodField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Payment Method");
            return;
        }

        if(creditCardNoField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Credit Card No");
            return;
        }
        if(expiryDateField.getValue().isEqual(null)) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Expiry Date");
            return;
        }

        String paymentMethod = paymentMethodField.getText().toString();
        String  creditCardNo = creditCardNoField.getText().toString();
        LocalDate expiryDate = expiryDateField.getValue();
        //productController = new ProductController();
        /*Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setCreditCardNumber(creditCardNo);
        java.util.Date dt = Date.from(expiryDate.atStartOfDay(defaultZoneId).toInstant());
        java.sql.Date newDate = new java.sql.Date(dt.getTime());
        payment.setExpiryDate(newDate);

        paymentController.insertPayment(payment);
*/

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + paymentMethodField.getText());
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
        paymentMethodField.setText("");
        creditCardNoField.setText("");
    }

    public void cancel(ActionEvent actionEvent) {
        // context.close();
        System.exit(0);

    }
}
