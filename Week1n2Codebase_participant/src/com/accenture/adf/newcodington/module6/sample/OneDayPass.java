package com.accenture.adf.newcodington.module6.sample;

class OneDayPass extends PassDecorator{
	public OneDayPass(EntryPass decoratedPass) {
        super(decoratedPass);
    }
 
    public double getCost() { // Implementing methods of the abstract class
        return super.getCost()*1;
    }

	@Override
	public String getModifiers() {
		  return super.getModifiers()+modSeparator+"One Day";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
