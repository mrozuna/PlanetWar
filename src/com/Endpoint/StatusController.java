package com.Endpoint;

import javax.inject.Named;

import com.Data.GeneratedStatus;
import com.Data.Status;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;


@Api(name = "status")
public class StatusController {

	public StatusController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * It uses HTTP POST method.
	 *
	 * @param status the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "addStatus", httpMethod = "POST")
	public Status addStatus(GeneratedStatus status) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
	
		Query qu = new Query(Status.table).setFilter(new FilterPredicate(Status.colUserId,
				FilterOperator.EQUAL, status.getUserId()));
		PreparedQuery pq1=datastore.prepare(qu);

if(pq1.asList(FetchOptions.Builder.withDefaults()).size() >0){
	Status statusError = new Status();
	statusError.setGameDraw(-1);
	statusError.setGameLost(-1);
	statusError.setGameWin(-1);
	statusError.setId(-1L);
	statusError.setStatusGameDraw(" ");
	statusError.setStatusGameLost(" ");
	statusError.setStatusGameWin(" ");
	statusError.setTotal(-1);
	return statusError;
}else{
	try{	
	long id = 1;

		Query q = new Query(Status.table);
		PreparedQuery pq = datastore.prepare(q);
		id = pq.asList(FetchOptions.Builder.withDefaults()).size();
		id += 1;
		Key key = KeyFactory.createKey(Status.table, id);
		Entity entStatus = new Entity(key);

		
		
		long win = Long.parseLong(status.getGameWin());
		long lost = Long.parseLong(status.getGameLost());
		long draw = Long.parseLong(status.getGameDraw());
		long total = win + lost + draw;
		Status totalStatus = new Status();
		totalStatus.setGameDraw(draw);
		totalStatus.setGameLost(lost);
		totalStatus.setGameWin(win);
		totalStatus.setId(Long.parseLong(status.getUserId()));
		totalStatus.setStatusGameDraw(((double) (draw * 100) / total) + "%");
		totalStatus.setStatusGameLost(((double) (lost * 100) / total) + "%");
		totalStatus.setTotal(total);
		totalStatus.setStatusGameWin(((double) (win * 100) / total) + "%");

		
		entStatus.setProperty(Status.colUserId, status.getUserId());
		entStatus.setProperty(Status.colId,id);
		entStatus.setProperty(Status.colGameWin, win);
		entStatus.setProperty(Status.colGameLost, lost);
		entStatus.setProperty(Status.colGameDraw, draw);
		entStatus.setProperty(Status.colStatusGameWin, totalStatus.getStatusGameWin());
		entStatus.setProperty(Status.colStatusGameLost, totalStatus.getStatusGameLost());
		entStatus.setProperty(Status.colStatusGameDraw, totalStatus.getStatusGameDraw());
		entStatus.setProperty(Status.colTotal, total);

		datastore.put(entStatus);

		return totalStatus;
	}catch(NumberFormatException e){
		Status statusError = new Status();
		statusError.setGameDraw(-1);
		statusError.setGameLost(-1);
		statusError.setGameWin(-1);
		statusError.setId(-1L);
		statusError.setStatusGameDraw(" ");
		statusError.setStatusGameLost(" ");
		statusError.setStatusGameWin(" ");
		statusError.setTotal(-1);
		return statusError;
		
	}
}

	}
	
	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param status the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "getStatus", httpMethod = "GET")
	public Status getStatus(@Named("id") long id) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query q = new Query(Status.table).setFilter(new FilterPredicate(Status.colUserId,
				FilterOperator.EQUAL, id));
		Entity e = datastore.prepare(q).asSingleEntity();
		Status status = new Status();
		status.setGameWin(Long.parseLong(e.getProperty(Status.colGameWin).toString()));
		status.setGameLost(Long.parseLong(e.getProperty(Status.colGameLost).toString()));
		status.setGameDraw(Long.parseLong(e.getProperty(Status.colGameDraw).toString()));
		status.setUserId(id);
		status.setTotal(Long.parseLong(e.getProperty(Status.colTotal).toString()));
		status.setStatusGameDraw(e.getProperty(Status.colStatusGameDraw).toString());
		status.setStatusGameLost(e.getProperty(Status.colStatusGameLost).toString());
		status.setStatusGameWin(e.getProperty(Status.colStatusGameWin).toString());
		return status;
	}


	@ApiMethod(name = "updateStatus", httpMethod = "POST")
	public Status updateStatus(GeneratedStatus status) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query qu = new Query(Status.table).setFilter(new FilterPredicate(Status.colUserId,
				FilterOperator.EQUAL, status.getUserId()));
		PreparedQuery pq1=datastore.prepare(qu);

if(pq1.asList(FetchOptions.Builder.withDefaults()).size() ==0){
	Status statusError = new Status();
	statusError.setGameDraw(-1);
	statusError.setGameLost(-1);
	statusError.setGameWin(-1);
	statusError.setId(-1L);
	statusError.setStatusGameDraw(" ");
	statusError.setStatusGameLost(" ");
	statusError.setStatusGameWin(" ");
	statusError.setTotal(-1);
	return statusError;
}else{
		Query q = new Query(Status.table).setFilter(new FilterPredicate(Status.colUserId,
				FilterOperator.EQUAL, status.getUserId()));
				
		Entity entStatus = datastore.prepare(q).asSingleEntity();

		long win =Long.parseLong( status.getGameWin())
				+ Integer.parseInt(entStatus.getProperty(Status.colGameWin).toString());
		long lost = Long.parseLong(status.getGameLost())
				+ Integer
						.parseInt(entStatus.getProperty(Status.colGameLost).toString());
		long draw = Long.parseLong(status.getGameDraw())
				+ Integer
						.parseInt(entStatus.getProperty(Status.colGameDraw).toString());

		long total = win + lost + draw;

		Status totalStatus = new Status();
		totalStatus.setId(Long.parseLong(entStatus.getProperty(Status.colId).toString()));
		totalStatus.setGameDraw(draw);
		totalStatus.setGameLost(lost);
		totalStatus.setGameWin(win);
		totalStatus.setId(Long.parseLong(status.getUserId()));
		totalStatus.setStatusGameDraw(((double) (draw * 100) / total) + "%");
		totalStatus.setStatusGameLost(((double) (lost * 100) / total) + "%");
		totalStatus.setTotal(total);
		totalStatus.setStatusGameWin(((double) (win * 100) / total) + "%");

		entStatus.setProperty(Status.colGameWin, win);
		entStatus.setProperty(Status.colGameLost, lost);
		entStatus.setProperty(Status.colGameDraw, draw);
		entStatus.setProperty(Status.colStatusGameWin, totalStatus.getStatusGameWin());
		entStatus.setProperty(Status.colStatusGameLost, totalStatus.getStatusGameLost());
		entStatus.setProperty(Status.colStatusGameDraw, totalStatus.getStatusGameDraw());
		entStatus.setProperty(Status.colTotal, total);

		datastore.put(entStatus);

		return totalStatus;
}
}
	
}
