package Controller.Deal;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Voucher;
import PaperAuthentication.ProviderHttpServlet;
import Repository.VoucherRepository;
import Service.VoucherService;

public class ValidateVoucher extends HttpServlet {

	private VoucherService _voucherService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_voucherService = new VoucherService((VoucherRepository)config.getServletContext().getAttribute("voucherRepository"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {		
		
		req.getRequestDispatcher("WEB-INF/View/Deal/ValidateVoucher.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Voucher voucher = _voucherService.validateVoucher(req.getParameter("txtVoucherCode").toString());
		
		if(voucher != null) {			
			req.setAttribute("VoucherModel", voucher);
			req.getRequestDispatcher("WEB-INF/View/Deal/VoucherValidated.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("VoucherMessage", "Voucher Inválido");
			req.getRequestDispatcher("WEB-INF/View/Deal/ValidateVoucher.jsp").forward(req, resp);
		}
		
		
	}
}
