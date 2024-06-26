package uce.rh.controlador;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.rh.modelo.Empleado;
import uce.rh.servicio.EmpleadoServicio;

import java.util.List;


@RestController// Define que esta clase es un controlador RESTful que devuelve datos en formato JSON o XML.
//http://localhost:8080/rh-app/
@RequestMapping("rh-app") // Define la URL base para todas las rutas en esta clase como /rh-app.
//Se indica que recibimos peticiones de otro puerto (El 3000 en este caso que viene de React)
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {

    //Con esta informacion mandamos la informacion a consola
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    //http:localhost:8080/rh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }


    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: "+empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }
}
