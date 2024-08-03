package hn.examen2.examen2.Modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigocuota;
    @SuppressWarnings("unused")
    private Integer mes;
    @SuppressWarnings("unused")
    private BigDecimal interes;
    @SuppressWarnings("unused")
    private BigDecimal capital;
    @SuppressWarnings("unused")
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "codigoprestamo", nullable = false)
    private Prestamo prestamo;


}