package db.coupons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * create the tables of the database.
		 *
		 */

		String url = "jdbc:derby://localhost:1527/CouponsSystemDB";
		/**
		 * the creation of the companies table
		 */
		String companiesSQL = "create table COMPANIES (ID INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)";
		companiesSQL += ", NAME varchar(20), EMAIL varchar(20) ,PASSWORD varchar(20), primary key(ID) )";

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();)

		{
			// stmt.executeUpdate(companiesSQL);
			System.out.println(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * create the customers table.
		 */

		String customersSQL = "create table CUSTOMERS (ID INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)";
		customersSQL += ",FIRST_NAME varchar(20), LAST_NAME varchar(20), EMAIL varchar(20) ,PASSWORD varchar(20), primary key(ID)) ";

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();)

		{
			// stmt.executeUpdate(customersSQL);
			System.out.println(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * create the categories table.
		 */
		String categoriesSQL = "create table CATEGORIES (ID integer generated always as identity (start with 1 , increment by 1)";
		categoriesSQL += ",NAME varchar(20),primary key(ID))";

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();)

		{
			// stmt.executeUpdate(categoriesSQL);
			System.out.println(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String couponsSQL = "create table COUPONS (ID integer generated always as identity (start with 1 , increment by 1)";
		couponsSQL += ",COMPANY_ID integer , CATEGORY_ID integer , TITLE varchar(20), DESCRIPTION varchar(40)";
		couponsSQL += ",START_DATE date, END_DATE DATE, AMOUNT integer, PRICE double, IMAGE varchar(20)";
		couponsSQL += ",primary key (id), FOREIGN KEY (company_id) REFERENCES COMPANIES(id) ,FOREIGN KEY (category_id) REFERENCES CATEGORIES(id))";
		// System.out.println(couponsSQL);
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();)

		{
			// stmt.executeUpdate(couponsSQL);
			System.out.println(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * create a table that combine that shoes for every customers the coupons he
		 * get.
		 */
		String sqlCreate = "create table CUSTOMERS_VS_CUOPONS( customer_id integer , coupon_id integer,foreign key (customer_id) references customers(id), foreign key (coupon_id) references coupons(id),primary key( customer_id,coupon_id))";

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();) {
			// stmt.executeUpdate(sqlCreate);

			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
