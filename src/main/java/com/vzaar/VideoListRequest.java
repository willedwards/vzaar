package com.vzaar;

/**
 * Request parameter object for the video list request.
 *
 * @author Marc G. Smith
 */
public class VideoListRequest extends VzaarRequest
{
    ///////////////////////////////////////////////////////////////////////////
    // Request Parameter Names ////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    protected static final String COUNT = "count";
    protected static final String PAGE  = "page";
    protected static final String LIST_ONLY = "list_only";
    protected static final String SORT = "sort";
    protected static final String SIZE = "size";
    protected static final String TITLE = "title";

    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private String username;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Construct a video list request for the given username. This object
     * can be reused for different users by calling setUsername(). It is
     * not thread safe obviously.
     *
     * @param username the vzaar login name for the user
     */
    public VideoListRequest(String username) {
        this.username = username;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The vzaar login name for the user. Note: This must be the user name
     * and not the email address.
     *
     * @return username the vzaar login name for the user
     */
    public String getUsername() {
        return username;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The vzaar login name for the user. Note: This must be the user name
     * and not the email address.
     *
     * @param username the vzaar login name for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Specifies the number of videos to retrieve per page. Default is 20.
     * Maximum is 100.
     *
     * @return the number of videos to retrieve per page
     */
    public Integer getCount() {
        return getInteger(COUNT);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Specifies the number of videos to retrieve per page. Default is 20.
     * Maximum is 100.
     *
     * @param count the number of videos to retrieve per page
     */
    public void setCount(Integer count) {
        putParameter(COUNT, count);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Specifies the page number to retrieve. Default is 1.
     *
     * @return the page number to retrieve
     */
    public Integer getPage() {
        return getInteger(PAGE);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Specifies the page number to retrieve. Default is 1.
     *
     * @param page the page number to retrieve
     */
    public void setPage(Integer page) {
        putParameter(PAGE, page);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * When returning data, only include the minimum fields (those marked
     * as 'always')
     *
     * @return only include the minimum fields
     */
    public Boolean getListOnly() {
        return getBoolean(LIST_ONLY);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * When returning data, only include the minimum fields (those marked
     * as 'always')
     *
     * @param listOnly only include the minimum fields
     */
    public void setListOnly(Boolean listOnly) {
        putParameter(LIST_ONLY, listOnly);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Should sort ascending (least recent) or descending (most recent).
     *
     * @return should sort ascending
     */
    public Boolean getSortAscending() {
        return "asc".equals(getBoolean(SORT));
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Should sort ascending (least_recent) or descending (most_recent).

     * @param sortAscending should sort by least recent
     */
    public void setSortAscending(Boolean sortAscending) {
        putParameter(SORT,
                (sortAscending != null && sortAscending == true) ?
                        "asc" : "desc");
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Include (or not) size (width and height) of a video. Defaults to false.
     *
     * @return should the size of the video be returned
     */
    public Boolean getSize() {
        return getBoolean(SIZE);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Include (or not) size (width and height) of a video. Defaults to false.
     *
     * @param size should the size of the video be returned
     */
    public void setSize(Boolean size) {
        putParameter(SIZE,  size);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Return only videos with title containing given string.
     *
     * @return the title search string
     */
    public String getTitleSearch() {
        return getParameter(TITLE);
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Return only videos with title containing given string.
     *
     * @param titleSearch the title search string
     */
    public void setTitleSearch(String titleSearch) {
        putParameter(TITLE,  titleSearch);
    }

    ///////////////////////////////////////////////////////////////////////////
}