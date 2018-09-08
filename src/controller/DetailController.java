package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DetailController {

    @FXML private TextField usrName;
    @FXML private TextField pwd;

    @FXML
    public void getShow(String usr, String pwd){
        usrName.setText(usr);
        this.pwd.setText(pwd);
    }

}
