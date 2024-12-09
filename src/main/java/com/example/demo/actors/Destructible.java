package com.example.demo.actors;

/**
 * interface for objects that can take damage and be destroyed
 */
public interface Destructible {

	/**
	 * applies damage to the object.
	 */
	void takeDamage();

	/**
	 * destroys the object.
	 */
	void destroy();
	
}
