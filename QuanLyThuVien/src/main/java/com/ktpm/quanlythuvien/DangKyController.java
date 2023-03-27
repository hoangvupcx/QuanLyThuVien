/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpm.quanlythuvien;

import com.ktpm.services.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Admin
 */
public class DangKyController {
   RadioButton rd1;
   RadioButton rd2;
   ToggleGroup group1;
   
   public void initialize() {
    group1 = new ToggleGroup();
    rd1.setToggleGroup(group1);
    rd2.setToggleGroup(group1);
   }
}
