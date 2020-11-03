package com.agibilibus.SIGET.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.agibilibus.SIGET.dao.InvitacionDAO;
import com.agibilibus.SIGET.dao.ReunionDAO;
import com.agibilibus.SIGET.dao.UserDAO;



import lombok.Data;

@Component
@Data
@Document(collection = "invitaciones")
public class Invitacion {

	@Id
	private String idInvitacion;
	private Usuario usuario;
	private Reunion reunion;
	private EstadoInvitacion estado;

	@Autowired
	private InvitacionDAO invitaciondao;

	@Autowired
	private ReunionDAO reuniondao;

	@Autowired
	private UserDAO userdao;

	public Invitacion() {
	}

	public Invitacion(String idInvitacion, Usuario usuario, Reunion reunion, EstadoInvitacion estado) {
		this.idInvitacion = idInvitacion;
		this.usuario = usuario;
		this.reunion = reunion;
		this.estado = estado;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public EstadoInvitacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInvitacion estado) {
		this.estado = estado;
	}

	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("id", this.idInvitacion);
		jso.put("usuario", this.usuario.getNombre());
		jso.put("reunion", this.reunion.toJSON());
		jso.put("estado", this.estado);
		return jso;

	}

	private static class InvitacionHolder {
		static Invitacion singleton = new Invitacion();
	}

	@Bean(name = "beanInvitacion")
	public static Invitacion get() {
		return InvitacionHolder.singleton;
	}



	public JSONArray recibirInvitacion(Usuario user) {
		JSONArray jsaInvitaciones = new JSONArray();
		Optional<Usuario> optUser = userdao.findById(user.getUser());
		if (optUser.isPresent()) {
			user = optUser.get();
		}
		List<Invitacion> invitaciones = invitaciondao.findAll();
		for (Invitacion inv : invitaciones) {
			/*
			if ((inv.getReunion().getAsistentes()).contains(user)&& inv.getEstado() == EstadoInvitacion.pendiente) {
				System.out.println("entra");
				jsaInvitaciones.put(inv.toJSON());
			}*/
			if(inv.getUsuario().getUser().equals(user.getUser()) && inv.getEstado() == EstadoInvitacion.pendiente) {
				jsaInvitaciones.put(inv.toJSON());
			}
		}
		return jsaInvitaciones;
	}

	public void aceptarInvitacion(String idInvitacion2) {
		
	}

	public void enviarInivitacion(String id, String[] correosAsistentes) {
		Optional<Reunion> optReunion = reuniondao.findById(id);
		String idInv ="";
		List<Usuario> asist = new ArrayList<>();
		if (optReunion.isPresent()) {
			Reunion r = optReunion.get();
			for (String correo : correosAsistentes) {
				Optional<Usuario> a = userdao.findByEmail(correo);
				if (a.isPresent()) {
					Usuario usuario = a.get();
					asist.add(usuario);
					idInv=r.toString()+usuario.toString();
					System.out.println("guarda invitacion");
					invitaciondao.save(new Invitacion(idInv, usuario, r, EstadoInvitacion.pendiente));
				}
			}

		}
	}

	public void responderInvitacion(Reunion reunion2, Usuario asistente) {
		// TODO Auto-generated method stub
	}
	
	public void rechazarInvitacion(String idInvitacion2) {
	}


}
