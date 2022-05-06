package internal.ecommerceApp.payment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import internal.ecommerceApp.payment.model.Payments;
import internal.ecommerceApp.payment.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@PostMapping("/addpayment")
	public  String paymentDetail(@RequestBody List<Payments> payments)
	{
		paymentRepository.saveAll(payments);
		return "payments added  " + payments.size();
	}
	@GetMapping("/getpayment")
	public List<Payments>  getpayment()
	{
		System.out.println("not updated");
		return (List<Payments>) paymentRepository.findAll();
	}
	
	@PutMapping("/payments/{id}")
	public Payments updateTutorial(@PathVariable("id") int payment_id, @RequestBody Payments payments) {
		Optional<Payments> paymentData = paymentRepository.findById(payment_id);

		if (paymentData.isPresent()) {
			Payments _payments = paymentData.get();
		//	_billing.setBillid(billing.getBillid());
			_payments.setIs_payed(payments.isIs_payed());
			_payments.setPayment_status(payments.getPayment_status());
			_payments.setCreated_at(payments.getCreated_at());
			_payments.setUpdated_at(payments.getUpdated_at());
			System.out.println("contents updated");
			return paymentRepository.save(payments);
		} else {
			System.out.println("not updated");
			return payments;
		}
	}
			
	@DeleteMapping("/payments/{id}")
	public String deletePayments(@PathVariable("id") int payment_id) {
		try {
			paymentRepository.deleteById(payment_id);
			return "content deleted   " +payment_id;
		} catch (Exception e) {
			return "content not deleted";
		}
}
}
