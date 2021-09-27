package com.etiya.recapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.recapProject.business.abstracts.PaymentService;
import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Payment;
import com.etiya.recapProject.entities.requests.paymentRequest.CreatePaymentRequest;
import com.etiya.recapProject.entities.requests.paymentRequest.DeletePaymentRequest;
import com.etiya.recapProject.entities.requests.paymentRequest.UpdatePaymentRequest;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
	
	private PaymentService paymentService;

	@Autowired
	public PaymentsController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
	}
	
	@PostMapping("/update")
	public Result  update(@Valid @RequestBody UpdatePaymentRequest updatePaymentRequest) {
		return this.paymentService.update(updatePaymentRequest);
	}
	
	@PutMapping("/delete")
	public Result delete(@RequestBody DeletePaymentRequest deletePaymentRequest) {
		return this.paymentService.delete(deletePaymentRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Payment>> getAll() {
		return this.paymentService.getAll();
	}

}
