package org.andr7st.sb.app.web;

/**
 * @author andr7st
 * 
 * Usar java 8 aunque en el pom.xml se especifique la version 11. 
 * */

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.andr7st.sb.app.models.HoraPais;

@Controller
public class Controlador {

	@GetMapping({ "", "/", "index", "home" })
	public String index(Model model) {
		
		String horaColombia = "America/Bogota";

		model.addAttribute("titulo", "Andr7st.");
		model.addAttribute("saludo", "Andr7st's test project.");
		//model.addAttribute("horaColombia", this.dameHora("America/Bogota"));
		
		model.addAttribute("hora",      this.miHora      (horaColombia));
		model.addAttribute("minuto",    this.miMinuto    (horaColombia));
		model.addAttribute("segundo",   this.miSegundo   (horaColombia));
		model.addAttribute("meridiano", this.miMeridiano (horaColombia));

		return "index";
	}

	@ModelAttribute("laHora")
	public String laHora() {
		return this.dameHora("America/Bogota");
	}

	public String dameHora(String zonaHoraria) {

		Calendar tiempo2 = Calendar.getInstance();
		tiempo2.setTimeZone(TimeZone.getTimeZone(zonaHoraria));

		int hh = tiempo2.get(Calendar.HOUR_OF_DAY);
		int mm = tiempo2.get(Calendar.MINUTE);
		int ss = tiempo2.get(Calendar.SECOND);
		int am = tiempo2.get(Calendar.AM_PM);

		if (hh > 12) {
			hh -= 12;
		}

		// sentencia con operador ternario:
		String horas = /* hh <10 ? "0"+ hh: */String.valueOf(hh);
		String minutos = mm < 10 ? "0" + mm : String.valueOf(mm);
		String segundos = ss < 10 ? "0" + ss : String.valueOf(ss);
		String manana = am != 0 ? "PM" : "AM";

		return horas.concat(":").concat(minutos).concat(":").concat(segundos).concat(" ").concat(manana);

	}

	
	// Devuelve una lista de estos paises
	@ModelAttribute("horasPaises")
	public List<HoraPais> horasDePaises() {

		List<HoraPais> paises = Arrays.asList(

				new HoraPais("Colombia", this.dameHora("America/Bogota")),
				// new HoraPais("Hora media", this.dameHora("GMT")), // "Hora Media de
				// Greenwich")),
				new HoraPais("US / Pacific", this.dameHora("US/Pacific")),
				new HoraPais("Chile", this.dameHora("America/Santiago")),
				new HoraPais("España", this.dameHora("Europe/Madrid")),
				new HoraPais("Canada", this.dameHora("America/Vancouver")),
				new HoraPais("Perú", this.dameHora("America/Lima")),
				new HoraPais("Venezuela", this.dameHora("America/Caracas")),
				new HoraPais("Argentina", this.dameHora("America/Argentina/La_Rioja")),
				new HoraPais("Mexico", this.dameHora("America/Mexico_City")));

		return paises;
	}
	
	
	public String miHora(String zonaHoraria) {

		Calendar tiempo2 = Calendar.getInstance();
		tiempo2.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
		int hh = tiempo2.get(Calendar.HOUR_OF_DAY);
		if (hh > 12) {hh -= 12;}
		String horas = /* hh <10 ? "0"+ hh: */String.valueOf(hh);
		return horas;

	}
	
	public String miMinuto(String zonaHoraria) {

		Calendar tiempo2 = Calendar.getInstance();
		tiempo2.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
		int mm = tiempo2.get(Calendar.MINUTE);
		String minutos = mm < 10 ? "0" + mm : String.valueOf(mm);
		return minutos;

	}
	
	public String miSegundo(String zonaHoraria) {

		Calendar tiempo2 = Calendar.getInstance();
		tiempo2.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
		int ss = tiempo2.get(Calendar.SECOND);
		String segundos = ss < 10 ? "0" + ss : String.valueOf(ss);
		return segundos;
	}
	
	public String miMeridiano(String zonaHoraria) {

		Calendar tiempo2 = Calendar.getInstance();
		tiempo2.setTimeZone(TimeZone.getTimeZone(zonaHoraria));
		int am = tiempo2.get(Calendar.AM_PM);
		String manana = am != 0 ? "PM" : "AM";
		return (manana);

	}
	
	@GetMapping({ "sonido", "sound" })
	public String sound(Model model) {
		
		model.addAttribute("titulo", "sound-test");
		
		return "sonido";
	}
	
	
}
