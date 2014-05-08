package com.vzaar;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

//import org.apache.xpath.XPathAPI;
import com.sun.org.apache.xpath.internal.XPathAPI;

/**
 * Package private helper class for XML parsing and formatting.
 *
 * @author Marc G. Smith
 */
class XmlHelper
{
    ///////////////////////////////////////////////////////////////////////////

    /**
     *  Parses an XML file and returns a DOM document.
     *
     *  @param response the input stream
     *  @return the DOM model
     */
    static Document parseXml(InputStream response)
            throws VzaarException
    {
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            factory.setValidating(false);

            Document doc = factory.newDocumentBuilder().parse(
                    response);
            return doc;
        }
        catch (Exception e) {
            throw new VzaarException(e.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Extract the value of the first child tag of the supplied node and
     * parse as an integer.
     *
     * @param document the parent node
     * @param tag the tag whose value should be returned
     * @return the value as an integer or 0 if not found.
     */
    static int getInteger(Node document, String tag)
            throws VzaarException
    {
        String value = getValue(document, tag);
        if(value != null) {
            try {
                return new Integer(value);
            }
            catch(NumberFormatException e) {}
        }
        return 0;
    }
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Extract the value of the first child tag of the supplied node and
     * parse as a long.
     *
     * @param document the parent node
     * @param tag the tag whose value should be returned
     * @return the value as an integer or 0 if not found.
     */
    static long getLong(Node document, String tag)
            throws VzaarException
    {
        String value = getValue(document, tag);
        if(value != null) {
            try {
                return new Long(value);
            }
            catch(NumberFormatException e) {}
        }
        return 0;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Extract the value of the first child tag of the supplied node and
     * parse as a double.
     *
     * @param document the parent node
     * @param tag the tag whose value should be returned
     * @return the value as an double or 0 if not found.
     */
    static double getDouble(Node document, String tag)
            throws VzaarException
    {
        String value = getValue(document, tag);
        if(value != null) {
            try {
                return new Double(value);
            }
            catch(NumberFormatException e) {}
        }
        return 0;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Extract the value of the first child tag of the supplied node and
     * parse as a boolean.
     *
     * @param document the parent node
     * @param tag the tag whose value should be returned
     * @return the value as an boolean or false if not found.
     */
    static boolean getBoolean(Node document, String tag)
            throws VzaarException
    {
        String value = getValue(document, tag);
        if(value != null) {
            try {
                return new Boolean(value);
            }
            catch(Exception e) {}
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Extract the value of the first child tag of the supplied node.
     *
     * @param document the parent node
     * @param tag the tag whose value should be returned
     * @return the value or null if not found.
     */
    static String getValue(Node document, String tag)
            throws VzaarException
    {
        String value = null;
        try {
            Node node = XPathAPI.selectSingleNode(document, tag + " | */" + tag + "| */*/" + tag);
            if(node != null) value = node.getTextContent();
        }
        catch (TransformerException e) {
            throw new VzaarException(e.getMessage(), e);
        }

        return value;
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Get a list of child nodes with the given tag.
     *
     * @param document the parent node
     * @param tag the tag of the type of child nodes to return
     * @return an iterator of the child nodes that match the tag
     */
    static NodeIterator getNodes(Document document, String tag)
            throws VzaarException
    {
        try {
            return XPathAPI.selectNodeIterator(document, "//" + tag);
        }
        catch (TransformerException e) {
            throw new VzaarException(e.getMessage(), e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Process request XML for use with formatter.
     * Takes four parameters - the GUI, the title, the description and
     * the profile type.
     */
    final static String PROCESS_VIDEO =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<vzaar_api>\n" +
                    "   <video>\n" +
                    "      <guid>%s</guid>\n" +
                    "      <title>%s</title>\n" +
                    "      <description>%s</description>\n" +
                    "      <profile>%s</profile>\n" +
                    "   </video>\n" +
                    "</vzaar_api>\n";


    ///////////////////////////////////////////////////////////////////////////

    /**
     * Delete request XML.
     */
    final static String DELETE_VIDEO =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<vzaar_api>\n" +
                    "   <_method>delete</_method>\n" +
                    "</vzaar_api>\n";

    ///////////////////////////////////////////////////////////////////////////

    /**
     * Change video request XML.
     * Takes two parameters -the title and the description.
     */
    final static String EDIT_VIDEO =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<vzaar_api>\n" +
                    "   <_method>put</_method>\n" +
                    "   <video>\n" +
                    "      <title>%s</title>\n" +
                    "      <description>%s</description>\n" +
                    "   </video>\n" +
                    "</vzaar_api>\n";

    ///////////////////////////////////////////////////////////////////////////
}