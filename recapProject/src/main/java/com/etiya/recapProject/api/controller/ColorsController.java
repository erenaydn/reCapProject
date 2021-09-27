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

import com.etiya.recapProject.business.abstracts.ColorService;
import com.etiya.recapProject.core.utilities.results.DataResult;
import com.etiya.recapProject.core.utilities.results.Result;
import com.etiya.recapProject.entities.concretes.Color;
import com.etiya.recapProject.entities.requests.colorRequest.CreateColorRequest;
import com.etiya.recapProject.entities.requests.colorRequest.DeleteColorRequest;
import com.etiya.recapProject.entities.requests.colorRequest.UpdateColorRequest;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.add(createColorRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}
	
	@PutMapping("/delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}
	
	@GetMapping("/getallbyid")
	public DataResult<Color> findById(int id) {
		return this.colorService.findById(id);
	}
}
