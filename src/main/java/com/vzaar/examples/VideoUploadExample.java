package com.vzaar.examples;

import com.vzaar.Vzaar;
import com.vzaar.Vzaar.Profile;
import com.vzaar.VzaarException;

import java.io.File;

/**
 * Example showing the video upload command.
 *
 * @author Marc G. Smith
 */
public class VideoUploadExample
{
    ///////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        try {
            ParameterHelper helper = new ParameterHelper(args);
            args = helper.getRemainingArgs();
            if(args.length != 4) {
                printUsage();
                System.exit(1);
                return;
            }

            Vzaar vzaar = helper.createVzaar();
            vzaar.uploadVideo(
                    args[0],
                    args[1],
                    Profile.toEnum(Integer.parseInt(args[2])),
                    new File(args[3]),
                    new VideoUploadCallbackExample());
        }
        catch(VzaarException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
        catch(Exception e) {
            printUsage();
            System.exit(1);
        }

    }

    ///////////////////////////////////////////////////////////////////////////

    private static final  void printUsage()
    {
        System.out.println("Usage: vzaar-upload " +
                ParameterHelper.getCommonCommandLineArgs() +
                " <title> <description> <profile> <video>\n");
        System.out.println("   <title>             " +
                "The video title");
        System.out.println("   <description>       " +
                "The video description");
        System.out.println("   <profile>           " +
                "The video size profile: 1=Small, 2=Medium, 3=Large, 4=HD, 5=Original");
        System.out.println("   <video  >           " +
                "The video file to upload");
        System.out.println(ParameterHelper.getCommonCommandLineHelp());
    }

    ///////////////////////////////////////////////////////////////////////////
}