package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author n9326448/Hang Su 
 * 
 */
public class PizzaFactoryTests {
	
	private  LocalTime order_open = LocalTime.of(19, 00);
	private  LocalTime order_close = LocalTime.of(23, 00);
	MargheritaPizza MargheritaPizza;
	// TO DO
	@Test
	public void init() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
		Pizza  MakePizza = PizzaFactory.getPizza("PZM", 3, order_time, delivery_time);
		Pizza  MargheritaPizza = new MargheritaPizza(3, order_time, delivery_time);
		assertEquals(true, MakePizza.equals(MargheritaPizza));
	}
	
	
	@Test(expected = PizzaException.class)
	public void InvalidPizzaCodeException() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza("HVD", 3, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void InvalidPizzaCodeException1() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
	    PizzaFactory.getPizza("12", 3, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void InvalidPizzaCodeException2() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza(" ", 3, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void OrderedMoreThan10Pizza() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza("PZV", 11, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void OrderedLessThanOnePizza() throws PizzaException{
		LocalTime order_time = order_open;
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza("PZV", 0, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void OrdereTimeBeforeOrder_open() throws PizzaException{
		LocalTime order_time = order_open.minusHours(1);
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza("PZV", 2, order_time, delivery_time);
	}
	@Test(expected = PizzaException.class)
	public void OrdereTimeAfterOrder_close() throws PizzaException{
		LocalTime order_time = order_close.plusHours(1);
		LocalTime delivery_time = order_time.plusMinutes(30);
		PizzaFactory.getPizza("PZV", 1, order_time, delivery_time);
	}
	
}
