package asgn2Tests;
import static org.junit.Assert.*;
import java.time.LocalTime;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.VegetarianPizza;


//import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.PizzaTopping;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MargheritaPizza classes. 
 * Note that an instance of asgn2Pizzas.MargheritaPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
	private static final double DELTA = 1e-15;
	MargheritaPizza MargheritaPizza;
	VegetarianPizza VegetarianPizza;
	private  LocalTime order_open = LocalTime.of(19, 00);
	private  LocalTime order_close = LocalTime.of(23, 00);
	
	@Before @Test
	public void setUp() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_open.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
		VegetarianPizza = new VegetarianPizza(3, order_Time, delivery_Time);
	}
	
	@Test
	public void init() throws PizzaException{
		assertEquals(1.5, MargheritaPizza.getCostPerPizza(),DELTA);
		assertEquals(8, MargheritaPizza.getPricePerPizza(),DELTA);
		assertEquals(4.5, MargheritaPizza.getOrderCost(),DELTA);
		assertEquals(24, MargheritaPizza.getOrderPrice(),DELTA);
		assertEquals(19.5, MargheritaPizza.getOrderProfit(),DELTA);
		assertEquals(true, MargheritaPizza.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, MargheritaPizza.containsTopping(PizzaTopping.TOMATO));
		assertEquals(3, MargheritaPizza.getQuantity());
		assertEquals("Margherita", MargheritaPizza.getPizzaType());					
	}
	
	
	@Test(expected = PizzaException.class)
	public void MoreThanTenPizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(11, order_Time, delivery_Time);
	}
	
	@Test(expected = PizzaException.class)
	public void LessThanOnePizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(0, order_Time, delivery_Time);
	}
	@Test(expected = PizzaException.class)
	public void OrderPizzaBeforeOrder_open() throws PizzaException{
		LocalTime order_Time = order_open.minusHours(1);
		LocalTime delivery_Time = order_Time.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
	}
	
	
	@Test(expected = PizzaException.class)
	public void OrderPizzaAfterOrder_close() throws PizzaException{
		LocalTime order_Time =order_close.plusMinutes(1);
		LocalTime delivery_Time = order_close.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
	}
	
	@Test(expected = PizzaException.class)
	public void DeliveryPizzaLessThanTenMinAfterOrderPizza() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(9);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
	}
	@Test
	public void DeliveryPizzaEqualsTenMinAfterOrderPizza() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
		assertEquals(24, MargheritaPizza.getOrderPrice(),DELTA);
	}
	@Test
	public void DeliveryPizzaMoreThanTenMinAfterOrderPizza() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(30);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
		assertEquals(24, MargheritaPizza.getOrderPrice(),DELTA);
	}
	@Test(expected = PizzaException.class)
	public void DeliveryPizzaMorethanOneHourAfterOrderPizza() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusHours(1).plusMinutes(10);
		MargheritaPizza = new MargheritaPizza(3, order_Time, delivery_Time);
	}
	
	@Test
	public void CostPerPizzaWithMoreThanOnePizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza MargheritaPizza1 = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(1.5, MargheritaPizza1.getCostPerPizza(),DELTA);
		
		MargheritaPizza MargheritaPizza2 = new MargheritaPizza(7, order_Time, delivery_Time);
		assertEquals(1.5, MargheritaPizza2.getCostPerPizza(),DELTA);
	}
	
	@Test
	public void OrderCostPerPizzaWithMoreThanOnePizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza MargheritaPizza1 = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(6, MargheritaPizza1.getOrderCost(),DELTA);
		
		MargheritaPizza MargheritaPizza2 = new MargheritaPizza(7, order_Time, delivery_Time);
		assertEquals(10.5, MargheritaPizza2.getOrderCost(),DELTA);
	}
	
	@Test
	public void PricePerPizzaWithMoreThanOnePizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza MargheritaPizza1 = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(8, MargheritaPizza1.getPricePerPizza(),DELTA);
		
		MargheritaPizza MargheritaPizza2 = new MargheritaPizza(7, order_Time, delivery_Time);
		assertEquals(8, MargheritaPizza2.getPricePerPizza(),DELTA);
	}
	
	@Test
	public void OrderPricePerPizzaWithMoreThanOnePizzaOrdered() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza MargheritaPizza1 = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(32, MargheritaPizza1.getOrderPrice(),DELTA);
		
		MargheritaPizza MargheritaPizza2 = new MargheritaPizza(7, order_Time, delivery_Time);
		assertEquals(56, MargheritaPizza2.getOrderPrice(),DELTA);
	}
	
	@Test
	public void GetOrderProfit() throws PizzaException{
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(26, MargheritaPizza.getOrderProfit(),DELTA);
	}
	
	@Test
	public void PizzaContainsTopping() throws PizzaException{
		assertEquals(true, MargheritaPizza.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, MargheritaPizza.containsTopping(PizzaTopping.TOMATO));		
	}
	
	@Test
	public void PizzaNotContainsTopping() throws PizzaException{
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.CAPSICUM));
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.EGGPLANT));
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.MUSHROOM));
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.BACON));
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.SALAMI));	
		assertEquals(false, MargheritaPizza.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void GetOrderQuantity() throws PizzaException{		
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		MargheritaPizza = new MargheritaPizza(4, order_Time, delivery_Time);
		assertEquals(4, MargheritaPizza.getQuantity());
	}
	
	
	@Test
	public void GetOrderPizzaType() throws PizzaException{
		
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza = new MargheritaPizza(4, order_Time, delivery_Time);
		VegetarianPizza = new VegetarianPizza(5, order_Time, delivery_Time);
		
		assertEquals("Margherita", MargheritaPizza.getPizzaType());
		assertEquals("Vegetarian", VegetarianPizza.getPizzaType());
	}
	@Test
	public void OrderDiffTypeOfPizza() throws PizzaException{
		
		LocalTime order_Time = order_open;
		LocalTime delivery_Time = order_Time.plusMinutes(10);
		
		MargheritaPizza = new MargheritaPizza(4, order_Time, delivery_Time);
		VegetarianPizza = new VegetarianPizza(5, order_Time, delivery_Time);
		assertEquals(4, MargheritaPizza.getQuantity());
		assertEquals(5, VegetarianPizza.getQuantity());
		
	}
	
	
	
	
	
	
	
	

}