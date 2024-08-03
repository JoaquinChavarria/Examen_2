package hn.examen2.examen2.Repositorios;

import hn.examen2.examen2.Modelos.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuotaRepository extends JpaRepository<Cuota, Long> {
    List<Cuota> findByPrestamoCodigoprestamo(Long codigoprestamo);
}
