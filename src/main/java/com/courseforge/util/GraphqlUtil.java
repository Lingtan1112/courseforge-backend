package com.courseforge.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class GraphqlUtil {
    

    public File file;
    
    @PostConstruct
    public void loadGraphQlFile() throws IOException{
        String filePath = "graphql/course.graphqls";

        try {
            ClassLoader classLoader = getClass().getClassLoader();

            URI resourceUri = classLoader.getResource(filePath).toURI();

            this.file = new File(resourceUri);

            if (file.exists()) {
                System.out.println("File exists: " + file.getAbsolutePath());
            } else {
                System.err.println("File not found: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getGraphQlFile(){
        return this.file;
    }

}
