package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nv;

    @Column(name = "ten_nv")
    private String tenNV;

    @Column(name = "vaitro_nv")
    private String vaiTroNV;

    @Column(name = "diachi_nv")
    private String diaChiNV;

    @Column(name = "email_nv")
    private String emailNV;

    @Column(name = "sdt_nv")
    private String sdtNV;

    @Column(name = "ngaytuyendung_nv")
    private LocalDate ntdNV;

    // constructor
    public NhanVien(){}
    public NhanVien(Integer id_nv, String tenNV, String vaiTroNV, String diaChiNV, String emailNV, String sdtNV,
            LocalDate ntdNV) {
        this.id_nv = id_nv;
        this.tenNV = tenNV;
        this.vaiTroNV = vaiTroNV;
        this.diaChiNV = diaChiNV;
        this.emailNV = emailNV;
        this.sdtNV = sdtNV;
        this.ntdNV = ntdNV;
    }

    // getter and setter
    public Integer getId_nv() {
        return id_nv;
    }

    public void setId_nv(Integer id_nv) {
        this.id_nv = id_nv;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getVaiTroNV() {
        return vaiTroNV;
    }

    public void setVaiTroNV(String vaiTroNV) {
        this.vaiTroNV = vaiTroNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public LocalDate getNtdNV() {
        return ntdNV;
    }

    public void setNtdNV(LocalDate ntdNV) {
        this.ntdNV = ntdNV;
    }
   

}
