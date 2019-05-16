package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;


	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/error");
	}
	
	//Punto6
	@RequestMapping("/{operacion}/{valor}")
	public ModelAndView operacion(@PathVariable String operacion , @PathVariable String valor , String resultado) {
		ModelMap modelo = new ModelMap();

		switch(operacion) {

		case "pasarAMayuscula":
			resultado = valor.toUpperCase();
			break;

		case "pasarAMinuscula":
			resultado = valor.toLowerCase();
			break;

		case "invertirOrden":
			StringBuilder builder = new StringBuilder(valor);
			resultado = builder.reverse().toString();
			break;

		case "cantidadDeCaracteres":
			int result = valor.length();
			resultado = Integer.toString(result);
			break;
		default:
			return new ModelAndView("redirect:/error");
		}

		modelo.put("operacion", operacion);
		modelo.put("valor", valor);
		modelo.put("resultado", resultado);


		return new ModelAndView("resultado",modelo);
	}

	@RequestMapping("/error")
	public ModelAndView operacionDeCaracteresErronea() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("error",modelo);
	}	
	
}
