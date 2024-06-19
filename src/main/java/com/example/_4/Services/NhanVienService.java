package com.example._4.Services;

import com.example._4.Repository.INhanVienRepository;
import com.example._4.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNV(){
        return nhanVienRepository.findAll();
    }

    public void addNV(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNV(String id){
        nhanVienRepository.deleteById(id);
    }
    public NhanVien getNVById(String id) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(id);
        return optionalNhanVien.orElse(null);
    }

    public void updateNV(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }
}
