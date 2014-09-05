package Service;

import Interafces.PaymentType;
import Model.Payment;
import Repository.DealRepository;
import Repository.VoucherRepository;

public class PaymentService {

	protected VoucherService _voucherService;
	protected DealService _dealService;

	public PaymentService(VoucherRepository voucherRepository, DealRepository dealRepository) {
		_voucherService = new VoucherService(voucherRepository);
		_dealService = new DealService(dealRepository);
		
	}
	
	public PaymentService() {
		_voucherService = new VoucherService();
		_dealService = new DealService();		
	}
	
	public String Pay(PaymentType paymentType, Payment payment) {
		paymentType.Pay(payment);
		
		_dealService.increaseTotalBuyed(payment.getDeal().getId());		
		return _voucherService.createNewVoucher(payment.getDeal());
	}
}
