package com.courseforge.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.courseforge.bussiness.CourseBusiness;
import com.courseforge.bussiness.YoutubeApiBussiness;
import com.courseforge.dto.CourseDTO;
import com.courseforge.dto.YoutubeResponseDTO;
import com.courseforge.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import jakarta.annotation.PostConstruct;


@Configuration
public class BeanConfiguration {

    @Value("classpath:graphql/course.graphqls")
    private Resource resource;

    @Autowired
    YoutubeApiBussiness youtubeApiBussiness;

    @Autowired
    CourseBusiness courseBusiness;

    @Bean
    public GraphQL getGraphQL() throws IOException{
        SchemaParser schemaParser = new SchemaParser(); 
        File file = resource.getFile();
        TypeDefinitionRegistry registry = schemaParser.parse(file);
        RuntimeWiring wiring = getRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        return graphQL;
    }

    private RuntimeWiring getRuntimeWiring() {

        DataFetcher<YoutubeResponseDTO> dataFetcher1 =  (environment) -> {
            return youtubeApiBussiness.getVideoInfo(environment.getArgument("videoId"));
        };

        DataFetcher<List<CourseDTO>> dataFetcher2 =  (environment) -> {
            return courseBusiness.fetchCourseList();
        };

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .type("Query", typeWiring -> typeWiring.dataFetcher("fetchVideoInfo", dataFetcher1))
            .type("Query", typeWiring -> typeWiring.dataFetcher("fetchCourseList", dataFetcher2))
            .build();

        return runtimeWiring;
    }

    

}
