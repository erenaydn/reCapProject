package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Rental;
import com.etiya.recapProject.entities.requests.RentalRequest.CreateRentalRequest;
import com.etiya.recapProject.entities.requests.RentalRequest.UpdateRentalRequest;

public interface RentalService {
	Result addCorporateCustomerRental(CreateRentalRequest createRentalRequest);

	Result addIndividualCustomerRental(CreateRentalRequest createRentalRequest);

	Result updateCorporateCustomerRental(UpdateRentalRequest updateRentalRequest);

	Result updateIndividualCustomerRental(UpdateRentalRequest updateRentalRequest);

	DataResult<List<Rental>> getAll();
}
