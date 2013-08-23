package com.Endpoint;

import com.Data.Merchandise;
import com.Data.MerchandiseUser;
import com.Data.UserApi;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class MerchandiseUserController {

	public MerchandiseUserController() {
		// TODO Auto-generated constructor stub
	}

	public Merchandise addMerchandise(long idUser, long idMerchandise,
			long amout) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		MerchandiseController merchandiseController = new MerchandiseController();
		Merchandise merchandise = merchandiseController
				.getMerchandiseById(idMerchandise);
		UserController usercontroller = new UserController();
		UserApi userApi = usercontroller.getData(idUser);
		MerchandiseUser merchandiseUser = new MerchandiseUser();

		merchandiseUser.setAmout(amout);
		merchandiseUser.setId(0);
		merchandiseUser.setIdMerchandise(merchandise.getId());
		merchandiseUser.setIdUser(userApi.getId());
		long id = 1;
		Query q = new Query(Merchandise.table);
		PreparedQuery pq = datastore.prepare(q);
		id = pq.asList(FetchOptions.Builder.withDefaults()).size();
		id += 1;
		Key key = KeyFactory.createKey(MerchandiseUser.table, id);
		Entity entMerchandiceUser = new Entity(key);
		entMerchandiceUser.setProperty(MerchandiseUser.colId, id);
		entMerchandiceUser.setProperty(MerchandiseUser.colAmout,
				merchandiseUser.getAmout());
		entMerchandiceUser.setProperty(MerchandiseUser.colIdMerchandise,
				merchandiseUser.getIdMerchandise());
		entMerchandiceUser.setProperty(MerchandiseUser.colIdUser,
				merchandiseUser.getIdUser());
		datastore.put(entMerchandiceUser);


		return merchandise;
	}

}
