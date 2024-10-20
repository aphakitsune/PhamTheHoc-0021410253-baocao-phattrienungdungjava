package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> findAll(){
        return sanPhamRepository.findAll();
    }

    public Optional<SanPham> findById(Integer id_sp) {
        return sanPhamRepository.findById(id_sp);
    }

    public SanPham save(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public void deleteById(Integer  id_sp) {
        sanPhamRepository.deleteById(id_sp);
    }

    public List<SanPham> findByKeyword(String keyword) {
        return sanPhamRepository.findByTenSPContainingIgnoreCase(keyword); // Tìm theo tên sản phẩm
    }
}
