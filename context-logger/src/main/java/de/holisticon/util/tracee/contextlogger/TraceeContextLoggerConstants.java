package de.holisticon.util.tracee.contextlogger;

/**
 * Created by Tobias Gindler, holisticon AG on 16.12.13.
 */
public final class TraceeContextLoggerConstants {

    @SuppressWarnings("unused")
    private TraceeContextLoggerConstants() {
        // hide constructor
    }

    public final static String SYSTEM_PROPERTY_NAME_STAGE = "de.holisticon.util.tracee.contextlogger.tracee-standard-stage";
    public final static String SYSTEM_PROPERTY_NAME_SYSTEM = "de.holisticon.util.tracee.contextlogger.tracee-standard-system";

    public final static String SYSTEM_PROPERTY_CONTEXT_LOGGER_PRESET = "de.holisticon.util.tracee.contextlogger.preset";
    public final static String SYSTEM_PROPERTY_CONTEXT_LOGGER_PRESET_CLASS = "de.holisticon.util.tracee.contextlogger.preset.class";
}