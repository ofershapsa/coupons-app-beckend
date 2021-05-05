package com.CouponManagment.CouponManagment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.CouponManagment.CouponManagment.dto.Company;




@Repository
public class CompanyDAO {
	
	@Autowired
private CompanyRepository repo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
    public  void addCompany(Company company) {
    	company.setPassword(bcryptEncoder.encode(company.getPassword()));
		repo.save(company);
		
	}
    
    public void deleteCompany(long id) {
    	repo.deleteById(id);
		
	}
    public List<Company> selectAllCompanies() {
    	
    	return	repo.findAll();
		
	}
    
    public Company findCompany(long id) {
    	
    	return repo.findById(id).get();
		
	}
    
    public void updateCompany (long id,Company comp) {
    	Company company = findCompany(id);
    	//company.setCOMP_NAME(comp.getCOMP_NAME());
    	company.setPassword(bcryptEncoder.encode(comp.getPassword()));
    	company.setEmail(comp.getEmail());
    	repo.save(company);
		
	}

}
