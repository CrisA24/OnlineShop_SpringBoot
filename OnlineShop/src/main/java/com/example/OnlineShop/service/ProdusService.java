package com.example.OnlineShop.service;

import com.example.OnlineShop.model.Produs;
import com.example.OnlineShop.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    public Produs getProdusById(Long id) {
        return produsRepository.findById(id).orElse(null);
    }

    public Produs adaugaProdus(Produs produs) {
        return produsRepository.save(produs);
    }

    public Produs updateStoc(Long id, int cantitate) throws Exception {
        Produs produs = produsRepository.findById(id).orElseThrow(() -> new Exception("Produsul nu a fost găsit"));
        produs.setStoc(produs.getStoc() + cantitate);
        return produsRepository.save(produs);
    }

    public void deleteProdus(Long id) {
        produsRepository.deleteById(id);
    }
}
