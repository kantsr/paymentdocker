package internal.ecommerceApp.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import internal.ecommerceApp.payment.model.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Integer> {

}
