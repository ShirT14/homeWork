package db.coupons;

import java.util.ArrayList;

import beans.Company;

public interface CompaniesDAO {

	public boolean isExists(String email, String password) throws InterruptedException;

	public void addCompany(Company company) throws InterruptedException;

	public void updateCompany(Company company) throws InterruptedException;

	public void deleteCompany(int companyID) throws InterruptedException;

	public ArrayList<Company> getAllCompanies() throws InterruptedException;

	public Company getCompany(int companyID) throws InterruptedException;

}
