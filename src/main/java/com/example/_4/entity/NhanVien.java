package com.example._4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data

public class NhanVien {
    @Id
    private String Ma_NV;

    @Column(name = "Ten_NV")
    private String Ten_NV;

    @Column(name = "Phai")
    private String Phai;

    @Column(name = "Noi_Sinh")
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan Ten_Phong;

    @Column(name = "Luong")
    private int Luong;

}
