package com.example._4.Controller;

import com.example._4.Services.NhanVienService;
import com.example._4.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String showAllNV(Model model){
        List<NhanVien> nhanVienList= nhanVienService.getAllNV();
        model.addAttribute("nhanviens", nhanVienList);
        return "nhanvien/list";
    }
}
