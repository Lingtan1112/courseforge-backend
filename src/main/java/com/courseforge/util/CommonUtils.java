package com.courseforge.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.google.gson.JsonObject;

public class CommonUtils {

    public static byte[] convertObjectToByteArray(Object object) throws IOException{
        byte[] responseAsBytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        oos.close();
        responseAsBytes = bos.toByteArray();
        return responseAsBytes;
    }

    public static Object convertByteArrayToObject(byte[] byteArray) throws IOException, ClassNotFoundException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object finalObject = objectInputStream.readObject();
        return finalObject;
    }
    
}
