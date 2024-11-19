package com.edubridge.MicroOven.service;

import java.util.List;

import com.edubridge.MicroOven.model.MicroOven;
import com.edubridge.MicroOven.dao.MicroOvenDao;  // MicroOvenDao instead of ContactDao
import com.edubridge.MicroOven.dao.MicroOvenDaoI; // Interface for MicroOvenDao

public class MicroOvenService {

    private MicroOvenDaoI dao = new MicroOvenDao();  // Use MicroOvenDao instead of ContactDao

    public void addMicroOven(MicroOven microOven) {
        dao.addMicroOven(microOven);
    }

    public List<MicroOven> getAllMicroOvens() {
        return dao.getAllMicroOvens();
    }

    public MicroOven getMicroOvenById(int id) {
        return dao.getMicroOvenById(id);
    }

    public void updateMicroOven(MicroOven microOven) {
        dao.updateMicroOven(microOven);
    }

    public void deleteMicroOven(int id) {
        dao.deleteMicroOven(id);
    }

    public void deleteAllMicroOvens() {
        dao.deleteAllMicroOvens();
    }
}
