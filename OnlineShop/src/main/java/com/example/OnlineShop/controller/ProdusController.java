package com.example.OnlineShop.controller;

import com.example.OnlineShop.model.Produs;
import com.example.OnlineShop.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    @GetMapping
    public List<Produs> getAllProduse() {
        return produsService.getAllProduse();
    }

    @GetMapping("/{id}")
    public Produs getProdusById(@PathVariable Long id) {
        return produsService.getProdusById(id);
    }

    @PostMapping
    public Produs adaugaProdus(@RequestBody Produs produs) {
        return produsService.adaugaProdus(produs);
    }

    @PutMapping("/update-stoc/{id}")
    public String updateStoc(@PathVariable Long id, @RequestParam int cantitate) {
        try {
            produsService.updateStoc(id, cantitate);
            return "Stoc actualizat cu succes!";
        } catch (Exception e) {
            return "Eroare la actualizarea stocului: " + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProdus(@PathVariable Long id) {
        produsService.deleteProdus(id);
        return "Produs șters cu succes!";
    }
}
