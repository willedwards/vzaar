package com.vzaar;

/**
 * The details and rights for each <a href="http://vzaar.com">vzaar</a>
 * account type.
 *
 * @author Marc G. Smith
 */
public class AccountType
{
    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private double version;
    private int accountId;
    private String title;
    private int monthly;
    private String currency;
    private long bandwidth;
    private boolean borderless;
    private boolean searchEnhancer;

    ///////////////////////////////////////////////////////////////////////////
    // Public and Package Protected Methods ///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Package protected constructor.
     *
     * @param version the vzaar API version number
     * @param accountId the vzaar account ID
     * @param title the name of the vzaar account
     * @param monthly the monthly cost of the account in the given currency
     * @param currency the currency the account is charged in. Currently this
     * 			is only in dollars
     * @param bandwidth the amount of monthly bandwidth allocated to a user
     * 			for video service and playing
     * @param borderless if the user is allowed to use a player with no skin
     * @param searchEnhancer if the user is allowed to optimize where google
     * 			directs video traffic
     */
    AccountType(double version, int accountId, String title, int monthly,
                String currency, long bandwidth, boolean borderless,
                boolean searchEnhancer)
    {
        this.version = version;
        this.accountId = accountId;
        this.title = title;
        this.monthly = monthly;
        this.currency = currency;
        this.bandwidth = bandwidth;
        this.borderless = borderless;
        this.searchEnhancer = searchEnhancer;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The vzaar API version number.
     *
     * @return the vzaar API version number
     */
    public double getVersion() {
        return version;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The vzaar account ID.
     *
     * @return the vzaar account ID
     */
    public int getAccountId() {
        return accountId;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The name of the vzaar account.
     *
     * @return the name of the vzaar account
     */
    public String getTitle() {
        return title;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The monthly cost of the account in the given currency.
     *
     * @return the monthly cost of the account in the given currency
     */
    public int getMonthly() {
        return monthly;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The currency the account is charged in. Currently this is only in
     * dollars.
     *
     * @return the currency the account is charged in
     */
    public String getCurrency() {
        return currency;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The amount of monthly bandwidth allocated to a user for video service
     * and playing.
     *
     * @return the amount of monthly bandwidth allocated
     */
    public long getBandwidth() {
        return bandwidth;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Is the user is allowed to use a player with no skin.
     *
     * @return is the user is allowed to use a player with no skin
     */
    public boolean isBorderless() {
        return borderless;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Is the user is allowed to optimize where google directs video traffic.
     * @return is the user is allowed to optimize where google directs video
     * 	traffic
     */
    public boolean isSearchEnhancer() {
        return searchEnhancer;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * String representation of the contents of this account bean.
     */
    public String toString() {
        return
                "version=" + version +
                        ", accountId=" + accountId +
                        ", title=" + title +
                        ", monthly=" + monthly +
                        ", currency=" + currency +
                        ", bandwidth=" + bandwidth +
                        ", borderless=" + borderless +
                        ", searchEnhancer=" + searchEnhancer;
    }

    ///////////////////////////////////////////////////////////////////////////
}