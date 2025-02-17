/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.extension.api.annotation;

import static org.mule.runtime.api.meta.ExpressionSupport.SUPPORTED;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.api.meta.model.parameter.ParameterModel;
import org.mule.sdk.api.annotation.MinMuleVersion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows customizing how a {@link ParameterModel} supports expressions.
 *
 * @since 1.0
 */
@MinMuleVersion("4.1")
@Target(value = {ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Expression {

  /**
   * The type of expression support that parameters defined through this annotations should have.
   * <p>
   * Defaults to {@link ExpressionSupport#SUPPORTED}
   *
   * @return a {@link ExpressionSupport}
   */
  ExpressionSupport value() default SUPPORTED;
}
