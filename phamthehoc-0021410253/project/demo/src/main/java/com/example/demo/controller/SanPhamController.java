package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;

@Controller
@RequestMapping("/sanphams")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    // @GetMapping
    // public ModelAndView getAllSPs() {
    //     ModelAndView modelAndView = new ModelAndView("sp-index");
    //     modelAndView.addObject("sanphams", sanPhamService.findAll());
    //     return modelAndView;
    // }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable Integer id, ModelAndView modelAndView) {
        Optional<SanPham> sanPham = sanPhamService.findById(id);
        sanPham.ifPresent(value -> modelAndView.addObject("sanpham", value));
        return sanPham.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public String createSanPham(@ModelAttribute SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/sanphams";
    }
    

    @PutMapping("/update/{id_sp}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable Integer id_sp, @RequestBody SanPham sanPham) {
        if (sanPhamService.findById(id_sp).isPresent()) {
            sanPham.setId_sp(id_sp);
            sanPhamService.save(sanPham);
            return ResponseEntity.ok(sanPham);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id_sp}")
    public String deleteSanPham(@PathVariable Integer id_sp) {
        sanPhamService.deleteById(id_sp);
        return "redirect:/sanphams";
    }

    @GetMapping("/update/{id_sp}")
    public ModelAndView showUpdateProductForm(@PathVariable Integer id_sp) {
        Optional<SanPham> sanpham = sanPhamService.findById(id_sp);
        ModelAndView mav = new ModelAndView("edit-sp");
        mav.addObject("sanpham", sanpham.orElse(new SanPham())); // Nếu không tìm thấy sản phẩm, trả về một đối tượng mới
        return mav;
    }
    
    @PostMapping("/update/{id_sp}")
    public String updateProduct(@PathVariable Integer id_sp, @ModelAttribute SanPham sanpham) {
        sanpham.setId_sp(id_sp); // Thiết lập ID cho sản phẩm
        sanPhamService.save(sanpham); // Lưu sản phẩm đã sửa
        return "redirect:/sanphams/sp-index"; // Chuyển hướng về trang danh sách sản phẩm
    }
    
    @GetMapping("/delete/{id_sp}")
    public String deleteProduct(@PathVariable Integer id_sp) {
        sanPhamService.deleteById(id_sp); // Gọi dịch vụ để xóa sản phẩm theo ID
        return "redirect:/sanphams/sp-index"; // Chuyển hướng về trang danh sách sản phẩm
    }
    
    @GetMapping("/search")
    public ModelAndView searchProducts(@RequestParam(required = false) String keyword) {
        List<SanPham> sanphams;
        if (keyword != null && !keyword.isEmpty()) {
            sanphams = sanPhamService.findByKeyword(keyword); // Tìm sản phẩm theo từ khóa
        } else {
            sanphams = sanPhamService.findAll(); // Nếu không có từ khóa, lấy tất cả sản phẩm
        }
        ModelAndView mav = new ModelAndView("sp-index");
        mav.addObject("sanphams", sanphams);
        return mav;
    }
}
