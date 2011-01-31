/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.era7.bioinfo.bioinfoaws.ec2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *
 * @author ppareja
 */
public class InstanceUtil {

    public static final String METADA_INSTANCE_ID_WEB_SERVICE_URL = "http://169.254.169.254/latest/meta-data/instance-id";

    public static String getRunningInstanceId() throws IOException{
        String id = "";

        GetMethod getMethod = new GetMethod(METADA_INSTANCE_ID_WEB_SERVICE_URL);

        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        InputStream inStream = getMethod.getResponseBodyAsStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        id = reader.readLine();
        reader.close();

        return id;
    }

}
