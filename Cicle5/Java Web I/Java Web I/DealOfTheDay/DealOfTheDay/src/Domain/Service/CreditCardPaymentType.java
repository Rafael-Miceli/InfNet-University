package Service;

import Interafces.PaymentType;
import Model.Payment;

public class CreditCardPaymentType extends ComonPaymentType {
	
	@Override
	public void Pay(Payment payment) {
		//Validar pagamento com a operadora do cartão
		
		super.Pay(payment);
	}
}
