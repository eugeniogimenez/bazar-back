package com.bazar.bazar.service;

import com.bazar.bazar.model.Venta;
import com.bazar.bazar.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    //Inyección de Dependencias de Repository
    @Autowired
    private IVentaRepository ventRepo;

    @Override
    public List<Venta> getVentas() {

        List<Venta> listaVentas = ventRepo.findAll();
        return listaVentas;
    }

    @Override
    public void saveVenta(Venta vent) {
        ventRepo.save(vent);
    }

    @Override
    public void deleteVenta(Long id) {
        ventRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta vent = ventRepo.findById(id).orElse(null);
        return vent;
    }

    @Override
    public void editVenta(Venta vent) {

        this.saveVenta(vent);
    }
}
