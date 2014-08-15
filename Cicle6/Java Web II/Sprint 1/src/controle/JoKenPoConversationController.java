package controle;

import interceptadores.AutorizacaoInterceptador;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import lombok.Getter;
import lombok.Setter;
import modelo.JoKenPo;

@Named
@ConversationScoped
@Getter
@Setter
@Interceptors(AutorizacaoInterceptador.class)
public class JoKenPoConversationController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private JoKenPo joKenPo;
	
	private String vencedor;
	
	private void beginConversation() {
		
		if (this.conversation.isTransient())
			this.conversation.begin();
	}
	
	private void endConversation() {
		
		if (!this.conversation.isTransient())
			this.conversation.end();
	}
	
	public String coletarOpcaoMaquina() {
		
		this.beginConversation();
		
		switch(new Random().nextInt(3)) {
	 	
			case 0: joKenPo.setOpcaoMaquina(JoKenPo.PEDRA);
			break;
		
			case 1: joKenPo.setOpcaoMaquina(JoKenPo.PAPEL);
			break;
		
			case 2: joKenPo.setOpcaoMaquina(JoKenPo.TESOURA);
		}
	
		return "paginaIntermediaria";
	}
	
	public String resultado() {
			
		this.vencedor = this.joKenPo.vencedor();
		
		this.endConversation();
		
		return "jokenpoResultadoConversation";
	}
}
