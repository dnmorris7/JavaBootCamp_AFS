package com.accenture.adf.newcodington.module6.sample;

class AdultPass extends PassDecorator{
		 
	    public AdultPass(EntryPass decoratedPass) {
	        super(decoratedPass);
	    }
	 
	    public double getCost() { // Implementing methods of the abstract class
	        return super.getCost()*1;
	    }
	 
	    public String getIngredients() {
	        return super.getModifiers();
	    }

		@Override
		public String getModifiers() {
			  return super.getModifiers()+modSeparator+"Adult";
		}
	}

