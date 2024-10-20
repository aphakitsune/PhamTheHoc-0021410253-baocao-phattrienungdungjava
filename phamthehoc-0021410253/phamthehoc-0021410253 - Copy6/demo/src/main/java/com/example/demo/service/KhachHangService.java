package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
    

    public KhachHang findById(Integer id_kh) {
        return khachHangRepository.findById(id_kh).orElse(null); // Có thể ném ngoại lệ ở đây nếu cần
    }

    public KhachHang save(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    public KhachHang update(KhachHang khachHang) {
        // Kiểm tra xem đối tượng có tồn tại không
        Optional<KhachHang> existingKhachHang = khachHangRepository.findById(khachHang.getId_kh());
        if (existingKhachHang.isPresent()) {
            return khachHangRepository.save(khachHang);
        }
        return null; // Hoặc ném ngoại lệ
    }

    public void delete(Integer id_kh) {
        khachHangRepository.deleteById(id_kh);
    }    
}
