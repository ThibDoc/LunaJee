package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ModeReglements implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int code;
	
	@Basic
    private String type;
    
    @Transient
    private transient boolean ignoré;
    
    public ModeReglements(){
    	
    }
    
    public ModeReglements(String type){
    	this();
    	this.type = type;
    }


    public int getCode() {
		return code;
	}

	public String getType() {
        return type;
    }
    

    public void setCode(int code) {
		this.code = code;
	}

	public void setType(String type) {
        this.type = type;
    }

    /**
     * Décrit le mode de règlement
     * de manière textuelle.
     */
    @Override
    public String toString() {
    	return type;
    }
}
