package com.accenture.adf.newcodington.module16.activity;

import org.junit.Test;

import com.accenture.adf.newcodington.module16.sample.Temperature;
import com.accenture.adf.newcodington.module16.sample.TemperatureConvertor;

import junit.framework.TestCase;

/**
 * Topic : Unit Testing
 * 
 * Description:
 * 
 * The TestTemperatureConvertorActivity class is used test the workflow
 * conditions of the TemperatureConvertor domain class. It tests the normal
 * condition and the exception conditions for the class
 */

public class TestTemperatureConvertorActivity_basic extends TestCase {

	// Local objects of Temparature and TemperatureConvertorSolution classes
	Temperature temperature;
	TemperatureConvertor convertorSolution;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	/**
	 * TCS.UT.AP331.TC.009: Initialization is done successfully
	 */
	public void testTemparatureConvertorSolution() {

		temperature = new Temperature();
		convertorSolution = new TemperatureConvertor(temperature);
		assertEquals(
				"Temperature Converter Initiated:  Temperature Data Received",
				convertorSolution.getConversionMessage());
	}

	@Test
	/**
	 * TCS.UT.AP331.TC.010: Pass Temperature Object (no Temperature Object)
	 */
	public void testTemperatureConvertorSolutionTemperature_NoObject() {

		/*
		 * TODO 1: create a new TemperatureConvertor object by passing a null
		 * argument to the constructor handle the NullPointerException thrown by
		 * the constructor and write an assert statement to ensure that
		 * appropriate exception was thrown.
		 */
	}

	@Test
	/**
	 * TCS.UT.AP331.TC.011: Pass Temperature Object 
	 * (temperature, currUOM and newUOM are VALID but the same)
	 */
	public void testTemperatureConvertorSolutionTemperature_SameUOM() {

		temperature = new Temperature(32f, 'F', 'F');

		// TODO 2: write an assert statement statement to ensure that required
		// exception is being thrown
	}

	@Test
	/**
	 *  TCS.UT.AP331.TC.012: Celsius to Fahrenheit
	 */
	public void testConvertTemperature_Celsius_Fahrenheit() {

		temperature = new Temperature(50.0f, 'C', 'F');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertCelsiusToFahrenheit(temperature);

		// TODO 3: Write assert statements to run the the test conditions
		assertEquals(32, temperature.getTemperature(), 1);

	}

}
