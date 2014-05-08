package com.vzaar.transport.httpclient4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

/**
 * SSL socket factory to override TLS problem with either nginx 0.6.xx
 * or haproxy.
 *
 * @author Marc G. Smith
 */
public class Ssl3OnlyProtocolFactory implements LayeredSocketFactory
{

    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private SSLSocketFactory delegate;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public Ssl3OnlyProtocolFactory(SocketFactory delegate) {
        this.delegate = (SSLSocketFactory) delegate;
    }

    ///////////////////////////////////////////////////////////////////////////

    public Socket connectSocket(
            Socket arg0, String arg1, int arg2,
            InetAddress arg3, int arg4, HttpParams arg5)
            throws IOException, UnknownHostException, ConnectTimeoutException
    {
        return delegate.connectSocket(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    ///////////////////////////////////////////////////////////////////////////

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
            throws IOException, UnknownHostException, ConnectTimeoutException
    {
        SSLSocket sslSocket = (SSLSocket) delegate.createSocket(socket, host, port, autoClose);
        sslSocket.setEnabledProtocols(new String[] { "SSLv3" });
        return sslSocket;
    }

    ///////////////////////////////////////////////////////////////////////////

    public Socket createSocket() throws IOException {
        SSLSocket sslSocket = (SSLSocket) delegate.createSocket();
        sslSocket.setEnabledProtocols(new String[] { "SSLv3" });
        return sslSocket;
    }

    ///////////////////////////////////////////////////////////////////////////

    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return delegate.isSecure(socket);
    }

    ///////////////////////////////////////////////////////////////////////////
}