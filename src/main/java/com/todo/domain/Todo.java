package com.todo.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Todo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFinalizar;
	
	private Boolean finalizado = false;
	
	public Todo() {
		super();
	}

	public Todo(Integer id, String titulo, String descricao, Date dataFinalizar, Boolean finalizado) {
		super();
		this.id = id;
		this.titulo  = titulo;
		this.descricao = descricao;
		this.dataFinalizar = dataFinalizar;
		this.finalizado = finalizado;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dataFinalizar, descricao, finalizado, id, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(dataFinalizar, other.dataFinalizar) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(finalizado, other.finalizado) && Objects.equals(id, other.id)
				&& Objects.equals(titulo, other.titulo);
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataFinalizar() {
		return dataFinalizar;
	}
	public void setDataFinalizar(Date dataFinalizar) {
		this.dataFinalizar = dataFinalizar;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}



}
