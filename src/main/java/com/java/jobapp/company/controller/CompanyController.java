package com.java.jobapp.company.controller;

import com.java.jobapp.company.model.Company;
import com.java.jobapp.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company savedCompany = companyService.createCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable long id){
        Company company = companyService.getCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company,
                                                @PathVariable long id){
        boolean isUpdated = companyService.updateCompany(company, id);
        if(isUpdated){
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Company not updated.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("Company deleted successfully.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no company with id :"+String.valueOf(id),HttpStatus.NOT_FOUND);
        }
    }
}
