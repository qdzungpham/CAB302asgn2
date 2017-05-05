package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a drone. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Euclidean 
 * Distance between the customer and the restaurant.  A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author PersonB
 *
 */
public class DroneDeliveryCustomer extends Customer {

	
	private static String Type = "Drone Delivery";
	private static double Distance;
	private static int Restaurant_X = 0;
	private static int Restaurant_Y = 0;
	private int LocationX;
	private int LocationY;
	

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a drone.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     * <P> PRE: TRUE
     * <P> POST: All field values are set
     *
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DroneDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, Type);
		
			this.LocationX = locationX;
			this.LocationY = locationY;
		}
		

	/**
	 * Returns the Euclidean Distance between the instance of DroneDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
     * @return The distance between the restaurant and the customer in Euclidean distance.
	 */
	@Override
	public double getDeliveryDistance() {
		Distance = Math.sqrt(Math.pow((Restaurant_X-LocationX), 2)+Math.pow((Restaurant_Y-LocationY), 2));
		return Distance;
	}
	

}
