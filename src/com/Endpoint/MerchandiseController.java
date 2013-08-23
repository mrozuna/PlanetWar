package com.Endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.Data.Merchandise;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
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

@Api(name = "merchandise", version = "v1")
public class MerchandiseController {

	public MerchandiseController() {
		// TODO Auto-generated constructor stub
	}

	@ApiMethod(name = "addMerchardise", httpMethod = "POST")
	public Merchandise add(Merchandise merchandise) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query qu = new Query(Merchandise.table).setFilter(new FilterPredicate(
				Merchandise.colId, FilterOperator.EQUAL, merchandise.getId()));
		PreparedQuery pq1 = datastore.prepare(qu);

		if (pq1.asList(FetchOptions.Builder.withDefaults()).size() > 0) {
			merchandise.setCost(-1);
			merchandise.setDescription(" ");
			merchandise.setId(-1);
			merchandise.setName(" ");
			return merchandise;
		} else {
			long id = 1;
			Query q = new Query(Merchandise.table);
			PreparedQuery pq = datastore.prepare(q);
			id = pq.asList(FetchOptions.Builder.withDefaults()).size();
			id += 1;
			Key key = KeyFactory.createKey(Merchandise.table, id);
			Entity entMerchandice = new Entity(key);
			entMerchandice.setProperty(Merchandise.colId, id);
			entMerchandice.setProperty(Merchandise.colCost,
					merchandise.getCost());
			entMerchandice.setProperty(Merchandise.colDescriptionl,
					merchandise.getDescription());
			entMerchandice.setProperty(Merchandise.colName,
					merchandise.getName());
			return merchandise;
		}

	}

	@ApiMethod(name = "getAllMerchardise", httpMethod = "GET")
	public CollectionResponse<Merchandise> getAllMerchandise() {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query q = new Query(Merchandise.table);
		PreparedQuery pq = datastore.prepare(q);
		List<Merchandise> list = new ArrayList<Merchandise>();

		for (Entity ent : pq.asIterable()) {
			Merchandise m = new Merchandise();
			m.setCost(Double.parseDouble(ent.getProperty(Merchandise.colCost)
					.toString()));
			m.setDescription(ent.getProperty(Merchandise.colDescriptionl)
					.toString());
			m.setId(Long.parseLong(ent.getProperty(Merchandise.colId)
					.toString()));
			m.setName(ent.getProperty(Merchandise.colName).toString());
			list.add(m);
		}

		return CollectionResponse.<Merchandise> builder().setItems(list)
				.setNextPageToken(null).build();
	}

	@ApiMethod(name = "getMerchardiseById", httpMethod = "GET")
	public Merchandise getMerchandiseById(@Named("id") long id) {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query q = new Query(Merchandise.table);
		PreparedQuery pq = datastore.prepare(q);
		Entity ent = pq.asSingleEntity();
		Merchandise merchandise = new Merchandise();
		merchandise.setCost(Double.parseDouble(ent.getProperty(
				Merchandise.colCost).toString()));
		merchandise.setDescription(ent.getProperty(Merchandise.colDescriptionl)
				.toString());
		merchandise.setId(Long.parseLong(ent.getProperty(Merchandise.colId)
				.toString()));
		merchandise.setName(ent.getProperty(Merchandise.colName).toString());
		return merchandise;

	}

}
