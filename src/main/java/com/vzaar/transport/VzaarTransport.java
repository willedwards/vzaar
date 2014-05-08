package com.vzaar.transport;

import java.io.File;
import java.io.OutputStream;
import java.util.Map;

import com.vzaar.UploadProgressCallback;
import com.vzaar.VzaarException;

/**
 * Interface for handling the transport to <a href="http://vzzar.com">vzaar.com</a>.
 * If you want to use a custom HTTP client or roll your own then this class
 * needs to be implemented and registered with the {@link VzaarTransportFactory}.
 *
 * @author Marc G. Smith
 */
public interface VzaarTransport
{
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Set the base API URL, such as http://vzaar.com/api/
     *
     * @param url the base API URL
     */
    void setUrl(String url);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Send any get request. If OAuth credentials have been added then OAuth
     * authentication headers should be sent with each request.
     *
     * @param uri the method URI
     * @param parameters request parameters.
     */
    VzaarTransportResponse sendGetRequest(
            String uri, Map<String, String> parameters)
            throws VzaarException;

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Set the OAuth 2 party tokens. If these are supplied then all calls to
     * <a href="http://vzaar.com/">vzaar.com</a> will send OAuth credentials.
     *
     * @param token the users login name
     * @param secret the secret token supplied by vzaar
     */
    void setOAuthTokens(String token, String secret);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Send any post request. If OAuth credentials have been added then OAuth
     * authentication headers are sent.
     *
     * @param uri the method URI
     * @param parameters request parameters
     * @return the call response
     */
    VzaarTransportResponse sendPostRequest(String uri,
                                           Map<String, String> parameters)
            throws VzaarException;

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Send a post request with an XML body. If OAuth credentials have been
     * added then OAuth authentication headers are sent.
     *
     * @param uri the method URI
     * @param xml the XML content for the body of the request
     * @return the call response
     */
    VzaarTransportResponse sendPostXmlRequest(
            String uri, String xml)
            throws VzaarException;

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Upload a file to S3. This method doesn't use OAuth. If the callback is
     * not null then the method should send progress reports to the callback.
     * There is no need to call the error or complete calls on the callback
     * as these are done by the Vzaar calling class.
     *
     * @param url The full url to the S3 bucket
     * @param parameters the query parameters to send
     * @param file the file to upload
     * @param callback the callback to register for updates or null if not
     *  required
     * @return the call response
     */
    VzaarTransportResponse uploadToS3(String url,
                                      Map<String, String> parameters, File file,
                                      UploadProgressCallback callback)
            throws VzaarException;

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Add debugging output. Set to null to stop debugging.
     *
     * @param out the output stream to send debug output to.
     */
    void setDebugStream(OutputStream out);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Set the connection factory to use SSLv3 only, i.e. no TLS. This
     * is for an issue with production servers where SSL is failing.
     */
    void setSsl3Only();

    ///////////////////////////////////////////////////////////////////////////
}