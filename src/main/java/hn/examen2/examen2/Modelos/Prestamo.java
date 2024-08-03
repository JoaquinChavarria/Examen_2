package hn.examen2.examen2.Modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoprestamo;
    @SuppressWarnings("unused")
    private LocalDate fechaapertura;
    @SuppressWarnings("unused")
    private BigDecimal monto;
    @SuppressWarnings("unused")
    private BigDecimal cuota;
    @SuppressWarnings("unused")
    private Integer plazo;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuota> cuotas;

    public static Prestamo crearPrestamo(Prestamo prestamo) {
        throw new UnsupportedOperationException("Unimplemented method 'crearPrestamo'");
    }

    public static Object obtenerPrestamoPorCodigo(Long codigoprestamo2) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPrestamoPorCodigo'");
    }

    public BigDecimal getMonto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMonto'");
    }

    public int getPlazo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlazo'");
    }

    public void setCuota(BigDecimal cuota2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCuota'");
    }

}
