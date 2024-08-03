package hn.examen2.examen2.Servicios;

import hn.examen2.examen2.Modelos.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.examen2.examen2.Repositorios.*;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public Prestamo crearPrestamo(Prestamo prestamo) {
        // calcular cuota y crear cuotas
        BigDecimal tasaInteres = new BigDecimal("0.05"); // Ejemplo de tasa de interés
        BigDecimal cuota = calcularCuota(prestamo.getMonto(), tasaInteres, prestamo.getPlazo());
        prestamo.setCuota(cuota);

        // Genera cuotas

        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> obtenerPrestamosPorCliente(String dni) {
        return prestamoRepository.findByClienteDni(dni);
    }

    private BigDecimal calcularCuota(BigDecimal monto, BigDecimal tasaInteres, int plazo) {
        //cálculo de cuota
        return BigDecimal.ZERO;
    }
}
