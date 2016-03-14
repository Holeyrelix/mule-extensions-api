/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extension.api.introspection;

import org.mule.api.connection.ConnectionProvider;

import java.util.List;
import java.util.Set;

/**
 * Immutable implementation of {@link ConnectionProviderModel}
 *
 * @param <Config>     the generic type for the configuration objects that the returned {@link ConnectionProvider providers} accept
 * @param <Connection> the generic type for the connections that the returned  {@link ConnectionProvider providers} produce
 * @since 1.0
 */
public class ImmutableConnectionProviderModel<Config, Connection> extends AbstractParameterizedModel implements ConnectionProviderModel<Config, Connection>
{

    private final Class<Config> configurationType;
    private final Class<Connection> connectionType;

    /**
     * Creates a new instance with the given state
     *
     * @param name              the provider's name
     * @param description       the provider's description
     * @param configurationType the {@link Class} of the objects accepted as configs
     * @param connectionType    the {@link Class} of the provided connections
     * @param parameterModels   a {@link List} with the provider's {@link ParameterModel parameterModels}
     * @param modelProperties   A {@link Set} of custom properties which extend this model
     * @throws IllegalArgumentException if {@code connectionProviderFactory}, {@code configurationType} or {@code connectionType} are {@code null}
     */
    public ImmutableConnectionProviderModel(String name,
                                            String description,
                                            Class<Config> configurationType,
                                            Class<Connection> connectionType,
                                            List<ParameterModel> parameterModels,
                                            Set<ModelProperty> modelProperties)
    {
        super(name, description, modelProperties, parameterModels);


        checkArgument(configurationType != null, "configurationType cannot be null");
        checkArgument(connectionType != null, "connectionType cannot be null");

        this.configurationType = configurationType;
        this.connectionType = connectionType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Config> getConfigurationType()
    {
        return configurationType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Connection> getConnectionType()
    {
        return connectionType;
    }
}
