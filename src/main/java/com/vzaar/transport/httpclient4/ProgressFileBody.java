package com.vzaar.transport.httpclient4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.entity.mime.content.FileBody;

import com.vzaar.UploadProgressCallback;

/**
 * Extension of File Part to allow monitoring of upload progress
 * of data. A registered callback is called roughly every 1% of
 * callback with a final call on completion.
 *
 * @author Marc G. Smith
 */
class ProgressFileBody extends FileBody
{
    ///////////////////////////////////////////////////////////////////////////
    // Private Members ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private MonitoringOutputStream out;
    private UploadProgressCallback callback;
    private File file;

    ///////////////////////////////////////////////////////////////////////////
    // Public Methods /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Construct a progress monitoring enabled file part.
     *
     * @param file the file to upload
     * @param callback the callback for progress information.
     */
    public ProgressFileBody(
            File file, UploadProgressCallback callback)
            throws FileNotFoundException
    {
        super(file);
        this.file = file;
        this.callback = callback;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Override the FileBody method and add a monitoring output stream
     * to send progress information from.
     *
     * @param out the output stream to wrap and send data to.
     */
    public void writeTo(OutputStream out) throws IOException {
        if(this.out == null) {
            this.out = new MonitoringOutputStream(out, getContentLength());
        }
        super.writeTo(this.out);
        callback.progress(file, this.out.getSentCount(), this.out.getLength());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Inner Class: MonitoringOutputStream ////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    /**
     * This is a wrapper for the output stream which counts the bytes and
     * sends progress updates to the registered callback.
     */
    private class MonitoringOutputStream extends OutputStream
    {
        private OutputStream delegate;
        private long count;
        private long length;
        private long interval;
        private long nextInterval;

        private MonitoringOutputStream(
                OutputStream delegate, long length)
        {
            this.delegate = delegate;
            this.length = length;
            this.interval = length / 100;
        }

        @Override
        public void write(int b) throws IOException {
            if(count == nextInterval) {
                callback.progress(file, count, length);
                nextInterval += interval;
            }
            count++;
            delegate.write(b);
        }

        public long getSentCount() {
            return count;
        }

        public long getLength() {
            return length;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
}