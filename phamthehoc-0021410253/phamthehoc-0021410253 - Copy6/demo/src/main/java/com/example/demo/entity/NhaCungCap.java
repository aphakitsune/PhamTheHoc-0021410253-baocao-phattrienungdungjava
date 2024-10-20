package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ncc;

    @Column(name = "ten_ncc")
    private String tenNCC;

    @Column(name = "loaisp")
    private String loaiSP;

    @Column(name = "diachi_ncc")
    private String diaChiNCC;

    @Column(name = "email_ncc")
    private String emailNCC;

    @Column(name = "sdt_ncc")
    private String sdtNCC;
// Constructor
    public NhaCungCap(){}
    public NhaCungCap(Integer id_ncc, String tenNCC, String loaiSP, String diaChiNCC, String emailNCC, String sdtNCC) {
        this.id_ncc = id_ncc;
        this.tenNCC = tenNCC;
        this.loaiSP = loaiSP;
        this.diaChiNCC = diaChiNCC;
        this.emailNCC = emailNCC;
        this.sdtNCC = sdtNCC;
    }

//Getter and Setter
    public Integer getId_ncc() {
        return id_ncc;
    }
    public void setId_ncc(Integer id_ncc) {
        this.id_ncc = id_ncc;
    }
    public String getTenNCC() {
        return tenNCC;
    }
    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    public String getLoaiSP() {
        return loaiSP;
    }
    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }
    public String getDiaChiNCC() {
        return diaChiNCC;
    }
    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }
    public String getEmailNCC() {
        return emailNCC;
    }
    public void setEmailNCC(String emailNCC) {
        this.emailNCC = emailNCC;
    }
    public String getSdtNCC() {
        return sdtNCC;
    }
    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }



    
}
