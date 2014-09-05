package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Deal;
import Model.Voucher;

public class VoucherRepository {
	
	private List<Voucher> _vouchers;
	
	public VoucherRepository() {
		
		Deal deal = new DealRepository().GetDeal(1);
		
		Voucher voucher = new Voucher();		
		
		voucher.setId(1);
		voucher.setCode("ABCDEF1234");
		voucher.setDeal(deal);		
		voucher.setValid(true);
		
		_vouchers = new ArrayList<Voucher>();
		_vouchers.add(voucher);
	}
	
	public Voucher getById(Integer id) {
		
		for(Voucher voucher : _vouchers)
			if (voucher.getId() == id)
				return voucher;
		
		return null;		
	}
	
	public Voucher getByCode(String code) {
		
		for(Voucher voucher : _vouchers)
			if (voucher.getCode().equals(code))
				return voucher;
		
		return null;		
	}
	
	public void update(Voucher voucher) {
		Voucher voucherToUpdate = getById(voucher.getId());
		
		voucherToUpdate.setValid(false);
	}
	
	public void add(Voucher voucher) {
		Integer newId = _vouchers.get(_vouchers.size() - 1).getId() + 1;		
		voucher.setId(newId);
		
		_vouchers.add(voucher);
	}

}
