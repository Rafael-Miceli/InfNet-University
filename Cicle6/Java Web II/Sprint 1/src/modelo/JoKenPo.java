package modelo;

import java.io.Serializable;

import javax.inject.Named;
//import javax.faces.bean.ManagedBean;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@ManagedBean
@Named
public class JoKenPo implements Serializable {
	
	/**
	 * UID de serialização estática.
	 */
	private static final long serialVersionUID = 2123872129656486636L;

	private String opcaoUsuario;
	
	private String opcaoMaquina;
	
	private String vencedor;
	
	public static final String PEDRA = "pedra";
	
	public static final String PAPEL = "papel";
	
	public static final String TESOURA = "tesoura";
	
	public String vencedor() {
		
		if (this.opcaoUsuario.equals(this.opcaoMaquina)) {
			return "empate";
		}
		else if (PEDRA.equals(this.opcaoUsuario)) {
			if (TESOURA.equals(this.opcaoMaquina)) {
				return "usuário";
			}
			else
			{
				return "máquina";
			}
		}
		else if (PAPEL.equals(this.opcaoUsuario)) {
			if (PEDRA.equals(this.opcaoMaquina)) {
				return "usuário";
			}
			else
			{
				return "máquina";
			}
		}
		else
		{
			if (PAPEL.equals(this.opcaoMaquina)) {
				return "usuário";
			}
			else
			{
				return "máquina";
			}
		}
	}
}