package com.example._4.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3, nullable = false)
    private String maNV;

    @Column(name = "Ten_NV", length = 100, nullable = false)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @Column(name = "Luong")
    private Integer luong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String phai, String noiSinh, Integer luong, PhongBan phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.phai = phai;
        this.noiSinh = noiSinh;
        this.luong = luong;
        this.phongBan = phongBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        this.luong = luong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}
