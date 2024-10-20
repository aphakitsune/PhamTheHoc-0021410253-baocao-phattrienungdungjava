package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sp;

    @Column(name = "hinhanh")
    private String hinhAnh;

    @Column(name = "ten_sp")
    private String tenSP;

    @Column(name = "mausac_sp")
    private String mauSacSP;

    @Column(name = "loai_sp")
    private String loaiSP;

    @Column(name = "id_ncc")
    private Integer idNCC;

    @Column(name = "soluong_sp")
    private Integer soLuongSP;

    @Column(name = "giamd_sp")
    private Double giaMDSP;

    @Column(name = "giakm_sp")
    private Double giaKMSP;

    @Column(name = "hoantra_sp")
    private String hoanTraSP;

    @Column(name = "dvvanchuyen_sp")
    private String dVVCSP;

    // Constructors
    public SanPham() {}

    public SanPham(Integer id_sp, String hinhAnh, String tenSP, String mauSacSP, String loaiSP, Integer idNCC, Integer soLuongSP, Double giaMDSP, Double giaKMSP, String hoanTraSP, String dVVCSP) {
        this.id_sp = id_sp;
        this.hinhAnh = hinhAnh;
        this.tenSP = tenSP;
        this.mauSacSP = mauSacSP;
        this.loaiSP = loaiSP;
        this.idNCC = idNCC;
        this.soLuongSP = soLuongSP;
        this.giaMDSP = giaMDSP;
        this.giaKMSP = giaKMSP;
        this.hoanTraSP = hoanTraSP;
        this.dVVCSP = dVVCSP;
    }

    // Getters and Setters


    public Integer getId_sp() {
        return id_sp;
    }

    public void setId_sp(Integer id_sp) {
        this.id_sp = id_sp;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSacSP() {
        return mauSacSP;
    }

    public void setMauSacSP(String mauSacSP) {
        this.mauSacSP = mauSacSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public Integer getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(Integer idNCC) {
        this.idNCC = idNCC;
    }

    public Integer getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(Integer soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public Double getGiaMDSP() {
        return giaMDSP;
    }

    public void setGiaMDSP(Double giaMDSP) {
        this.giaMDSP = giaMDSP;
    }

    public Double getGiaKMSP() {
        return giaKMSP;
    }

    public void setGiaKMSP(Double giaKMSP) {
        this.giaKMSP = giaKMSP;
    }

    public String getHoanTraSP() {
        return hoanTraSP;
    }

    public void setHoanTraSP(String hoanTraSP) {
        this.hoanTraSP = hoanTraSP;
    }

    public String getdVVCSP() {
        return dVVCSP;
    }

    public void setdVVCSP(String dVVCSP) {
        this.dVVCSP = dVVCSP;
    }
}
