package controle;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;
import modelo.JoKenPo;

@ManagedBean
@RequestScoped
@Getter
@Setter
public class JoKenPoController {
	
	@ManagedProperty(value = "#{joKenPo}")
	private JoKenPo joKenPo;
	
	private String vencedor;
	
	public String jogar() {
		
		switch(new Random().nextInt(3)) {
		 	
			case 0: joKenPo.setOpcaoMaquina(JoKenPo.PEDRA);
			break;
			
			case 1: joKenPo.setOpcaoMaquina(JoKenPo.PAPEL);
			break;
			
			case 2: joKenPo.setOpcaoMaquina(JoKenPo.TESOURA);
		}
		
		this.vencedor = joKenPo.vencedor();
		
		return "jokenpoResultado";
	}
}