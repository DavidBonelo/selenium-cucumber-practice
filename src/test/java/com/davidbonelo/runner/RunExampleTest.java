package com.davidbonelo.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features") // resource package with features
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
// package with step definitions
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.davidbonelo.steps")
@IncludeTags("Registration")
public class RunExampleTest {
}
