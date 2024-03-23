package com.java.jobapp.company.service;

import com.java.jobapp.company.model.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);
    List<Company> getAllCompanies();

    Company getCompanyById(long id);
    boolean updateCompany(Company company, long id);

    boolean deleteCompanyById(long id);
}
