package internal.ecommerceApp.payment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PaymentsDb")
public class Payments {
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	
	@Column(name="is_payed")
	private boolean is_payed;
	
	@Column(name="payment_status")
	private String payment_status;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="updated_at")
	private String updated_at;
	
	
//	@ManyToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name = "order_id")
 //   private Orders orders;
	
	

	public int getPayment_id() {
		return payment_id;
	}

	public Payments() {
	super();
}

	public Payments(int payment_id, boolean is_payed, String payment_status, String created_at, String updated_at) {
	super();
	this.payment_id = payment_id;
	this.is_payed = is_payed;
	this.payment_status = payment_status;
	this.created_at = created_at;
	this.updated_at = updated_at;
}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public boolean isIs_payed() {
		return is_payed;
	}

	public void setIs_payed(boolean is_payed) {
		this.is_payed = is_payed;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	

	
	

}
