/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-08-21 15:27:30 UTC)
 * on 2013-08-23 at 18:33:11 UTC 
 * Modify at your own risk.
 */

package com.appspot.planetwarapi.merchandise;

/**
 * Service definition for Merchandise (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MerchandiseRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Merchandise extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.15.0-rc of the  library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://planetwarapi.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "merchandise/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Merchandise(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Merchandise(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "addMerchardise".
   *
   * This request holds the parameters needed by the the merchandise server.  After setting any
   * optional parameters, call the {@link AddMerchardise#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.appspot.planetwarapi.merchandise.model.Merchandise}
   * @return the request
   */
  public AddMerchardise addMerchardise(com.appspot.planetwarapi.merchandise.model.Merchandise content) throws java.io.IOException {
    AddMerchardise result = new AddMerchardise(content);
    initialize(result);
    return result;
  }

  public class AddMerchardise extends MerchandiseRequest<com.appspot.planetwarapi.merchandise.model.Merchandise> {

    private static final String REST_PATH = "add";

    /**
     * Create a request for the method "addMerchardise".
     *
     * This request holds the parameters needed by the the merchandise server.  After setting any
     * optional parameters, call the {@link AddMerchardise#execute()} method to invoke the remote
     * operation. <p> {@link AddMerchardise#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.appspot.planetwarapi.merchandise.model.Merchandise}
     * @since 1.13
     */
    protected AddMerchardise(com.appspot.planetwarapi.merchandise.model.Merchandise content) {
      super(Merchandise.this, "POST", REST_PATH, content, com.appspot.planetwarapi.merchandise.model.Merchandise.class);
    }

    @Override
    public AddMerchardise setAlt(java.lang.String alt) {
      return (AddMerchardise) super.setAlt(alt);
    }

    @Override
    public AddMerchardise setFields(java.lang.String fields) {
      return (AddMerchardise) super.setFields(fields);
    }

    @Override
    public AddMerchardise setKey(java.lang.String key) {
      return (AddMerchardise) super.setKey(key);
    }

    @Override
    public AddMerchardise setOauthToken(java.lang.String oauthToken) {
      return (AddMerchardise) super.setOauthToken(oauthToken);
    }

    @Override
    public AddMerchardise setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (AddMerchardise) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public AddMerchardise setQuotaUser(java.lang.String quotaUser) {
      return (AddMerchardise) super.setQuotaUser(quotaUser);
    }

    @Override
    public AddMerchardise setUserIp(java.lang.String userIp) {
      return (AddMerchardise) super.setUserIp(userIp);
    }

    @Override
    public AddMerchardise set(String parameterName, Object value) {
      return (AddMerchardise) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getAllMerchardise".
   *
   * This request holds the parameters needed by the the merchandise server.  After setting any
   * optional parameters, call the {@link GetAllMerchardise#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public GetAllMerchardise getAllMerchardise() throws java.io.IOException {
    GetAllMerchardise result = new GetAllMerchardise();
    initialize(result);
    return result;
  }

  public class GetAllMerchardise extends MerchandiseRequest<com.appspot.planetwarapi.merchandise.model.CollectionResponseMerchandise> {

    private static final String REST_PATH = "collectionresponse_merchandise";

    /**
     * Create a request for the method "getAllMerchardise".
     *
     * This request holds the parameters needed by the the merchandise server.  After setting any
     * optional parameters, call the {@link GetAllMerchardise#execute()} method to invoke the remote
     * operation. <p> {@link GetAllMerchardise#initialize(com.google.api.client.googleapis.services.Ab
     * stractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected GetAllMerchardise() {
      super(Merchandise.this, "GET", REST_PATH, null, com.appspot.planetwarapi.merchandise.model.CollectionResponseMerchandise.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetAllMerchardise setAlt(java.lang.String alt) {
      return (GetAllMerchardise) super.setAlt(alt);
    }

    @Override
    public GetAllMerchardise setFields(java.lang.String fields) {
      return (GetAllMerchardise) super.setFields(fields);
    }

    @Override
    public GetAllMerchardise setKey(java.lang.String key) {
      return (GetAllMerchardise) super.setKey(key);
    }

    @Override
    public GetAllMerchardise setOauthToken(java.lang.String oauthToken) {
      return (GetAllMerchardise) super.setOauthToken(oauthToken);
    }

    @Override
    public GetAllMerchardise setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetAllMerchardise) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetAllMerchardise setQuotaUser(java.lang.String quotaUser) {
      return (GetAllMerchardise) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetAllMerchardise setUserIp(java.lang.String userIp) {
      return (GetAllMerchardise) super.setUserIp(userIp);
    }

    @Override
    public GetAllMerchardise set(String parameterName, Object value) {
      return (GetAllMerchardise) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getMerchardiseById".
   *
   * This request holds the parameters needed by the the merchandise server.  After setting any
   * optional parameters, call the {@link GetMerchardiseById#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetMerchardiseById getMerchardiseById(java.lang.Long id) throws java.io.IOException {
    GetMerchardiseById result = new GetMerchardiseById(id);
    initialize(result);
    return result;
  }

  public class GetMerchardiseById extends MerchandiseRequest<com.appspot.planetwarapi.merchandise.model.Merchandise> {

    private static final String REST_PATH = "merchandise/{id}";

    /**
     * Create a request for the method "getMerchardiseById".
     *
     * This request holds the parameters needed by the the merchandise server.  After setting any
     * optional parameters, call the {@link GetMerchardiseById#execute()} method to invoke the remote
     * operation. <p> {@link GetMerchardiseById#initialize(com.google.api.client.googleapis.services.A
     * bstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetMerchardiseById(java.lang.Long id) {
      super(Merchandise.this, "GET", REST_PATH, null, com.appspot.planetwarapi.merchandise.model.Merchandise.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetMerchardiseById setAlt(java.lang.String alt) {
      return (GetMerchardiseById) super.setAlt(alt);
    }

    @Override
    public GetMerchardiseById setFields(java.lang.String fields) {
      return (GetMerchardiseById) super.setFields(fields);
    }

    @Override
    public GetMerchardiseById setKey(java.lang.String key) {
      return (GetMerchardiseById) super.setKey(key);
    }

    @Override
    public GetMerchardiseById setOauthToken(java.lang.String oauthToken) {
      return (GetMerchardiseById) super.setOauthToken(oauthToken);
    }

    @Override
    public GetMerchardiseById setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetMerchardiseById) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetMerchardiseById setQuotaUser(java.lang.String quotaUser) {
      return (GetMerchardiseById) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetMerchardiseById setUserIp(java.lang.String userIp) {
      return (GetMerchardiseById) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetMerchardiseById setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetMerchardiseById set(String parameterName, Object value) {
      return (GetMerchardiseById) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Merchandise}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Merchandise}. */
    @Override
    public Merchandise build() {
      return new Merchandise(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link MerchandiseRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMerchandiseRequestInitializer(
        MerchandiseRequestInitializer merchandiseRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(merchandiseRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
