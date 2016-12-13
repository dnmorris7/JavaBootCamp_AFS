package com.accenture.adf.newcodington.module6.sample;

class ThreeDayPass extends PassDecorator{
	public ThreeDayPass(EntryPass decoratedPass) {
        super(decoratedPass);
    }
 
    public double getCost() { // Implementing methods of the abstract class
        return super.getCost()*.15;
    }

	@Override
	public String getModifiers() {
		  return super.getModifiers()+modSeparator+"Three Day Discount(15%)";
	}
}