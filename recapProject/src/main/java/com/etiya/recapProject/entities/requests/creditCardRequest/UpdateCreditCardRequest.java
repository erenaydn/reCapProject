package com.etiya.recapProject.entities.requests.creditCardRequest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreditCardRequest {

	private String cardNumber;

	private int cardId;

	private int customerId;

	private String cardName;

	private String cvc;

	private String cardDate;
}
