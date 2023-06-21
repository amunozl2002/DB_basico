package view;

import java.util.List;

import controller.ControllerException;
import controller.CtrlGeneral;
import model.Customers;
import model.Employees;
import model.Payments;

public class Principal {

	public static void main(String[] args) {
		mostrarListado1();
		mostrarListado2();
		mostrarListado3();
	}

	/**
	 * Listado de los "customers" que no tienen "state" (el campo "state" es nulo).
	 */
	private static void mostrarListado1() {
		try {
			CtrlGeneral ctrl = new CtrlGeneral();
			List<Customers> listado = ctrl.getCustomresStateNull();
			listado.stream().forEach(System.out::println);
		} catch (ControllerException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Listado de los "payments" cuyo "amount" sea mayor de 30.000.
	 */
	private static void mostrarListado2() {
		Integer quantity = 30000;
		try {
			CtrlGeneral ctrl = new CtrlGeneral();
			List<Payments> listado = ctrl.getPaymentsAmountGreatThan(quantity);
			listado.stream().forEach(System.out::println);
		} catch (ControllerException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Listado de los "employees" que dan cuenta (reportsTo) al empleado con Id = 1143
	 */
	private static void mostrarListado3() {
		Integer reportsToId = 1143;
		try {
			CtrlGeneral ctrl = new CtrlGeneral();
			List<Employees> listado = ctrl.getEmpleyeesResportsTo(reportsToId);
			listado.stream().forEach(System.out::println);
		} catch (ControllerException e) {
			System.err.println(e.getMessage());
		}

	}

}