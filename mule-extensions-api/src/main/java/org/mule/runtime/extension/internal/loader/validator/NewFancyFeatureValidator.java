package org.mule.runtime.extension.internal.loader.validator;

import org.mule.runtime.api.meta.model.ExtensionModel;
import org.mule.runtime.extension.api.loader.ExtensionModelValidator;
import org.mule.runtime.extension.api.loader.ProblemsReporter;
import org.mule.sdk.api.annotation.MinMuleVersion;
import org.mule.sdk.api.validation.Validator;

import java.io.OutputStream;

@MinMuleVersion("4.9.0")
public class NewFancyFeatureValidator implements ExtensionModelValidator {

    @Override
    public void validate(ExtensionModel model, ProblemsReporter problemsReporter) {

    }
}
