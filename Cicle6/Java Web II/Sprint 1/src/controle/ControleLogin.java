package controle;

import i18n.MessageBundleImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import modelo.Usuario;

@Getter
@Setter
@Named
@RequestScoped
public class ControleLogin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date aniversario;
	
	private String cpf;
	
	@Inject
	private Usuario usuario;
	
	@Inject
	@MessageBundleImpl
	private ResourceBundle messages;
	
//	@PostConstruct
//	public void init() {
//		
//		FacesContext context = FacesContext.getCurrentInstance();
//		Locale locale = context.getViewRoot().getLocale();
//		this.messages = ResourceBundle.getBundle("i18n.messages", locale);
//	}
	
	public String realizarLogin()
	{	
		if(usuario.getLogin().equals("admin") 
				&& usuario.getSenha().equals("admin"))
		{	
			usuario.setPapel("jogador");
			
			final String mensagemLogin = messages.getString("login.obrigatorio");
			System.out.println(mensagemLogin);
			System.out.println("Data de aniversário: " + this.aniversario);
			
			return "sucesso";
		}
		else
		{
			return "falha";
		}
	}
}