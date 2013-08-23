package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hsqldb.Collation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Data.GeneratedStatus;
import com.Data.Medals;
import com.Data.MedalsType;
import com.Data.MedalsWin;
import com.Data.Status;
import com.Data.UserApi;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class TestApi {

	public void test() {

	}

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void addMedalsType() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		assertEquals(medalType, testMedals.addMedalsType(medalType));
	}

	@Test
	public void getListMedalType() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);
		MedalsType medalType2 = new MedalsType();
		medalType2.setDescription("description2");
		medalType2.setId(2L);
		medalType2.setName("medal2");
		testMedals.addMedalsType(medalType2);
		assertNotNull(testMedals.listMedalsType());
	}

	@Test
	public void addUser() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);

		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		assertEquals(userApi, testUser.add(userApi));
	}

	@Test
	public void updateDataUser() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);

		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);

		userApi.setEmail("juan@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("juan");
		userApi.setTotalPoints(50);
		assertEquals(userApi, testUser.udateData(userApi));
	}

	@Test
	public void getMeldasUser() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);

		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);
		assertNotNull(testMedals.getMedalsUser(userApi.getId()));
	}

	@SuppressWarnings({ "static-access", "null", "unused" })
	@Test
	public void updateMedalsUser() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);

		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);

		MedalsWin medalsWin = new MedalsWin();
		medalsWin.setAmout(10);
		medalsWin.setNameMedal("medal");
		List<MedalsWin> cMWins = new ArrayList<MedalsWin>();
		cMWins.add(medalsWin);
		CollectionResponse<MedalsWin> crMedalsWin = CollectionResponse
				.<MedalsWin> builder().setItems(cMWins).setNextPageToken(null)
				.build();

		CollectionResponse<Medals> medalsUser = testMedals
				.getMedalsUser(userApi.getId());

		testMedals.updateMedalsUser(crMedalsWin, userApi.getId());

		CollectionResponse<Medals> medalsUserUpdate = testMedals
				.getMedalsUser(userApi.getId());
		assertNotEquals(medalsUser, medalsUserUpdate);
	}

	@Test
	public void getMedalsUser() throws OAuthRequestException {
		TestMedals testMedals = new TestMedals();
		MedalsType medalType = new MedalsType();
		medalType.setDescription("description");
		medalType.setId(1L);
		medalType.setName("medal");
		testMedals.addMedalsType(medalType);

		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);
		assertNotNull(testMedals.getMedalsUser(userApi.getId()));

	}

	@Test
	public void addStatus() throws OAuthRequestException {
		TestStatus testStatus = new TestStatus();
		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);

		Status status = new Status();
		status.setGameDraw(1);
		status.setGameLost(0);
		status.setGameWin(0);
		status.setId(1L);
		status.setStatusGameDraw("100%");
		status.setStatusGameLost("0%");
		status.setStatusGameWin("0%");
		status.setTotal(1L);
		status.setUserId(userApi.getId());

		GeneratedStatus generatedStatus = new GeneratedStatus();
		generatedStatus.setGameDraw("1");
		generatedStatus.setGameLost("0");
		generatedStatus.setGameWin("0");
		generatedStatus.setUserId(String.valueOf(userApi.getId()));
		Status resultStatus= testStatus.add(generatedStatus);
		assertNotEquals(status, resultStatus);
	}
	
	@Test
	public void updateStatus() throws OAuthRequestException{
		TestStatus testStatus = new TestStatus();
		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);

		Status status = new Status();
		status.setGameDraw(2);
		status.setGameLost(0);
		status.setGameWin(0);
		status.setId(1L);
		status.setStatusGameDraw("100%");
		status.setStatusGameLost("0%");
		status.setStatusGameWin("0%");
		status.setTotal(2L);
		status.setUserId(userApi.getId());

		GeneratedStatus generatedStatus = new GeneratedStatus();
		generatedStatus.setGameDraw("1");
		generatedStatus.setGameLost("0");
		generatedStatus.setGameWin("0");
		generatedStatus.setUserId(String.valueOf(userApi.getId()));
		testStatus.add(generatedStatus);
		generatedStatus.setGameDraw("2");
		generatedStatus.setGameLost("0");
		generatedStatus.setGameWin("0");
		Status resultStatus= testStatus.update(generatedStatus);
		
		assertNotEquals(status, resultStatus);
		
	}

	public void getStatus() throws OAuthRequestException{
		TestStatus testStatus = new TestStatus();
		TestUser testUser = new TestUser();
		UserApi userApi = new UserApi();
		userApi.setEmail("gammer@gammer.com");
		userApi.setId(1L);
		userApi.setNameUser("gammer");
		userApi.setTotalPoints(0);
		testUser.add(userApi);

		Status status = new Status();
		status.setGameDraw(1);
		status.setGameLost(0);
		status.setGameWin(0);
		status.setId(1L);
		status.setStatusGameDraw("100%");
		status.setStatusGameLost("0%");
		status.setStatusGameWin("0%");
		status.setTotal(2L);
		status.setUserId(userApi.getId());

		GeneratedStatus generatedStatus = new GeneratedStatus();
		generatedStatus.setGameDraw("1");
		generatedStatus.setGameLost("0");
		generatedStatus.setGameWin("0");
		generatedStatus.setUserId(String.valueOf(userApi.getId()));
		testStatus.add(generatedStatus);
		Status resultStatus= testStatus.get(userApi.getId());
			assertEquals(status, resultStatus);
	}
}
