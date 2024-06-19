package com.example._4.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

public class PhongBan {
    @Id
    private String Ma_Phong;

    @OneToMany(mappedBy = "PhongBan", cascade = CascadeType.ALL)
    private List<NhanVien> NhanViens;

}
