package com.vzaar;

import java.io.File;

/**
 * Interface for monitoring upload progress. Clients should implement this
 * interface to get progress or report progress. Progress reports are up to
 * the implementing transport but should be approximately every 1%. There
 * should also be a guarantee that either error or complete is called at
 * the end of the process.
 *
 * @author Marc G. Smith
 */
public interface UploadProgressCallback
{
    ///////////////////////////////////////////////////////////////////////////

    /**
     * An error occurred during the upload progress.
     *
     * @param file the file being uploaded that the error occurred on
     * @param error the error cause
     */
    void error(File file, String error);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * A progress update.
     *
     * @param file the file being uploaded
     * @param sent the number of bytes sent so far
     * @param length the total number of bytes to be uploaded
     */
    void progress(File file, long sent, long length);

    ///////////////////////////////////////////////////////////////////////////

    /**
     * The upload procedure has completed if an error hasn't occurred.
     *
     * @param file the file being uploaded
     * @param videoId the video id of the uploaded video
     */
    void complete(File file, int videoId);

    ///////////////////////////////////////////////////////////////////////////
}