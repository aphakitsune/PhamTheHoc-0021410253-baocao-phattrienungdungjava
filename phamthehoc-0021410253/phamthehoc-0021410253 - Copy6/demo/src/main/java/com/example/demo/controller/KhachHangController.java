package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    // Lấy danh sách khách hàng
    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangService.findAll();
    }

    // Lấy khách hàng theo ID
    @GetMapping("/{id_kh}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable Integer id_kh) {
        KhachHang khachHang = khachHangService.findById(id_kh);
        if (khachHang != null) {
            return ResponseEntity.ok(khachHang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Thêm khách hàng mới
    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.save(khachHang);
    }

    // Cập nhật khách hàng
    @PutMapping("/{id_kh}")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable Integer id_kh, @RequestBody KhachHang khachHang) {
        khachHang.setId_kh(id_kh); // Đặt ID từ đường dẫn vào đối tượng
        KhachHang updatedKhachHang = khachHangService.update(khachHang);
        if (updatedKhachHang != null) {
            return ResponseEntity.ok(updatedKhachHang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa khách hàng
    @DeleteMapping("/{id_kh}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable Integer id_kh) {
        khachHangService.delete(id_kh);
        return ResponseEntity.noContent().build();
    }
}
