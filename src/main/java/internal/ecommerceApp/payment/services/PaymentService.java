package internal.ecommerceApp.payment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import internal.ecommerceApp.payment.model.Payments;
import internal.ecommerceApp.payment.repository.PaymentRepository;


@Service
public class PaymentService {
	

		@Autowired
	private PaymentRepository paymentRepository;



	public String savePayment(List<Payments> payments) 
		{
			paymentRepository.saveAll(payments);
			return "payment added  " + payments.size();
	}

	public List<Payments> getpayment() 
		{
			return (List<Payments>) paymentRepository.findAll();
		}

	public Payments updatePayment(Payments payments ,  int payment_id) {
		
		
		Optional<Payments> paymentData = paymentRepository.findById(payment_id);

		if (paymentData.isPresent()) {
			Payments _payments = paymentData.get();
		
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

	public String deletePayment(int payment_id) {
		
		try {
			paymentRepository.deleteById(payment_id);
			return "content deleted   " +payment_id;
		} catch (Exception e) {
			return "content not deleted";
		}
	}


	public String deleteAllPayments() {
		try {
			paymentRepository.deleteAll();
			return "all contents deleted";
		} catch (Exception e) {
			return "contents are not deleted";
		}
	}

	}






