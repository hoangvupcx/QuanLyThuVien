/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpm.quanlythuvien;

import com.ktpm.pojo.BoPhan;
import com.ktpm.pojo.DoiTuong;
import com.ktpm.pojo.User;
import com.ktpm.services.BoPhanService;
import com.ktpm.services.DoiTuongService;
import com.ktpm.services.UserService;
import com.ktpm.utils.MessageBox;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import static javafx.scene.control.ButtonType.YES;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 *
 * @author THANH NHAN
 */
public class DangKyController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField cfpassword;
    @FXML
    private TextField email;
    @FXML
    private TextField sdt;
    @FXML
    private TextField name;
    @FXML
    private TextField diachi;
    @FXML
    private ComboBox<BoPhan> cbBoPhan;
    @FXML
    private ComboBox<DoiTuong> cbDoituong;
    @FXML
    private DatePicker ngaysinh;
    @FXML
    private RadioButton rd1;
    @FXML
    private RadioButton rd2;
    ToggleGroup group1;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group1 = new ToggleGroup();
        rd1.setUserData("Nam");
        rd1.setToggleGroup(group1);
        rd2.setUserData("Nữ");
        rd2.setToggleGroup(group1);
        loadBP();
        loadDT();
    }

    public void loadBP() {
        BoPhanService b = new BoPhanService();
        try {
            this.cbBoPhan.setItems(FXCollections.observableList(b.getBoPhan()));
            cbBoPhan.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDT() {
        DoiTuongService d = new DoiTuongService();
        try {
            this.cbDoituong.setItems(FXCollections.observableList(d.getDoiTuong()));
            cbDoituong.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUsers(ActionEvent evt) throws SQLException, IOException, NoSuchAlgorithmException {
         
        Date date = Date.valueOf(this.ngaysinh.getValue());
        if (this.password.getText().equals(this.cfpassword.getText())) {
            User u = new User(this.username.getText(), this.password.getText(), this.name.getText(),group1.getSelectedToggle().getUserData().toString(),date, this.email.getText(), this.diachi.getText(), this.sdt.getText(), this.cbBoPhan.getSelectionModel().getSelectedItem().getMaBP(), this.cbDoituong.getSelectionModel().getSelectedItem().getMaDT());
            UserService user = new UserService();
            try {
                if (user.addUser(u)) {
                    clearForm();
                    MessageBox.getBox("Thông báo", "Bạn đã đăng ký tài khoản thành công!!!", Alert.AlertType.INFORMATION).show();

                }
            } catch (SQLException ex) {
                MessageBox.getBox("Thông báo", "Đăng ký tài khoản thất bại!!!", Alert.AlertType.ERROR).show();
                Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void thoat(ActionEvent evt) throws IOException
    {  
       Optional<ButtonType> result= MessageBox.getBox1("Question", "Add question failed", Alert.AlertType.INFORMATION).showAndWait();
       if (result.get()==ButtonType.YES)
       {
           App.setRoot("DangNhap");
       } else {
                   
        }  
    }
    
    public void clearForm()
    {
        this.username.clear();
        this.password.clear();
        this.cfpassword.clear();
        this.email.clear();
        cbBoPhan.getSelectionModel().selectFirst();
        cbDoituong.getSelectionModel().selectFirst();
        this.group1.setUserData(null);
        this.name.clear();
        this.ngaysinh.setValue(null);
        this.sdt.clear();
        this.diachi.clear();
    }
}
