package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class AddressFx implements Initializable {

    @Autowired
    TableFx tableFx;

    @Autowired
    UserController userController;

    @Autowired
    AddressController addressController;

    @Autowired
    CountryController countryController;

    @Autowired
    StateController stateController;

    @Autowired
    CityController cityController;

    @Autowired
    TownController townController;

    @FXML
    private ComboBox<String> NameField;

    @FXML
    private ComboBox<String> countryField;

    @FXML
    private ComboBox<String> stateField;

    @FXML
    private ComboBox<String> cityField;

    @FXML
    private ComboBox<String> townField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField latField;

    @FXML
    private TextField longField;

    @FXML
    private TextField apartField;

    @FXML
    private TextField floorField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    List<Country> country;

    List<State> state;

    List<City> city;

    List<Town> town;

    List<User> user;
    String SelectCountry;
    String SelectState;
    String SelectCity;
    String SelectTown;
    String Name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user=userController.findAll();
        country=countryController.findAll();
        state=stateController.findAll();
        city=cityController.findAll();
        town=townController.findAll();
        for (int i=0;i<country.size();i++)
        {
            System.out.println(country.get(i));
        }
        for (int i=0;i<country.size();i++)
        {
            countryField.getItems().add(country.get(i).getName());
        }
        for (int i=0;i<user.size();i++)
        {
            NameField.getItems().add(user.get(i).getName());
        }
    }

    public void State()
    {
        if(countryField.getValue()!=null)
        {
            SelectCountry=countryField.getValue();
            for (int i=0;i<state.size();i++)
            {
                stateField.getItems().add(state.get(i).getName());
            }
        }
        if(countryField.getItems()!=null)
        {
            stateField.getItems().clear();
            for (int i=0;i<state.size();i++)
            {
                if(state.get(i).getCountryCountry().getName().equals(SelectCountry))
                {
                    stateField.getItems().add(state.get(i).getName());
                }

            }
        }
        if(stateField.getValue()!=null)
        {
            SelectState=stateField.getValue().toString();
        }

    }
    public void City() {

        if (stateField.getValue() != null) {
            SelectState = stateField.getValue();
        }
        if(stateField.getItems()!=null)
        {
            cityField.getItems().clear();
            /*String SN = stateField.getValue();
            stateField.getItems().clear();*/
            for (int i = 0; i < city.size(); i++) {
                if (city.get(i).getStateState().getName().equals(SelectState)) {
                    cityField.getItems().add(city.get(i).getName());
                }
            }
        }
        if(cityField.getValue()!=null)
        {
            SelectCity=cityField.getValue();
        }
    }
    public void Town()
    {
        if(cityField.getValue()!=null)
        {
            SelectCity=cityField.getValue();
        }
        if(cityField.getItems()!=null)
        {
            townField.getItems().clear();
            for (int i = 0; i < town.size(); i++) {
                if(town.get(i).getCityCity().getName().equals(SelectCity))
                {
                    townField.getItems().add(town.get(i).getName());
                }
            }
        }
        if(townField.getValue()!=null)
        {
            SelectTown=townField.getValue();
        }
    }

   public void register(ActionEvent event) throws SQLException
   {
       ZoneId defaultZoneId=ZoneId.systemDefault();
      Window owner=submitButton.getScene().getWindow();

       String A=addressField.getText() + townField.getValue() + cityField.getValue() + stateField.getValue() + countryField.getValue();
       String Lat=latField.getText();
       String Long=longField.getText();
       String Apart=apartField.getText();
       String Floor=floorField.getText();
       String Name=NameField.getValue();

       Address address=new Address();
       address.setAddress(A);
       address.setLat(Lat);
       address.setLng(Long);
       address.setApartment(Apart);
       address.setFloor(Floor);
       address.setUsers(userController.findClassIDbyClass(Name));
       address.setTownTown(townController.findClassIDbyClass(townField.getValue()));

       addressController.insertAddress(address);

       showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
               "Welcome " + addressField.getText());

       clearField();
       tableFx.TableData();
       Stage stage= (Stage) submitButton.getScene().getWindow();
       stage.close();
   }

    private void showAlert(Alert.AlertType confirmation, Window owner, String s, String s1) {
        Alert alert = new Alert(confirmation);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(s1);
        alert.initOwner(owner);
        alert.show();
    }

    private void clearField()
    {
        addressField.setText("");
        latField.setText("");
        longField.setText("");
        apartField.setText("");
        floorField.setText("");
    }


    public void cancel(ActionEvent actionEvent) {
        //owner.onCloseRequestProperty();
        //System.exit(0);
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

}
