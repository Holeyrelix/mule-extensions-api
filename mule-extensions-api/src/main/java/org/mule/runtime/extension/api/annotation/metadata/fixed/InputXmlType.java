/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.runtime.extension.api.annotation.metadata.fixed;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.mule.metadata.api.model.MetadataFormat;
import org.mule.metadata.api.model.MetadataType;
import org.mule.runtime.api.meta.model.parameter.ParameterModel;
import org.mule.sdk.api.annotation.MinMuleVersion;

import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Declares the annotated {@link ParameterModel}'s {@link MetadataType} to the type represented by the provided element in the XSD
 * Schema.
 * <p>
 * Can only be used on {@link String} or {@link InputStream} parameters in order to be correctly coerced.
 *
 * @since 1.1
 */
@MinMuleVersion("4.1")
@Retention(RUNTIME)
@Target({PARAMETER})
public @interface InputXmlType {

  /**
   * @return the XSD schema file where the element to be loaded is defined. The schema must live in the extension resources in
   *         order to be located.
   */
  String schema();

  /**
   * @return the qualified name used to reference the element to be loaded within the provided {@link InputXmlType#schema()}.
   */
  String qname();
}
