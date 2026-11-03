package com.tejiendoraices.api.dao;

import com.tejiendoraices.api.model.Prenda;
import java.util.List;
import java.util.Optional;

public interface PrendaDao {
    List<Prenda> listar();
    List<Prenda> listarPorTipo(String tipo);
    Optional<Prenda> buscarPorId(Long id);
    Prenda guardar(Prenda prenda);
    boolean eliminar(Long id);
}