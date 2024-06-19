package com.example._4.entity;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PHONGBAN")
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2, nullable = false)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 30, nullable = false)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NhanVien> nhanViens = new HashSet<>();

    public PhongBan() {
    }

    public PhongBan(String maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}