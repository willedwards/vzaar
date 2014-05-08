package com.vzaar;

/**
 * Vzaar exception general use class.
 *
 * @author Marc G. Smith
 */
public class VzaarException extends Exception
{
    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private static final long serialVersionUID = 1L;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     * The cause is not initialised.
     */
    public VzaarException() {
        super();
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Constructs a new exception with the specified cause and a detail
     * message.
     *
     * @param  cause the cause A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
    public VzaarException(String message, Throwable cause) {
        super(message, cause);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Constructs a new exception with a detail
     * message.
     *
     * @param  message the detail message
     */
    public VzaarException(String message) {
        super(message);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Constructs a new exception with the specified cause and a detail
     * message.
     *
     * @param  cause the cause A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
    public VzaarException(Throwable cause) {
        super(cause);
    }

    ///////////////////////////////////////////////////////////////////////////
}