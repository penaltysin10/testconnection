package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MyConnectionClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML private Button login;
    @FXML private Hyperlink register;
    @FXML private TextField usrName;
    @FXML private  TextField pwd;

//    private MyConnectionClass myConnection;
    private Connection connection;
//
//    @FXML
//    public void initialize(){
//        myConnection = new MyConnectionClass();
//        connection = myConnection.getConnectionClass();
//    }

    @FXML
    public void handleLoginBtnAction(ActionEvent actionEvent) throws Exception{
        connection = MyConnectionClass.getConnectionClass();

        String sql = "SELECT `username`, `password` FROM `user_info` WHERE `username` =" +
                    usrName.getText() + "AND `password` =" + pwd.getText();
        ResultSet result = connection.prepareStatement(sql).executeQuery();
        if (result.next()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/showdetail.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage) login.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            DetailController detailController = (DetailController) loader.getController();
            detailController.getShow(usrName.getText(), pwd.getText());
            stage.show();

        }

    }
}
