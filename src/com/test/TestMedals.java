package com.test;

import com.Data.Medals;
import com.Data.MedalsType;
import com.Data.MedalsWin;
import com.Endpoint.MedalsController;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.oauth.OAuthRequestException;

public class TestMedals {

	public TestMedals() {
		// TODO Auto-generated constructor stub
	}

	public MedalsType addMedalsType(MedalsType medal) throws OAuthRequestException{
		MedalsController medalsController= new MedalsController();
		return medalsController.addMedaltype(medal);
	}
	public CollectionResponse<MedalsType> listMedalsType(){
		MedalsController medalsController= new MedalsController();
		return medalsController.listMedalsType(null, null);
	}
	public CollectionResponse<MedalsWin> updateMedalsUser(CollectionResponse<MedalsWin> medals, long id){
		MedalsController medalsController = new MedalsController();
		return medalsController.updateMedalsUser(medals, id);
	}
	public  CollectionResponse<Medals> getMedalsUser(long id){
		MedalsController medalsController= new MedalsController();
		return medalsController.getMedalsUser(id);
	}
	
	
}
