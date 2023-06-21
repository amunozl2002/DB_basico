package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bdm.DBejemplo;
import model.Customers;
import model.Employees;
import model.Payments;

public class CtrlGeneral {

	public List<Customers> getCustomresStateNull() throws ControllerException {
		List<Customers> listado = new ArrayList<Customers>();
		try {
			DBejemplo.openConnection();

			ResultSet resultadoQuery = DBejemplo.query("SELECT * FROM customers WHERE state IS null");
			while (resultadoQuery.next()) {
				Customers elemento = new Customers();

				elemento.setCustomerNumber(resultadoQuery.getInt("customerNumber"));
				elemento.setCustomerName(resultadoQuery.getString("customerName"));
				elemento.setContactLastName(resultadoQuery.getString("contactLastName"));
				elemento.setContactFirstName(resultadoQuery.getString("contactFirstName"));
				elemento.setPhone(resultadoQuery.getString("phone"));
				elemento.setAddressLine1(resultadoQuery.getString("addressLine1"));
				elemento.setAddressLine2(resultadoQuery.getString("addressLine2"));
				elemento.setCity(resultadoQuery.getString("city"));
				elemento.setState(resultadoQuery.getString("state"));
				elemento.setPostalCode(resultadoQuery.getString("postalCode"));
				elemento.setCountry(resultadoQuery.getString("country"));
				elemento.setSalesRepEmployeeNumber(resultadoQuery.getInt("salesRepEmployeeNumber"));
				elemento.setCreditLimit(resultadoQuery.getDouble("creditLimit"));

				listado.add(elemento);
			}
		} catch (SQLException sqle) {
			throw new ControllerException("ERROR: No se puede obtener el listado. " + sqle.getMessage());
		}

		finally {
			DBejemplo.closeConnection();
		}

		return listado;
	}

	public List<Payments> getPaymentsAmountGreatThan(Integer quantity) throws ControllerException {
		List<Payments> listado = new ArrayList<Payments>();
		try {
			DBejemplo.openConnection();

			ResultSet resultadoQuery = DBejemplo.query("SELECT * FROM payments WHERE amount > " + quantity);
			while (resultadoQuery.next()) {
				Payments elemento = new Payments();

				elemento.setCustomerNumber(resultadoQuery.getInt("customerNumber"));
				elemento.setCheckNumber(resultadoQuery.getString("checkNumber"));
				elemento.setPaymentDate(resultadoQuery.getString("paymentDate"));
				elemento.setAmount(resultadoQuery.getDouble("amount"));

				listado.add(elemento);
			}
		} catch (SQLException sqle) {
			throw new ControllerException("ERROR: No se puede obtener el listado. " + sqle.getMessage());
		}

		finally {
			DBejemplo.closeConnection();
		}

		return listado;
	}

//Listado de los "employees" que dan cuenta (reportsTo) al empleado con Id = 1143
	public List<Employees> getEmpleyeesResportsTo(Integer reportsToId) throws ControllerException {
		List<Employees> listado = new ArrayList<Employees>();
		try {
			DBejemplo.openConnection();

			ResultSet resultadoQuery = DBejemplo.query("SELECT * FROM employees WHERE reportsTo = " + reportsToId);
			while (resultadoQuery.next()) {
				Employees elemento = new Employees();

				elemento.setEmployeeNumber(resultadoQuery.getInt("employeeNumber"));
				elemento.setLastName(resultadoQuery.getString("lastName"));
				elemento.setFirstName(resultadoQuery.getString("firstName"));
				elemento.setExtension(resultadoQuery.getString("extension"));
				elemento.setEmail(resultadoQuery.getString("email"));
				elemento.setOfficeCode(resultadoQuery.getString("officeCode"));
				elemento.setReportsTo(resultadoQuery.getInt("reportsTo"));
				elemento.setJobTitle(resultadoQuery.getString("jobTitle"));

				listado.add(elemento);
			}
		} catch (SQLException sqle) {
			throw new ControllerException("ERROR: No se puede obtener el listado. " + sqle.getMessage());
		}

		finally {
			DBejemplo.closeConnection();
		}

		return listado;
	}

}