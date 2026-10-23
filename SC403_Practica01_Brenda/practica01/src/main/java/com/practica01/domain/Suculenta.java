package com.practica01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Long idSuculenta;

    @NotBlank(message = "El nombre común es obligatorio")
    @Size(max = 80, message = "Máximo 80 caracteres")
    @Column(name = "nombre_comun")
    private String nombreComun;

    @NotBlank(message = "El nombre científico es obligatorio")
    @Size(max = 120, message = "Máximo 120 caracteres")
    @Column(name = "nombre_cientifico")
    private String nombreCientifico;

    @NotBlank(message = "La familia es obligatoria")
    @Size(max = 60, message = "Máximo 60 caracteres")
    private String familia;

    @NotBlank(message = "El color principal es obligatorio")
    @Size(max = 40, message = "Máximo 40 caracteres")
    @Column(name = "color_principal")
    private String colorPrincipal;

    @NotNull(message = "La altura es obligatoria")
    @DecimalMin(value = "0.1", message = "La altura debe ser mayor que 0")
    @Column(name = "altura_cm")
    private Double alturaCm;

    @NotNull(message = "El precio estimado es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    @Column(name = "precio_estimado")
    private BigDecimal precioEstimado;

    @NotBlank(message = "El nivel de riego es obligatorio")
    @Size(max = 30, message = "Máximo 30 caracteres")
    @Column(name = "nivel_riego")
    private String nivelRiego;

    @NotBlank(message = "La URL de la imagen es obligatoria")
    @Size(max = 500, message = "Máximo 500 caracteres")
    @Pattern(regexp = "^https?://.+", message = "Debe ser una URL en la nube (http:// o https://)")
    @Column(name = "ruta_imagen")
    private String rutaImagen;
}
