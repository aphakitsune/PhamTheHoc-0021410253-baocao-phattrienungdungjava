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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.service.NhaCungCapService;

@RestController
@RequestMapping("/api/nhacungcap")
public class NhaCungCapController {

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping
    public List<NhaCungCap> getAllNhaCungCap() {
        return nhaCungCapService.getAllNhaCungCap();
    }

    @PostMapping
    public ResponseEntity<NhaCungCap> createNhaCungCap(@RequestBody NhaCungCap nhaCungCap) {
        NhaCungCap savedNhaCungCap = nhaCungCapService.createNhaCungCap(nhaCungCap);
        return new ResponseEntity<>(savedNhaCungCap, HttpStatus.CREATED);
    }

    @PutMapping("/{id_ncc}")
    public ResponseEntity<NhaCungCap> updateNhaCungCap(@PathVariable Integer id_ncc, @RequestBody NhaCungCap nhaCungCap) {
        return nhaCungCapService.updateNhaCungCap(id_ncc, nhaCungCap)
                .map(updatedNhaCungCap -> new ResponseEntity<>(updatedNhaCungCap, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id_ncc}")
    public ResponseEntity<Void> deleteNhaCungCap(@PathVariable Integer id_ncc) {
        if (!nhaCungCapService.deleteNhaCungCap(id_ncc)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id_ncc}")
    public ResponseEntity<NhaCungCap> getNhaCungCapById(@PathVariable Integer id_ncc) {
        return nhaCungCapService.getNhaCungCapById(id_ncc)
                .map(nhaCungCap -> new ResponseEntity<>(nhaCungCap, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
