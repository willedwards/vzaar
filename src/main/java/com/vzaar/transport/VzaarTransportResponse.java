package com.vzaar.transport;

import java.io.InputStream;

/**
 * Transport response object. This encapsulates the HTTP status code and
 * line as well as the response input stream.
 *
 * @author Marc G. Smith
 */
public class VzaarTransportResponse
{
    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private int statusCode;
    private String statusLine;
    private InputStream response;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Constructor.
     *
     * @param statusCode the HTTP status code
     * @param statusLine the HTTP status line
     * @param response the response stream
     */
    public VzaarTransportResponse(
            int statusCode, String statusLine, InputStream response)
    {
        this.statusCode = statusCode;
        this.statusLine = statusLine;
        this.response = response;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the HTTP status line
     *
     * @return the HTTP status line
     */
    public String getStatusLine() {
        return statusLine;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the response input stream.
     *
     * @return the response input stream
     */
    public InputStream getResponse() {
        return response;
    }

    ///////////////////////////////////////////////////////////////////////////
}