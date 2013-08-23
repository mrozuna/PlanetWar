package com.test;

import com.Data.GeneratedStatus;
import com.Data.Status;
import com.Endpoint.StatusController;

public class TestStatus {
public TestStatus(){
	
}
public Status add(GeneratedStatus status){
	StatusController statusController= new StatusController();
	return statusController.addStatus(status);
}

public Status update(GeneratedStatus status){
	StatusController statusController= new StatusController();
	return statusController.updateStatus(status);
	
}
public Status get(long id){
	StatusController statusController= new StatusController();
	return statusController.getStatus(id);
}
}
