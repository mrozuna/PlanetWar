package com.Endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.Data.Medals;
import com.Data.MedalsType;
import com.Data.Merchandise;
import com.Data.MerchandisePurchased;
import com.Data.MerchandiseUser;
import com.Data.UserApi;
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
import com.google.appengine.api.oauth.OAuthRequestException;

/**
 * @author mrosas
 * 
 */

@Api(name = "user", version = "v1")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already It uses HTTP POST method.
	 * 
	 * @param userapi
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "add", httpMethod = "POST")
	public UserApi add(UserApi userApi) throws OAuthRequestException {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query(UserApi.table).setFilter(new FilterPredicate(
				UserApi.colEmail, FilterOperator.EQUAL, userApi.getEmail()));
		PreparedQuery pq1 = datastore.prepare(query);
		if (pq1.asList(FetchOptions.Builder.withDefaults()).size() > 0) {
			Entity ent = pq1.asSingleEntity();
			return getData(Long.parseLong(ent.getProperty(UserApi.colId)
					.toString()));
		} else {

			long id = 1;
			Query q = new Query(UserApi.table);
			PreparedQuery pq = datastore.prepare(q);
			id = pq.asList(FetchOptions.Builder.withDefaults()).size();
			id += 1;
			Key key = KeyFactory.createKey(UserApi.table, id);
			Entity userEntity = new Entity(key);
			userEntity.setProperty(UserApi.colId, id);
			userEntity.setProperty(UserApi.colNameUser, userApi.getNameUser());

			userEntity.setProperty(UserApi.colEmail, userApi.getEmail());
			userEntity.setProperty(UserApi.colTotalPoints, 0);

			userApi.setId(id);
			addMedalsUser(userApi);

			datastore.put(userEntity);
			return userApi;

		}

	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getData", httpMethod = "GET")
	public UserApi getData(@Named("id") long id) {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query q = new Query(UserApi.table).setFilter(new FilterPredicate(
				UserApi.colId, FilterOperator.EQUAL, id));
		PreparedQuery pq = datastore.prepare(q);
		UserApi u = new UserApi();
		Entity e = pq.asSingleEntity();
		u.setId(id);
		u.setNameUser(e.getProperty(UserApi.colNameUser).toString());
		// u.setUser(null);
		u.setEmail(e.getProperty(UserApi.colEmail).toString());
		u.setTotalPoints(Long.parseLong(e.getProperty(UserApi.colTotalPoints)
				.toString()));
		return u;
	}

	/**
	 * This update a new entity into App Engine datastore. If the entity already
	 * It uses HTTP POST method.
	 * 
	 * @param userapi
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "updateData", httpMethod = "GET")
	public UserApi updateData(UserApi user) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query(UserApi.table).setFilter(new FilterPredicate(
				UserApi.colEmail, FilterOperator.EQUAL, user.getEmail()));
		PreparedQuery pq1 = datastore.prepare(query);
		if (pq1.asList(FetchOptions.Builder.withDefaults()).size() > 0) {
			Query q = new Query(UserApi.table).setFilter(new FilterPredicate(
					UserApi.colEmail, FilterOperator.EQUAL, user.getEmail()));
			PreparedQuery pq = datastore.prepare(q);

			Entity userEntity = pq.asSingleEntity();
			user.setId(Long.parseLong(userEntity.getProperty(UserApi.colId)
					.toString()));
			userEntity.setProperty(UserApi.colNameUser, user.getNameUser());

			userEntity.setProperty(UserApi.colEmail, user.getEmail());

			datastore.put(userEntity);

		}
		return user;

	}

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@ApiMethod(name = "getAllUser", httpMethod = "GET")
	public CollectionResponse<UserApi> getUser() {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query q = new Query(UserApi.table);
		PreparedQuery pq = datastore.prepare(q);
		List<UserApi> list = new ArrayList<UserApi>();

		for (Entity e : pq.asIterable()) {
			UserApi u = new UserApi();
			u.setId((long) e.getProperty(UserApi.colId));
			u.setNameUser(e.getProperty(UserApi.colNameUser).toString());

			u.setEmail(e.getProperty(UserApi.colEmail).toString());
			u.setTotalPoints(Long.parseLong(e.getProperty(
					UserApi.colTotalPoints).toString()));
			list.add(u);
		}
		return CollectionResponse.<UserApi> builder().setItems(list)
				.setNextPageToken(null).build();
	}

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities.
	 *        
	 */
	public CollectionResponse<MerchandiseUser> buyMerchandise(
			@Named("idUser") long idUser,
			MerchandisePurchased merchandisePurchased) {
		MerchandiseController merchandiseController = new MerchandiseController();
		UserController userController = new UserController();
		MerchandiseUserController merchandiseUserController = new MerchandiseUserController();
		Merchandise merchandise = merchandiseController.getMerchandiseById(merchandisePurchased.getId());
		List<MerchandiseUser> list = new ArrayList<>();
		if(userController.getData(idUser).getTotalPoints()>=merchandise.getCost()){
		
		
		
		merchandiseUserController.addMerchandise(idUser,
				merchandisePurchased.getId(), merchandisePurchased.getAmout());
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query(MerchandiseUser.table)
				.setFilter(new FilterPredicate(MerchandiseUser.colIdUser,
						FilterOperator.EQUAL, idUser));
		PreparedQuery pq = datastore.prepare(query);
	


		for (Entity ent : pq.asIterable()) {
			Merchandise m = merchandiseController.getMerchandiseById(Long
					.parseLong(ent
							.getProperty(MerchandiseUser.colIdMerchandise)
							.toString()));
			MerchandiseUser merchandiseUser = new MerchandiseUser();
			merchandiseUser.setAmout(Long.parseLong(ent.getProperty(
					MerchandiseUser.colAmout).toString()));
			merchandiseUser.setNomeMerchandise(m.getName());
			merchandiseUser.setId(m.getId());
			merchandiseUser.setIdUser(idUser);
			list.add(merchandiseUser);
		}

		return CollectionResponse.<MerchandiseUser> builder().setItems(list)
				.setNextPageToken(null).build();}
	else{
		
		return CollectionResponse.<MerchandiseUser> builder().setItems(list)
				.setNextPageToken(null).build();
	}
	
	}

	private void addMedalsUser(UserApi user) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		if (user != null && getMedalsType().size() > 0) {
			long id = 1;
			List<MedalsType> listMedalsType = getMedalsType();

			Query query = new Query(MedalsType.table);
			PreparedQuery pq = datastore.prepare(query);

			List<MedalsType> list = new ArrayList<MedalsType>();
			for (Entity e : pq.asIterable()) {
				list.add(new MedalsType((long) e.getProperty(MedalsType.colId),
						e.getProperty(MedalsType.colName).toString(), e
								.getProperty(MedalsType.colDescription)
								.toString()));
			}

			for (MedalsType medalsType : listMedalsType) {
				Query q = new Query(Medals.table);
				PreparedQuery pq1 = datastore.prepare(q);
				id = pq1.asList(FetchOptions.Builder.withDefaults()).size();
				id += 1;
				Key userKey = KeyFactory.createKey(Medals.table, id);
				Entity userEntity = new Entity(userKey);
				userEntity.setProperty(Medals.colIdMedals, userKey.getId());
				userEntity.setProperty(Medals.colUserId, user.getId());
				userEntity.setProperty(Medals.colidMedalType,
						medalsType.getId());
				userEntity.setProperty(Medals.colTotal, 0);
				datastore.put(userEntity);

			}

		}
	}

	private List<MedalsType> getMedalsType() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query(MedalsType.table);
		PreparedQuery pq = datastore.prepare(query);

		List<MedalsType> list = new ArrayList<MedalsType>();
		for (Entity e : pq.asIterable()) {
			list.add(new MedalsType((long) e.getProperty(MedalsType.colId), e
					.getProperty(MedalsType.colName).toString(), e.getProperty(
					MedalsType.colDescription).toString()));
		}
		return list;
	}

}
