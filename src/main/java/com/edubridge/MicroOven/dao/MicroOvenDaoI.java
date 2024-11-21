package com.edubridge.MicroOven.dao;

import com.edubridge.MicroOven.model.MicroOven;
import java.util.List;

public interface MicroOvenDaoI {
	
    void addMicroOven(MicroOven microOven);
    List<MicroOven> getAllMicroOvens();
    MicroOven getMicroOvenById(Integer id);
    void updateMicroOven(MicroOven microOven);
    void deleteMicroOven(Integer id);
    void deleteAllMicroOvens();
}
