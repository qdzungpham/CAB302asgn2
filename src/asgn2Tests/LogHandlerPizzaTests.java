package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author n9326448/Hang Su
* 
*/
public class LogHandlerPizzaTests {
	// TO DO
	
	private static final double DELTA = 1e-15;
	
	
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetWithNoSuchFile() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("Test1.txt");
	}
	@Test
	public void createPizzaNormaltestWithStringEntered() throws PizzaException, LogHandlerException{
		Pizza pizza = LogHandler.createPizza("21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,5");
		assertEquals("Vegetarian", pizza.getPizzaType());
		assertEquals(5, pizza.getQuantity());
		assertEquals(10, pizza.getPricePerPizza(),DELTA);
		assertEquals(5.5, pizza.getCostPerPizza(),DELTA);
		assertEquals(27.5, pizza.getOrderCost(),DELTA);
		assertEquals(50, pizza.getOrderPrice(),DELTA);
		assertEquals(22.5, pizza.getOrderProfit(),DELTA);
	}
	@Test
	public void createPizzaNormaltestWithLogFileInput() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> pizza = LogHandler.populatePizzaDataset("Test2.txt");
		assertEquals("Vegetarian", pizza.get(0).getPizzaType());
		assertEquals(5, pizza.get(0).getQuantity());
		assertEquals(10, pizza.get(0).getPricePerPizza(),DELTA);
		assertEquals(5.5,pizza.get(0).getCostPerPizza(),DELTA);
		assertEquals(27.5, pizza.get(0).getOrderCost(),DELTA);
		assertEquals(50, pizza.get(0).getOrderPrice(),DELTA);
		assertEquals(22.5, pizza.get(0).getOrderProfit(),DELTA);
	}
	@Test
	public void createPizzaNormaltestWithSameOrder() throws PizzaException, LogHandlerException{
		Pizza pizza1 = LogHandler.createPizza("21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,5");
		Pizza pizza2 = new VegetarianPizza(5,LocalTime.parse("21:17:00"),LocalTime.parse("21:27:00"));
		assertEquals(true, pizza1.equals(pizza2));
		
	}
	@Test (expected = LogHandlerException.class)
	public void createPizzarLineParsingError() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("qwet,qwqewdewwwedwei");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithMoreThan10PizzaOrderedperOrder() throws PizzaException, LogHandlerException{
	    LogHandler.createPizza("21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,11");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithLessThan1PizzaOrderedperOrder() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,0");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithOrderPizzaBeforeOrder_open() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("18:17:00,18:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithOrderPizzaAfterOrder_close() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("23:17:00,23:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithDeliveryPizzaLessThanTenMinAfterOrderPizza() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:17:00,21:19:00,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithMorethanOneHourAfterOrderPizza() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:17:00,22:19:00,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	@Test (expected = PizzaException.class)
	public void createPizzaWithInvalidPizzaCode() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:17:00,22:19:00,Emma Brown,0602547760,DVC,-1,0,PZA,3");
	}
	@Test (expected = LogHandlerException.class)
	public void createPizzaWithInvalidTimeFormat() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:76:00,21:29:00,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	@Test (expected = LogHandlerException.class)
	public void createPizzaWithInvalidTimeForma2t() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("21:16:00,asdfg,Emma Brown,0602547760,DVC,-1,0,PZV,3");
	}
	
}
