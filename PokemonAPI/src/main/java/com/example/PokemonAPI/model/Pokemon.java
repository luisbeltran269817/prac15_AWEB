package com.example.PokemonAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message= "El tipo es requerido")
    private String tipo;

    @NotNull(message = "El nivel es requerido")
    @Min(value = 0, message = "El nivel debe ser 0+")
    @Max(value = 100, message = "El nivel debe ser <100")
    private Integer nivel;

    @Min(value = 0, message = "El ataque debe ser 0+")
    private Integer ataque;

    @Min(value = 0, message = "La defensa debe ser 0+")
    private Integer defensa;

    @Size(max = 255, message = "La descripcion no puede exceder 255 caracteres")
    private String descripcion;

    @URL(message = "El formato para imagen debe ser una URL")
    private String imagenUrl;

    @Email(message = "Introduce un formato de correo valido")
    private String correoEntrenador;

    @PastOrPresent(message = "Introduzca una fecha valida no futura")
    private LocalDate fechaCaptura;

    @Positive(message = "El peso debe ser positivo")
    private Double peso;

    @Pattern(regexp = "^\\d{10}$", message = "Introduzca un formato de telefono valido")
    private String telefono;

    @AssertTrue(message = "El pokemon debe estar sano")
    private Boolean estaSano;
}
