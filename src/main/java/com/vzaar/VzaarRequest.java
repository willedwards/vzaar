package com.vzaar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Request helper class. This base class provides a map for requests. This class
 * stores request parameters in a map and provides a mechanism to add new
 * parameters without the need for the request objects needing to be updated.
 *
 * @author Marc G. Smith
 */
class VzaarRequest
{
    ///////////////////////////////////////////////////////////////////////////
    // Protected Members //////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    protected Map<String, String> parameters;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the parameter map. The map is not modifiable. To edit the parameters
     * call the putParameter() and removeParameter() methods.
     *
     * @return the parameter map.
     */
    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(parameters);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Add a parameter to the request map. If the value is null then it is
     * removed from the parameter map.
     *
     * @param name the parameter name
     * @param value the parameter value
     */
    public void putParameter(String name, Object value) {
        if(value == null) {
            parameters.remove(name);
        }
        else {
            parameters.put(name, String.valueOf(value));
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Remove a parameter from the request.
     *
     * @param name the name of the parameter to remove
     */
    public void removeParameter(String name) {
        parameters.remove(name);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the value for a given parameter.
     *
     * @param name the name of the parameter
     * @return the value of the named parameter or null if not set
     */
    public String getParameter(String name) {
        return parameters.get(name);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Protected Methods //////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Empty request parameter constructor.
     */
    protected VzaarRequest() {
        this(new HashMap<String, String>());
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Initialised parameter constructor.
     *
     * @param parameters the initial parameters to construct the object with.
     */
    protected VzaarRequest(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the value as an integer or null if it doesn't exist.
     *
     * @param name the name of the parameter
     * @return the value of the named parameter or null if not set
     */
    protected Integer getInteger(String name) {
        String value = getParameter(name);
        if(value != null) {
            try {
                return new Integer(value);
            }
            catch(NumberFormatException e) {}
        }
        return null;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the value as an boolean or null if it doesn't exist.
     *
     * @param name the name of the parameter
     * @return the value of the named parameter or null if not set
     */
    protected Boolean getBoolean(String name) {
        String value = getParameter(name);
        if(value != null) {
            try {
                return new Boolean(value);
            }
            catch(NumberFormatException e) {}
        }
        return null;
    }

    ///////////////////////////////////////////////////////////////////////////
}