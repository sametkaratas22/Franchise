package com.example.franchise.service;

import com.example.franchise.entity.Franchise;
import com.example.franchise.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    @Autowired
    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Franchise create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }
}
