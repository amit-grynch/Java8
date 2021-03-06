package Chapter11;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OptionalObjectCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("A", 20);
		Person person2 = new Person("B", 30);
		Person person3 = new Person("C", 40);
		Person person4 = new Person("D", 50);
		List<Person> personList = new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		/*
		 * personList.add(person3); personList.add(person4);
		 */
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Insurance insurance1 = new Insurance("HDFC");
		Insurance insurance2 = new Insurance("ICICI");
		Insurance insurance3 = new Insurance("AXA");
		Insurance insurance4 = new Insurance("SBI");
		Insurance insurance5 = new Insurance("AXIS");

		person1.setCar(Optional.ofNullable(car1));
		person2.setCar(Optional.ofNullable(car2));
		person3.setCar(Optional.ofNullable(car3));
		car1.setInsurance(Optional.ofNullable(insurance1));
		car2.setInsurance(Optional.ofNullable(insurance2));
		System.out.println(" Insurance Company Name is : " + getCarInsuranceName(person1));
		System.out.println(" Insurance Company Name is : " + getCarInsuranceName(personList));

	}
	// Commented Methods are related to Old Style Programming without Optional

	/*
	 * public static String getCarInsuranceNamev1(Person person) { return
	 * person.getCar().getInsurance().getName(); }
	 * 
	 * public static String getCarInsuranceNamev2(Person person) { if (person !=
	 * null) { Car car = person.getCar(); if (car != null) { Insurance insurance =
	 * car.getInsurance(); if (insurance != null) { String name =
	 * insurance.getName(); return name; } } }
	 * 
	 * return "UnKnown"; }
	 * 
	 * public static String getCarInsuranceNamev3(Person person) { if (person ==
	 * null) { return "UnKnown"; } Car car = person.getCar(); if (car == null) {
	 * return "UnKnown"; } Insurance insurance = car.getInsurance(); if (insurance
	 * == null) { return "UnKnown"; } return (insurance.getName()); }
	 */

	public static String getCarInsuranceName(Person person) {
		Optional<Person> optPerson = Optional.of(person);
		return optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
				.orElse("UnknownName");

	}

	public static Set<String> getCarInsuranceName(List<Person> person) {
		return person.stream().map(Person::getCar).map(optCar -> optCar.flatMap(Car::getInsurance))
				.map(insurance -> insurance.map(Insurance::getName)).flatMap(Optional::stream).collect(toSet());

	}

}
