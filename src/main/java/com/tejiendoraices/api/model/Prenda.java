package com.tejiendoraices.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "CORTE|HUIPIL", message = "El tipo debe ser CORTE o HUIPIL")
    private String tipo;

    @NotBlank
    private String nombre;

    private String region;
    private String material;

    @NotNull
    @Positive
    private Double precio;

    private Boolean disponible = true;
    private String imagenUrl;

    public Prenda() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}