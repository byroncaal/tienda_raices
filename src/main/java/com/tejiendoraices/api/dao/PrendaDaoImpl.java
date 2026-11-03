package com.tejiendoraices.api.dao;

import com.tejiendoraices.api.model.Prenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PrendaDaoImpl implements PrendaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Prenda> listar() {
        return em.createQuery("SELECT p FROM Prenda p", Prenda.class).getResultList();
    }

    @Override
    public List<Prenda> listarPorTipo(String tipo) {
        return em.createQuery("SELECT p FROM Prenda p WHERE p.tipo = :tipo", Prenda.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }

    @Override
    public Optional<Prenda> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Prenda.class, id));
    }

    @Override
    public Prenda guardar(Prenda prenda) {
        if (prenda.getId() == null) {
            em.persist(prenda);
            return prenda;
        }
        return em.merge(prenda);
    }

    @Override
    public boolean eliminar(Long id) {
        Prenda prenda = em.find(Prenda.class, id);
        if (prenda == null) return false;
        em.remove(prenda);
        return true;
    }
}