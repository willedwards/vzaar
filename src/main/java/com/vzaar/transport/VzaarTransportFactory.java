package com.vzaar.transport;

import com.vzaar.transport.httpclient4.HttpClientTransportFactory;


/**
 * VzaarTransport factory class. By default it uses a the commons HTTP
 * Client 4 implementation but this can replaced by calling
 * setDefaultFactory();
 *
 * Implementing transports need to create a factory instance that
 * implements the create() method.
 *
 * @author Marc G. Smith
 */
public abstract class VzaarTransportFactory
{
    ///////////////////////////////////////////////////////////////////////////
    // Private Static Members /////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private static VzaarTransportFactory factory =
            new HttpClientTransportFactory();

    ///////////////////////////////////////////////////////////////////////////
    // Public Static Methods //////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get the default registered factory.
     *
     * @return the default factory
     */
    public static VzaarTransportFactory getDefaultFactory() {
        return factory;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Set the default factory.
     *
     * @param factory the default factory
     */
    public static void setDefaultFactory(VzaarTransportFactory factory) {
        VzaarTransportFactory.factory = factory;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Create a transport instance using the default transport factory.
     *
     * @return a new transport instance
     */
    public static VzaarTransport createDefaultTransport() {
        return factory.create();
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Create a transport instance.
     *
     * @return a new transport instance
     */
    public abstract VzaarTransport create();

    ///////////////////////////////////////////////////////////////////////////

}