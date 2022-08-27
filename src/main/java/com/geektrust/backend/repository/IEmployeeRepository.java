package com.geektrust.backend.repository;

public interface IEmployeeRepository {
    public void save(String regId,String email);
    public String findEmailByRegId(String regId);
    public void removeRegById(String regId);
}
