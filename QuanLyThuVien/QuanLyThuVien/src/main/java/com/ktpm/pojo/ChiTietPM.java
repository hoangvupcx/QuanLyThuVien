/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpm.pojo;

import java.util.Date;

/**
 *
 * @author THANH NHAN
 */
public class ChiTietPM {
    private int id;
    private int id_sach;
    private int id_pm;

    
    public ChiTietPM(int id_sach,int id_pm)
    {
        this.id_sach=id_sach;
        this.id_pm=id_pm;
 
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_sach
     */
    public int getId_sach() {
        return id_sach;
    }

    /**
     * @param id_sach the id_sach to set
     */
    public void setId_sach(int id_sach) {
        this.id_sach = id_sach;
    }

    /**
     * @return the id_pm
     */
    public int getId_pm() {
        return id_pm;
    }

    /**
     * @param id_pm the id_pm to set
     */
    public void setId_pm(int id_pm) {
        this.id_pm = id_pm;
    }

}
