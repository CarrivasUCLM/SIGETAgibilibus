package pasos;

import java.awt.List;
import java.time.LocalDate;

import com.agibilibus.SIGET.model.Manager;
import com.agibilibus.SIGET.model.Reunion;
import com.agibilibus.SIGET.model.Usuario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepEnviarInvitacion {

	@Given("he rellenado el formulario para crear la reunion")
	public void crearReunion(int idReunion, String titulo, String descripcion, LocalDate horaInicio, LocalDate horaFin, Usuario organizador, List asistentes, String url) {
		//Manager.get().guardarReunion(idReunion, titulo, descripcion, horaInicio, horaFin, organizador, asistentes, url);
	}
	
	@When("doy al boton <crearReunion> ")
	public void pulsarBotonCrearReunion() {
		
	}
	
	@Then("me aparece una notificacion ")
	public void mostrarNotificacion(Reunion reunion) {
		//Manager.get().mostrarNotificacion(reunion);
	}
	
	@Then("respondo invitación ")
	public void responderInvitacion(Reunion reunion, Usuario asistente) {
		//Manager.get().responderInvitacion(reunion, asistente);
	}
	
	@Then(" muestra mensaje de error <mensaje>")
	public void muestraMensaje() {
		System.out.println("Error no se ha podido enviar invitacion");
	}
}
