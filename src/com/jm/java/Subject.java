package com.jm.java;

/**
 * @author Jatin Malwal
 */

import java.beans.PropertyChangeListener;

public interface Subject {
	
	public void registerPropertyChangeListener(PropertyChangeListener newListener);
	
	public void notifyListeners(Object object, String property, String oldValue, String newValue);

	public void unRegisterPropertyChangeListener(PropertyChangeListener newListener);

}
