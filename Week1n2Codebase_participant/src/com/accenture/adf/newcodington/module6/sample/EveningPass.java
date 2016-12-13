package com.accenture.adf.newcodington.module6.sample;

class EveningPass extends PassDecorator{
	  public EveningPass(EntryPass decoratedPass) {
	        super(decoratedPass);
	    }
	 
	    public double getCost() { // Implementing methods of the abstract class
	        return super.getCost()*1.3;
	    }

		@Override
		public String getModifiers() {
			  return super.getModifiers()+modSeparator+"Evening";
		}
}
