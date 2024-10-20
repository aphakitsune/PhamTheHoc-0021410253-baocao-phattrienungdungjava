package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(Integer id_nv) {
        return nhanVienRepository.findById(id_nv);
    }

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(Integer id_nv) {
        nhanVienRepository.deleteById(id_nv);
    }

    public List<NhanVien> findByKeyword(String keyword) {
        return nhanVienRepository.findByTenNVContainingIgnoreCase(keyword); // Tìm theo tên sản phẩm
    }
}
