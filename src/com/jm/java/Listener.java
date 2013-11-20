package com.jm.java;

/**
 * @author Jatin Malwal
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Listener implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent event) {

		String property = event.getPropertyName();

		String oldValue = event.getOldValue().toString();

		String newValue = event.getNewValue().toString();

		System.out.println("Student details added : " + property + " | Old Value : " + oldValue + " | New value : " + newValue + " |");

		if (event.getPropertyName().equals(College.NAME)) {
			System.out.println("Name changed");
		} else if (event.getPropertyName().equals(College.AGE)) {
			System.out.println("Age changed");
		} else {
			System.out.println("Other");
		}
	}
}
