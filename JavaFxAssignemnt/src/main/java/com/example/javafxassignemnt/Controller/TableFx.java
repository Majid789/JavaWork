package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.Address;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class TableFx implements Initializable {

    ObservableList<FetchData> fetchData= FXCollections.observableArrayList();

    @Autowired
    AddressController addressController;

    @Autowired
    private ApplicationContext applicationContext;

    @FXML
    private TableView<FetchData> tableview;

    @FXML
    private TableColumn<FetchData,Long> columnId;

    @FXML
    private TableColumn<FetchData,String> columnName;

    @FXML
    private TableColumn<FetchData,String> columnEmail;

    @FXML
    private TableColumn<FetchData,String> columnPhone;

    @FXML
    private TableColumn<FetchData,String> columnHouse;

    @FXML
    private TableColumn<FetchData,String> columnTown;

    @FXML
    private TableColumn<FetchData,String > columnCity;

    @FXML
    private TableColumn<FetchData,String> columnState;

    @FXML
    private TableColumn<FetchData,String> columnCountry;


    List<Address> tableview1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableview1= addressController.findAll();
        ColumnData();
        TableData();


    }

    public void showUserWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/User_View.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void ColumnData()
    {
        columnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        columnHouse.setCellValueFactory(new PropertyValueFactory<>("HouseNo"));
        columnTown.setCellValueFactory(new PropertyValueFactory<>("Town"));
        columnCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        columnState.setCellValueFactory(new PropertyValueFactory<>("State"));
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
    }

    public void TableData()
    {
        tableview.getItems().removeAll(fetchData);
        fetchData.removeAll(fetchData);
        ColumnData();
        tableview1= addressController.findAll();
        for (int i = 0; i < tableview1.size(); i++) {

            FetchData record=new FetchData(tableview1.get(i).getUsers().getId(),tableview1.get(i).getUsers().getName(),tableview1.get(i).getUsers().getEmail(),tableview1.get(i).getUsers().getPhone(),
                    tableview1.get(i).getAddress(),tableview1.get(i).getTownTown().getName(),tableview1.get(i).getTownTown().getCityCity().getName(),tableview1.get(i).getTownTown().getCityCity().getStateState().getName(),
                    tableview1.get(i).getTownTown().getCityCity().getStateState().getCountryCountry().getName());
            System.out.println(record);

            fetchData.add(new FetchData(tableview1.get(i).getUsers().getId(),tableview1.get(i).getUsers().getName(),tableview1.get(i).getUsers().getEmail(),tableview1.get(i).getUsers().getPhone(),
                    tableview1.get(i).getAddress(),tableview1.get(i).getTownTown().getName(),tableview1.get(i).getTownTown().getCityCity().getName(),tableview1.get(i).getTownTown().getCityCity().getStateState().getName(),
                    tableview1.get(i).getTownTown().getCityCity().getStateState().getCountryCountry().getName()));
        }
        tableview.getItems().addAll(fetchData);
    }

    public static class FetchData
    {
        private final Long Id;
        private final String Name;
        private final String Email;
        private final String PhoneNo;
        private final String HouseNo;
        private final String Town;
        private final String City;
        private final String State;
        private final String Country;
        private FetchData(Long id, String name, String email, String phoneNo, String houseNo, String town, String city, String state, String country) {
            Id = id;
            Name = name;
            Email = email;
            PhoneNo = phoneNo;
            HouseNo = houseNo;
            Town = town;
            City = city;
            State = state;
            Country = country;
        }

        public Long getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public String getEmail() {
            return Email;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public String getHouseNo() {
            return HouseNo;
        }

        public String getTown() {
            return Town;
        }

        public String getCity() {
            return City;
        }

        public String getState() {
            return State;
        }

        public String getCountry() {
            return Country;
        }
    }
    public void cancel(ActionEvent actionEvent) {
        System.exit(0);

    }

}
