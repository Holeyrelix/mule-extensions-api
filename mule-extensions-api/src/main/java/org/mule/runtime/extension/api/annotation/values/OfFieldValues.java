/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.extension.api.annotation.values;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.mule.sdk.api.values.ValueProvider;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks a parameter as having a field or set of fields that have the capability of having its {@link Value values} resolved.
 * This resolution is resolved by the {@link ValueProvider} referenced in {@link OfFieldValues#value()}.
 *
 * @since 1.4
 */
@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Repeatable(OfFieldsValues.class)
@Documented
public @interface OfFieldValues {

  /**
   * @return the paths of the fields of the parameter whose values are resolved by the {@link ValueProvider} referenced
   * in {@link OfFieldValues#value()}.
   * The format of these paths is the name of the fields to access separated by a dot (`.`).
   * For example:
   *
   * This is an example of a possible value for the parameter so that the type of the parameter is understood.
   *   <pre>
   *     {
   *       "routingInfo": {
   *         "channelId": "CHANNEL_ID_VALUE",
   *         "region": "SOUTH"
   *       }
   *         "message": "The message to send"
   *      }
   *    </pre>
   * The fieldPath for the "channelId" field is "routingInfo.channelId."
   *
   * When the given {@link ValueProvider} referenced in {@link OfFieldValues#value()} is a single level provider, the
   * returned array will have only one path. If it is multi-level, the returned array will have the paths of the value
   * parts in order they are resolved.
   * For example:
   *
   * This is an example of a possible value for the parameter so that the type of the parameter is understood.
   *   <pre>
   *     {
   *       "name" : "John"
   *       "occupation" : "Banker"
   *       "location": {
   *         "continent": "CONTINENT",
   *         "country": "COUNTRY",
   *         "city": "CITY"
   *        }
   *     }
   *   </pre>
   *
   * If a multi-level value provider is defined for the fields continent, country and city, the array returned must be
   * ["location.continent", "location.country", "location.city"]
   *
   * All the values must be in the same parameter for multi-level resolution.
   *
   */
  String[] fieldPaths();

  /**
   * @return the associated {@link ValueProvider} for the parameter
   */
  Class<? extends org.mule.runtime.extension.api.values.ValueProvider> value();

  /**
   * @return a boolean indicating if this values are closed or not
   */
  boolean open() default true;
}
