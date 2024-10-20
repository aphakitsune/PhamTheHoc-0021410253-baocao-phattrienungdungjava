package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_kh;

    @Column(name = "id_tk")
    private Integer id_tk;
    

    @Column(name = "anhdaidien_kh")
    private String anhDD_KH;

    @Column(name = "hovaten_kh")
    private String hoVaTen_KH;

    @Column(name = "sdt_kh")
    private String sdt_KH;

    @Column(name = "dc_kh")
    private String dC_KH;

    @Column(name = "email_kh")
    private String email_KH;

// Constructor
    public KhachHang(){}
    public KhachHang(Integer id_kh, Integer id_tk, String anhDD_KH, String hoVaTen_KH, String sdt_KH, String dC_KH,
    String email_KH) {
        this.id_kh = id_kh;
        this.id_tk = id_tk;
        this.anhDD_KH = anhDD_KH;
        this.hoVaTen_KH = hoVaTen_KH;
        this.sdt_KH = sdt_KH;
        this.dC_KH = dC_KH;
        this.email_KH = email_KH;
    }
//Getter and Setter
    public Integer getId_kh() {
        return id_kh;
    }
    public void setId_kh(Integer id_kh) {
        this.id_kh = id_kh;
    }
    public Integer getId_tk() {
        return id_tk;
    }
    public void setId_tk(Integer id_tk) {
        this.id_tk = id_tk;
    }
    public String getAnhDD_KH() {
        return anhDD_KH;
    }
    public void setAnhDD_KH(String anhDD_KH) {
        this.anhDD_KH = anhDD_KH;
    }
    public String getHoVaTen_KH() {
        return hoVaTen_KH;
    }
    public void setHoVaTen_KH(String hoVaTen_KH) {
        this.hoVaTen_KH = hoVaTen_KH;
    }
    public String getSdt_KH() {
        return sdt_KH;
    }
    public void setSdt_KH(String sdt_KH) {
        this.sdt_KH = sdt_KH;
    }
    public String getdC_KH() {
        return dC_KH;
    }
    public void setdC_KH(String dC_KH) {
        this.dC_KH = dC_KH;
    }
    public String getEmail_KH() {
        return email_KH;
    }
    public void setEmail_KH(String email_KH) {
        this.email_KH = email_KH;
    }
    

}
