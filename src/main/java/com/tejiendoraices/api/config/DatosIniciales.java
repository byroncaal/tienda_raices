package com.tejiendoraices.api.config;

import com.tejiendoraices.api.dao.PrendaDao;
import com.tejiendoraices.api.model.Prenda;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatosIniciales {

    @Bean
    CommandLineRunner cargar(PrendaDao dao) {
        return args -> {
            if (!dao.listar().isEmpty()) return;
            dao.guardar(crear("HUIPIL", "Huipil de Santiago Atitlán", "Sololá",
                    "Algodón, telar de cintura", 450.0));
            dao.guardar(crear("HUIPIL", "Huipil de Chichicastenango", "Quiché",
                    "Algodón con bordado floral", 380.0));
            dao.guardar(crear("CORTE", "Corte de Cobán", "Alta Verapaz",
                    "Algodón tejido", 320.0));
            dao.guardar(crear("CORTE", "Corte de Nebaj", "Quiché",
                    "Algodón teñido", 350.0));
        };
    }

    private Prenda crear(String tipo, String nombre, String region,
                         String material, Double precio) {
        Prenda p = new Prenda();
        p.setTipo(tipo);
        p.setNombre(nombre);
        p.setRegion(region);
        p.setMaterial(material);
        p.setPrecio(precio);
        return p;
    }
}