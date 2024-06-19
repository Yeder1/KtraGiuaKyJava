package com.example._4.Controller;

import com.example._4.Services.NhanVienService;
import com.example._4.entity.NhanVien;
import com.example._4.entity.PhongBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String showAllNV(Model model){
        List<NhanVien> nhanVienList = nhanVienService.getAllNV();
        model.addAttribute("nhanviens", nhanVienList);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        String sql = "SELECT Ma_Phong, Ten_Phong FROM PHONGBAN";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<PhongBan> phongBanList = convertRowsToPhongBanList(rows);
        model.addAttribute("phongbans", phongBanList);
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNV(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.addNV(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteNV(@PathVariable("id") String id){
        nhanVienService.deleteNV(id);
        return "redirect:/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model){
        NhanVien nhanVien = nhanVienService.getNVById(id);
        model.addAttribute("nhanvien", nhanVien);
        String sql = "SELECT Ma_Phong, Ten_Phong FROM PHONGBAN";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<PhongBan> phongBanList = convertRowsToPhongBanList(rows);
        model.addAttribute("phongbans", phongBanList);
        return "nhanvien/edit";
    }

    private List<PhongBan> convertRowsToPhongBanList(List<Map<String, Object>> rows) {
        List<PhongBan> phongBanList = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            PhongBan phongBan = new PhongBan();
            phongBan.setMaPhong((String) row.get("Ma_Phong"));
            phongBan.setTenPhong((String) row.get("Ten_Phong"));
            phongBanList.add(phongBan);
        }
        return phongBanList;
    }

    @PostMapping("/update/{id}")
    public String updateNV(@PathVariable("id") String id, @ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.updateNV(nhanVien);
        return "redirect:/nhanvien";
    }
}
