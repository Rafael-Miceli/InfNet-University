package interceptadores;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import modelo.Usuario;

//Somente usu�rio com perfil admin ou comprador passa por ele
public class AutorizacaoInterceptador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	Usuario usuario;

	@AroundInvoke
	public Object interceptar(InvocationContext contexto) throws Exception {
		
		if ("admin".equals(this.usuario.getPapel())
				|| "comprador".equals(this.usuario.getPapel()))
			return contexto.proceed();
		
		throw new RuntimeException("Permiss�o negada");
	}
}
