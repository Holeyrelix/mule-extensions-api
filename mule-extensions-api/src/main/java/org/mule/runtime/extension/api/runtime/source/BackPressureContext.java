/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.extension.api.runtime.source;

import org.mule.api.annotation.NoImplement;
import org.mule.runtime.api.event.Event;
import org.mule.sdk.api.annotation.MinMuleVersion;

/**
 * Provides information about how the runtime applied back pressure on a certain {@link #getEvent() event}
 *
 * @since 1.1
 */
@MinMuleVersion("4.1")
@NoImplement
public interface BackPressureContext {

  /**
   * @return the {@link BackPressureAction} that was applied
   */
  BackPressureAction getAction();

  /**
   * @return The rejected {@link Event}
   */
  Event getEvent();

  /**
   * @return the {@link SourceCallbackContext} used when pushing the message down the flow
   */
  SourceCallbackContext getSourceCallbackContext();
}
