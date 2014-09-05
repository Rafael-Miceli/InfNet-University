package Service;

import Interafces.PaymentType;
import Model.Payment;

public abstract class ComonPaymentType implements PaymentType {
	
	@Override
	public void Pay(Payment payment) {
		//Enviar Email		
	}
}
