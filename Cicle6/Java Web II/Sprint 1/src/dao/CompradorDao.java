package dao;

import interceptadores.AutorizacaoAdministradorInterceptador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import lombok.Getter;
import lombok.Setter;
import modelo.Comprador;


@Named
@ConversationScoped
@Getter
@Setter
public class CompradorDao implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Comprador> compradores;
	
	public CompradorDao() {
		compradores = new ArrayList();
	}
	
	
	//Adiciona Comprador
	@Interceptors(AutorizacaoAdministradorInterceptador.class)
	public void adicionarComprador(Comprador comprador){
			this.compradores.add(comprador);
	}
	
	//Exclui comprador
	@Interceptors(AutorizacaoAdministradorInterceptador.class)
	public void excluirComprador(Comprador comprador){
		this.compradores.remove(comprador);
	}

	//Lista os compradores
	@Interceptors(AutorizacaoAdministradorInterceptador.class)
	public List<Comprador> listarCompradores(){
		return this.compradores;
	}
	
	//Editar Comprador
	@Interceptors(AutorizacaoAdministradorInterceptador.class)
	public void editarComprador(){
		
	}

	
}
