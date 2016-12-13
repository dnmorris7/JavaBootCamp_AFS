package com.accenture.adf.newcodington.module6.sample;

public abstract class PassDecorator extends EntryPass {
	
	    protected final EntryPass decoratedPass;
	    protected String modSeparator = ", ";
	 
	    public PassDecorator(EntryPass decoratedPass) {
	        this.decoratedPass = decoratedPass;
	    }
	 
	    public double getCost() { // Implementing methods of the abstract class
	        return decoratedPass.getCost();
	    }
	 
	    public String getModifiers() {
	        return decoratedPass.getModifiers();
	    }
	    
	  
	}

