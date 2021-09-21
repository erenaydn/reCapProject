package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Car;
import com.etiya.recapProject.entities.dtos.CarDetailDto;
import com.etiya.recapProject.entities.requests.CarRequest.CreateCarRequest;
import com.etiya.recapProject.entities.requests.CarRequest.DeleteCarRequest;
import com.etiya.recapProject.entities.requests.CarRequest.UpdateCarRequest;

public interface CarService {
	Result add(CreateCarRequest createCarRequest);

	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);

	DataResult<List<Car>> getAll();

	DataResult<Car> findById(int id);

	DataResult<List<CarDetailDto>> getCarsWithBrandAndColorDetails();
	
	DataResult<List<CarDetailDto>> getCarsByBrandName(String brandName);
	
	DataResult<List<CarDetailDto>> getCarsByColorName(String colorName);
	
	DataResult<Car> getByCarName(String carName);
}
