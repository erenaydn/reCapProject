package com.etiya.recapProject.business.abstracts;

import java.util.List;

import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.entities.abstracts.ApplicationUser;

public interface ApplicationUserService {
	DataResult<List<ApplicationUser>> getAll();
}