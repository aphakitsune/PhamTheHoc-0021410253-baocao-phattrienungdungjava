package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVienService;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVien> getAllNhanVien() {
        return nhanVienService.getAllNhanVien();
    }

    @GetMapping("/{id_nv}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Integer id_nv) {
        return nhanVienService.getNhanVienById(id_nv)
                .map(nhanVien -> ResponseEntity.ok().body(nhanVien))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien savedNhanVien = nhanVienService.saveNhanVien(nhanVien);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNhanVien);
    }

    @PutMapping("/{id_nv}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Integer id_nv, @RequestBody NhanVien nhanVien) {
        if (!nhanVienService.getNhanVienById(id_nv).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        nhanVien.setId_nv(id_nv);
        NhanVien updatedNhanVien = nhanVienService.saveNhanVien(nhanVien);
        return ResponseEntity.ok(updatedNhanVien);
    }

    @DeleteMapping("/{id_nv}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Integer id_nv) {
        if (!nhanVienService.getNhanVienById(id_nv).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        nhanVienService.deleteNhanVien(id_nv);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ModelAndView searchProducts(@RequestParam(required = false) String keyword) {
        List<NhanVien> nhanviens;
        if (keyword != null && !keyword.isEmpty()) {
            nhanviens = nhanVienService.findByKeyword(keyword); // Tìm sản phẩm theo từ khóa
        } else {
            nhanviens = nhanVienService.getAllNhanVien(); // Nếu không có từ khóa, lấy tất cả sản phẩm
        }
        ModelAndView mav = new ModelAndView("nv-index");
        mav.addObject("nhanviens", nhanviens);
        return mav;
    }
}
