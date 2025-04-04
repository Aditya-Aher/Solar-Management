package com.example.demo.restapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
	

	@Entity
	public class Visit {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   
	    private String consumerName;

	
	    private String consumerNumber;

	    private String subcdStatus; // Single Status, Done

	    private String installationStatus; // Done, Not Done

	    private String reasonNotDone;

	    private String queries;
	    
//	   to put in postman
//    {
//	        "consumerName": "Aditya",
//	        "consumerNumber": "12345",
//	        "subcdStatus": "Active",
//	        "installationStatus": "Approved",
//	        "reasonNotDone": "incomplete",
//	        "queries": "Approved"
//	      }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getConsumerName() {
	        return consumerName;
	    }

	    public void setConsumerName(String consumerName) {
	        this.consumerName = consumerName;
	    }

	    public String getConsumerNumber() {
	        return consumerNumber;
	    }

	    public void setConsumerNumber(String consumerNumber) {
	        this.consumerNumber = consumerNumber;
	    }

	    public String getSubcdStatus() {
	        return subcdStatus;
	    }

	    public void setSubcdStatus(String subcdStatus) {
	        this.subcdStatus = subcdStatus;
	    }

	    public String getInstallationStatus() {
	        return installationStatus;
	    }

	    public void setInstallationStatus(String installationStatus) {
	        this.installationStatus = installationStatus;
	    }

	    public String getReasonNotDone() {
	        return reasonNotDone;
	    }

	    public void setReasonNotDone(String reasonNotDone) {
	        this.reasonNotDone = reasonNotDone;
	    }

	    public String getQueries() {
	        return queries;
	    }

	    public void setQueries(String queries) {
	        this.queries = queries;
	    }
	}


