package com.edubridge.MicroOven.service;

import java.util.List;

import com.edubridge.MicroOven.model.MicroOven;



public interface MicroOvenServiceI {
	void addContact(MicroOven microOven);
	List<MicroOven> getAllMicroOvens();	
	MicroOven getMicroOvenById(Integer id);
	void updateMicroOven(MicroOven microOven);
	void deleteMicroOven(Integer id);
	void deleteAllMicroOvens();
}
