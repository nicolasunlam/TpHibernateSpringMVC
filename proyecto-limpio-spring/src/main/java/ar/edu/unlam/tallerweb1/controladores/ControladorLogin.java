package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Punto6;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
		return new ModelAndView("redirect:/punto6");
	}
	
	@RequestMapping("/punto6")
	public ModelAndView irPunto6() {

		ModelMap modelo = new ModelMap();
		Punto6 punto = new Punto6();
		modelo.put("punto6", punto);
		return new ModelAndView("punto6", modelo);
	}
	
	//Punto6
	@RequestMapping(path = "/mostrarPunto", method = RequestMethod.POST)
	public ModelAndView mostrarPunto(@ModelAttribute("punto6") Punto6 punto, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		model.put("operacion", punto.getOperacion());
		model.put("cadena", punto.getCadena());
		String operacion = punto.getOperacion();
		String resultado = new String ();
		if (operacion == "pasar") {
			model.put("operacion", punto.getOperacion());
			model.put("cadena", punto.getCadena());
			resultado = punto.getCadena().toUpperCase();
			model.put("resultado", resultado);
		}
		switch ( operacion ) {
	      case "pasar-a-mayusculas":
	    	  model.put("operacion", punto.getOperacion());
	    	  model.put("cadena", punto.getCadena());
	    	  resultado = punto.getCadena().toUpperCase();
	    	  model.put("resultado", resultado);
	           break;
	      case "pasar-a-minusculas":
	    	  model.put("operacion", punto.getOperacion());
	    	  model.put("cadena", punto.getCadena());
	    	  resultado = punto.getCadena().toLowerCase();
	    	  model.put("resultado", resultado);
	           break;
	      case "invertir-orden":
	    	  model.put("operacion", punto.getOperacion());
	    	  model.put("cadena", punto.getCadena());
	    	  for (int i = punto.getCadena().length()-1; i>=0; i--){
	             resultado += punto.getCadena().charAt(i);
	          }
	    	  model.put("resultado", resultado);
	           break;
	      case "cantidad-de-caracteres":
	    	  model.put("operacion", punto.getOperacion());
	    	  model.put("cadena", punto.getCadena());
	    	  resultado = Integer.toString(punto.getCadena().length());
	    	  model.put("resultado", resultado);
	           break;
	      default:
	           System.out.println("error" );
	           break;
	      }
		
		return new ModelAndView("mostrarPunto", model);
	}
	
	
}
