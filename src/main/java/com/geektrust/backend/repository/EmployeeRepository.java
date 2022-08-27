package com.geektrust.backend.repository;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository implements IEmployeeRepository{
    private final Map<String,String> employeeRegMap;

    public EmployeeRepository() {
        this.employeeRegMap = new HashMap<>();
    }

    @Override
    public void save(String regId, String email) {
        this.employeeRegMap.put(regId,email);
    }

    @Override
    public String findEmailByRegId(String regId) {
        return this.employeeRegMap.get(regId);
    }

    @Override
    public void removeRegById(String regId) {
        if(employeeRegMap.containsKey(regId)){
            this.employeeRegMap.remove(regId);
        }
    }

}
