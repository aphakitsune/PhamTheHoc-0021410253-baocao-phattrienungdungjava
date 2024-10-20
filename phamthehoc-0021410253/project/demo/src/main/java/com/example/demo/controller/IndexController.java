package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.NhaCungCapService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.SanPhamService;

@Controller
public class IndexController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/sanphams")
    public ModelAndView getAllSPs() {
        ModelAndView modelAndView = new ModelAndView("sp-index");
        List<SanPham> sanphams = sanPhamService.findAll();
        modelAndView.addObject("sanphams", sanphams);
        return modelAndView;
    }

    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping("/nhanviens")
    public ModelAndView getAllNVs() {
        ModelAndView modelAndView = new ModelAndView("nv-index");
        List<NhanVien> nhanviens = nhanVienService.getAllNhanVien();  // Đổi tên phương thức cho đúng
        modelAndView.addObject("nhanviens", nhanviens);
        return modelAndView;
    }

    

    // @GetMapping("/hienthis")
    // public ModelAndView getAll() {
    //     ModelAndView modelAndView = new ModelAndView("index");
    //     List<SanPham> sanphams = sanPhamService.findAll();
    //     List<NhanVien> nhanviens = nhanVienService.getAllNhanVien();  // Đổi tên phương thức cho đúng
    //     modelAndView.addObject("sanphams", sanphams);
    //     modelAndView.addObject("nhanviens", nhanviens);
    //     return modelAndView;
    // }


    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khachhangs")
    public ModelAndView getAllKHs() {
        ModelAndView modelAndView = new ModelAndView("kh-index");
        List<KhachHang> khachhangs = khachHangService.findAll();
        modelAndView.addObject("khachhangs", khachhangs);
        return modelAndView;
    }

    @Autowired
    private NhaCungCapService nhaCungCapService;
    @GetMapping("/nhacungcaps")
    public ModelAndView getAllNCCs() {
        ModelAndView modelAndView = new ModelAndView("ncc-index");
        List<NhaCungCap> nhacungcaps = nhaCungCapService.getAllNhaCungCap();
        modelAndView.addObject("nhacungcaps", nhacungcaps);
        return modelAndView;
    }
    

}
