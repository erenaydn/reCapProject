package com.etiya.recapProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.CarImage;
import com.etiya.recapProject.entities.requests.carImageRequest.CreateCarImageRequest;
import com.etiya.recapProject.entities.requests.carImageRequest.DeleteCarImageRequest;
import com.etiya.recapProject.entities.requests.carImageRequest.UpdateCarImageRequest;

public interface CarImageService {
	Result add(CreateCarImageRequest createCarImageRequest)throws IOException;

	Result update(UpdateCarImageRequest updateCarImageRequest)throws IOException;

	Result delete(DeleteCarImageRequest deleteCarImageRequest);

	DataResult<List<CarImage>> getAll();

	DataResult<List<CarImage>> getImagesWithCarId(int id);
}
