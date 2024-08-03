package hn.examen2.examen2.Servicios;

import hn.examen2.examen2.Modelos.Prestamo;
import hn.examen2.examen2.Modelos.Cuota;
import hn.examen2.examen2.Modelos.Cliente;
import hn.examen2.examen2.Repositorios.PrestamoRepository;
import hn.examen2.examen2.Repositorios.CuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private ClienteService clienteService;


    public BigDecimal calcularCuota(BigDecimal monto, BigDecimal tasaInteresAnual, int plazoEnAnios) {
        BigDecimal tasaInteresMensual = tasaInteresAnual.divide(new BigDecimal("12"), RoundingMode.HALF_UP);
        BigDecimal unoMasTasa = BigDecimal.ONE.add(tasaInteresMensual);
        BigDecimal divisor = BigDecimal.ONE.subtract(unoMasTasa.pow(-plazoEnAnios * 12));

        return monto.multiply(tasaInteresMensual).divide(divisor, RoundingMode.HALF_UP);
    }

    public Prestamo crearPrestamo(Prestamo prestamoDTO, String dni) {
        Cliente cliente = clienteService.buscarPorDni(dni);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado");
        }

        BigDecimal cuota = calcularCuota(prestamoDTO.getMonto(), prestamoDTO.getTasaInteresAnual(), prestamoDTO.getPlazo());

        Prestamo prestamo = new Prestamo();
        prestamo.setFechaapertura(prestamoDTO.getFechaapertura());
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setCuota(cuota);
        prestamo.setPlazo(prestamoDTO.getPlazo());
        prestamo.setCliente(cliente);
        Prestamo prestamoGuardado = prestamoRepository.save(prestamo);
        calcularYGuardarCuotas(prestamoGuardado, prestamoDTO.getMonto(), prestamoDTO.getTasaInteresAnual(), prestamoDTO.getPlazo());

        return prestamoGuardado;
    }

    private void calcularYGuardarCuotas(Prestamo prestamo, BigDecimal monto, BigDecimal tasaInteresAnual, int plazoEnAnios) {
        List<Cuota> cuotas = new ArrayList<>();
        BigDecimal saldo = monto;
        BigDecimal cuota = calcularCuota(monto, tasaInteresAnual, plazoEnAnios);
        BigDecimal tasaInteresMensual = tasaInteresAnual.divide(new BigDecimal("12"), RoundingMode.HALF_UP);

        for (int mes = 0; mes <= plazoEnAnios * 12; mes++) {
            Cuota cuotaEntidad = new Cuota();
            cuotaEntidad.setMes(mes);
            cuotaEntidad.setSaldo(saldo);

            if (mes > 0) {
                BigDecimal interes = saldo.multiply(tasaInteresMensual);
                BigDecimal capital = cuota.subtract(interes);
                saldo = saldo.subtract(capital);

                cuotaEntidad.setInteres(interes);
                cuotaEntidad.setCapital(capital);
            } else {
                cuotaEntidad.setInteres(BigDecimal.ZERO);
                cuotaEntidad.setCapital(BigDecimal.ZERO);
            }

            cuotaEntidad.setSaldo(saldo);
            cuotaEntidad.setPrestamo(prestamo);
            cuotas.add(cuotaEntidad);
        }

        cuotaRepository.saveAll(cuotas);
    }
}
