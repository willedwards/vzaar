package com.vzaar.transport.httpclient4;

import com.vzaar.transport.VzaarTransport;
import com.vzaar.transport.VzaarTransportFactory;

/**
 * Factory for creating commons httpclient4 version of vzaar transport
 *
 * @author Marc G. Smith
 */
public class HttpClientTransportFactory extends VzaarTransportFactory
{
    /**
     * Create a transport instance.
     *
     * @return a new transport instance
     */
    @Override
    public VzaarTransport create() {
        return new HttpClientTransport();
    }
}