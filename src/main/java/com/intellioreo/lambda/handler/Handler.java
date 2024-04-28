package com.intellioreo.lambda.handler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.intellioreo.lambda.service.DynamoDBService;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


import java.net.URI;
import java.util.List;
public class Handler implements RequestHandler<List<Integer>, Integer>{

    DynamoDBService dynamoDBService = new DynamoDBService();


    @Override
    /*
     * Takes a list of Integers and returns its sum.
     */
    public Integer handleRequest(List<Integer> event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass().toString());
        //dynamoDBService.putItem("IngredientName");
        return event.stream().mapToInt(Integer::intValue).sum();
    }
}
