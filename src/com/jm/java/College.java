package com.jm.java;

/**
 * @author Jatin Malwal
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class College implements Subject {
	public static final String NAME = "Name";
	public static final String AGE = "Age";

	private List<Student> students = new ArrayList<Student>();
	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

	public class Student {

		private String name;

		private byte age;

		public Student(String name, byte age) {
			this.setName(name);
			this.setAge(age);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			notifyListeners(this, NAME, this.name, this.name = name);
		}

		public byte getAge() {
			return age;
		}

		public void setAge(byte age) {
			notifyListeners(this, AGE, String.valueOf(this.age), String.valueOf(this.age = age));
		}
	}

	public College() {
		// Statically add some values in the list
		students.add(new Student("Jatin", (byte) 21));
		students.add(new Student("Navjot", (byte) 22));
		students.add(new Student("Vivek", (byte) 22));
		students.add(new Student("Swathi", (byte) 21));

	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public void registerPropertyChangeListener(PropertyChangeListener newListener) {
		listeners.add(newListener);
	}

	@Override
	public void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener temp : listeners) {
			temp.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	@Override
	public void unRegisterPropertyChangeListener(PropertyChangeListener oldListener) {
		listeners.remove(oldListener);

	}

}