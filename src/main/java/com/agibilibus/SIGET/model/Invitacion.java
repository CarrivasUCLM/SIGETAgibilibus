package com.agibilibus.SIGET.model;

import org.json.JSONObject;

public class Invitacion {
	private Usuario usuario;
	private Reunion reunion;
	private EstadoInvitacion estado;
	
	public Invitacion () {}
	public Invitacion (Usuario usuario, Reunion reunion, EstadoInvitacion estado) {
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
	public void aceptarInvitacion() {}
	public void rechazarInvitacion() {}
	
	public JSONObject toJSON() {
		JSONObject jso = new JSONObject();
		jso.put("usuario", this.usuario);
		jso.put("reunion", this.reunion);
		jso.put("estado", this.estado);
		return jso;

	}
	
	



}