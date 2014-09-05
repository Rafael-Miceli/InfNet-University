package Controller.BuyDeal;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Deal;
import Model.Payment;
import PaperAuthentication.ClientHttpServlet;
import Repository.DealRepository;
import Repository.VoucherRepository;
import Service.BankSplitPaymentType;
import Service.CreditCardPaymentType;
import Service.DealService;
import Service.PaymentService;

public class DealPayment extends HttpServlet {

	private DealService _dealService;
	private PaymentService _paymentService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//Poor Mans Dependency Injection
		_dealService = new DealService((DealRepository)config.getServletContext().getAttribute("dealRepository"));
		_paymentService = new PaymentService((VoucherRepository)config.getServletContext().getAttribute("voucherRepository"), (DealRepository)config.getServletContext().getAttribute("dealRepository"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		Integer Id = Web.WebUtil.GetIdFromQueryString(req.getQueryString());
		
		if(Id > 0)		
		{
			Deal deal = _dealService.FindDeal(Id);
			
			req.setAttribute("DetailsModel", deal);
			req.getRequestDispatcher("WEB-INF/View/BuyDeal/Payment.jsp").forward(req, resp);
		}
		else
			req.getRequestDispatcher("WEB-INF/View/Exception/Erro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String voucherCode;
		
		Deal deal = _dealService.FindDeal(Integer.parseInt(req.getParameter("txtDealId")));
		
		Payment payment = new Payment();			
		payment.setDeal(deal);
		
		if (req.getParameter("ddlCardType") == null) {
			
			voucherCode = _paymentService.Pay(new BankSplitPaymentType(), payment);			
			req.setAttribute("voucherCode", voucherCode);
			req.getRequestDispatcher("WEB-INF/View/BuyDeal/BankSplitPaymentOk.jsp").forward(req, resp);
		}
		else {			
			
			voucherCode = _paymentService.Pay(new CreditCardPaymentType(), payment);
			req.setAttribute("voucherCode", voucherCode);
			req.getRequestDispatcher("WEB-INF/View/BuyDeal/CreditCardPaymentOk.jsp").forward(req, resp);
		}		
		
	}
}
