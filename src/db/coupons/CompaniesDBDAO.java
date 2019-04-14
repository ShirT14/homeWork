package db.coupons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Company;
import beans.Coupon;

public class CompaniesDBDAO extends CreateTables implements CompaniesDAO {

	@Override
	public boolean isExists(String email, String password) throws InterruptedException {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlIsExists = "select from compenies where email " + email + ", password " + password;
		java.sql.Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlIsExists);
			if (rs != null) {

				ConnectionPool.getInstance().restoreConnection(con);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionPool.getInstance().restoreConnection(con);

		return false;

	}

	@Override
	public void addCompany(Company company) throws InterruptedException {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlAddCompany = "insert into companies (id,name,email,password,coupons) values";
		sqlAddCompany += "company.getId(), company.getName(),company.getEmail(),company.getPassword(),company.getCoupons())";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlAddCompany);
			ConnectionPool.getInstance().restoreConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCompany(Company company) throws InterruptedException {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlUpdateCompany = "update companies where company id= " + company.getId() + "set name ="
				+ company.getName() + "set email=" + company.getEmail() + "set password=" + company.getPassword();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlUpdateCompany);
			ConnectionPool.getInstance().restoreConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCompany(int companyID) throws InterruptedException {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlDeleteCompany = "delet where id= " + companyID;
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlDeleteCompany);
			ConnectionPool.getInstance().restoreConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Company> getAllCompanies() throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<Company> allCompanies = new ArrayList<Company>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sqlGetAllCompanies = "select*from companies";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlGetAllCompanies);

			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setEmail(rs.getString("email"));
				company.setName(rs.getString("name"));
				company.setPassword(rs.getString("password"));
				ResultSet rs2 = stmt.executeQuery("select from coupons where " + company.getId());
				Coupon cop = new Coupon(rs.getInt("id"));
				company.getCoupons().add(cop);
				allCompanies.add(company);

			}

			ConnectionPool.getInstance().restoreConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allCompanies;
	}

	@Override
	public Company getCompany(int companyID) throws InterruptedException {
		// TODO Auto-generated method stub

		Connection con = ConnectionPool.getInstance().getConnection();

		Company company = new Company();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select from companies where id" + companyID);
			CompaniesDBDAO compDAO = new CompaniesDBDAO();
			if (compDAO.isExists(rs.getString("email"), rs.getString("password"))) {

				company.setId(rs.getInt("id"));
				company.setEmail(rs.getString("email"));
				company.setName(rs.getString("name"));
				company.setPassword(rs.getString("password"));
				ResultSet rs2 = stmt.executeQuery("select from coupons where " + company.getId());
				Coupon cop = new Coupon(rs.getInt("id"));
				company.getCoupons().add(cop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return company;

	}

}
