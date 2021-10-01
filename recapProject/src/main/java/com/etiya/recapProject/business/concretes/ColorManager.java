package com.etiya.recapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.recapProject.business.abstracts.ColorService;
import com.etiya.recapProject.business.constants.Messages;
import com.etiya.recapProject.core.business.BusinessRules;
import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.ErrorResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.core.utilities.results.SuccessDataResult;
import com.etiya.recapProject.core.utilities.results.SuccessResult;
import com.etiya.recapProject.dataAccess.abstracts.ColorDao;
import com.etiya.recapProject.entities.concretes.Color;
import com.etiya.recapProject.entities.requests.colorRequest.CreateColorRequest;
import com.etiya.recapProject.entities.requests.colorRequest.DeleteColorRequest;
import com.etiya.recapProject.entities.requests.colorRequest.UpdateColorRequest;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}
	
	@Override
	public Result add(CreateColorRequest createColorRequest) {
		
		var result = BusinessRules.run(checkColorName(createColorRequest.getColorName()));
		if (result != null) {
			return result;
		}
		
		Color color = new Color();
		color.setColorName(createColorRequest.getColorName());
		
		this.colorDao.save(color);
		return new SuccessResult(Messages.COLORADD);
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		Color color = this.colorDao.getById(updateColorRequest.getId());
		color.setColorName(updateColorRequest.getColorName());
		
		this.colorDao.save(color);
		return new SuccessResult(Messages.COLORUPDATE);
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		Color color = this.colorDao.getById(deleteColorRequest.getId());
		
		this.colorDao.delete(color);
		return new SuccessResult(Messages.COLORDELETE);
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorDao.findAll(), Messages.COLORLIST);
	}

	@Override
	public DataResult<Color> findById(int id) {
		return new SuccessDataResult<Color>(this.colorDao.findById(id).get());
	}
	
	public Result checkColorName(String colorName) {

		if (this.colorDao.existsColorByColorName(colorName)) {
			return new ErrorResult(Messages.COLORNAMEERROR);
		}
		return new SuccessResult();
	}

}