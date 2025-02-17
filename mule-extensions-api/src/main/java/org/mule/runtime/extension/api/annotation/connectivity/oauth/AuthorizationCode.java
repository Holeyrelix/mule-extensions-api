/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.extension.api.annotation.connectivity.oauth;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static org.mule.runtime.extension.api.security.CredentialsPlacement.BODY;

import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.extension.api.security.CredentialsPlacement;
import org.mule.sdk.api.annotation.MinMuleVersion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * To be used on implementations of {@link ConnectionProvider}, indicates that the provided connections will be authenticated
 * using Authorization-Code grant type of the OAuth2 specification.
 * <p>
 * This annotation also contains a series of properties which describe the OAuth provider to authenticate against.
 * <p>
 * The annotated {@link ConnectionProvider} is still free to implement {@link PoolingConnectionProvider} or
 * {@link CachedConnectionProvider} interfaces if needed, but connectivity testing will be disabled.
 *
 * @since 1.0
 */
@MinMuleVersion("4.1")
@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface AuthorizationCode {

  /**
   * @return The Url of the endpoint which provides the access tokens
   */
  String accessTokenUrl();

  /**
   * @return The url of the authorization endpoint which starts the OAuth dance
   */
  String authorizationUrl();

  /**
   * @return Expression to be used on the response of {@link #accessTokenUrl()} to extract the access token
   */
  String accessTokenExpr() default "#[payload.access_token]";

  /**
   * @return Expression to be used on the response of {@link #accessTokenUrl()} to extract the access token expiration
   */
  String expirationExpr() default "#[payload.expires_in]";

  /**
   * @return Expression to be used on the response of {@link #accessTokenUrl()} to extract the refresh token
   */
  String refreshTokenExpr() default "#[payload.refresh_token]";

  /**
   * @return The default set of scopes to be requested, as a comma separated list. Empty string means no default scopes.
   */
  String defaultScopes() default "";

  /**
   * Allows to customize the placement that the client credentials will have in the request.
   *
   * @return the selected {@link CredentialsPlacement}. Defaults to {@link CredentialsPlacement#BODY}
   *
   * @since 1.4.0
   */
  CredentialsPlacement credentialsPlacement() default BODY;

  /**
   * Whether the redirect_uri parameter should be included in the refresh token request. Defaults to {@code true}
   *
   * @since 1.4.0
   */
  boolean includeRedirectUriInRefreshTokenRequest() default true;
}
