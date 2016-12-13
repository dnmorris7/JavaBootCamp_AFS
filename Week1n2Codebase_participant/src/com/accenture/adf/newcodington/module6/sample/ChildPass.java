package com.accenture.adf.newcodington.module6.sample;
class ChildPass extends PassDecorator{
	 
    public ChildPass(EntryPass decoratedPass) {
        super(decoratedPass);
    }
 
    public double getCost() { // Implementing methods of the abstract class
        return super.getCost()*.5;
    }

	@Override
	public String getModifiers() {
		  return super.getModifiers()+modSeparator+"Child";
	}
	
	
}
