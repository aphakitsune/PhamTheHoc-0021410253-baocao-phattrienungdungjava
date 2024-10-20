package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh nếu cần
    List<SanPham> findByTenSPContainingIgnoreCase(String tenSP); // Tìm theo tên sản phẩm

}

