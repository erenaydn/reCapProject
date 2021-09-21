package com.etiya.recapProject.entities.requests.CarRequest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	private String carName;

	@Min(1900)
	private int modelYear;

	@Min(0)
	private double dailyPrice;

	@Size(max = 200)
	private String description;

	@Max(1900)
	@Min(0)
	private int findexPoint;

	private int brandId;

	private int colorId;
}
