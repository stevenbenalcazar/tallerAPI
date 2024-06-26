package uce.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.rh.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer> {
}
