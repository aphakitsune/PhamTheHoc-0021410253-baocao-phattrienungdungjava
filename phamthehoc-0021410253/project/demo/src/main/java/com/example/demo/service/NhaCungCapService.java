package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.repository.NhaCungCapRepository;

@Service
public class NhaCungCapService {

    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    public List<NhaCungCap> getAllNhaCungCap() {
        return nhaCungCapRepository.findAll();
    }

    public NhaCungCap createNhaCungCap(NhaCungCap nhaCungCap) {
        return nhaCungCapRepository.save(nhaCungCap);
    }

    public Optional<NhaCungCap> updateNhaCungCap(Integer id, NhaCungCap nhaCungCap) {
        if (!nhaCungCapRepository.existsById(id)) {
            return Optional.empty();
        }
        nhaCungCap.setId_ncc(id);
        return Optional.of(nhaCungCapRepository.save(nhaCungCap));
    }

    public boolean deleteNhaCungCap(Integer id) {
        if (!nhaCungCapRepository.existsById(id)) {
            return false;
        }
        nhaCungCapRepository.deleteById(id);
        return true;
    }

    public Optional<NhaCungCap> getNhaCungCapById(Integer id) {
        return nhaCungCapRepository.findById(id);
    }
}
