package com.intellioreo.lambda.handler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.intellioreo.lambda.service.DynamoDBService;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.List;
public class Handler implements RequestHandler<List<Integer>, Integer>{

    DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
            .build(); // Customize the builder as necessary, e.g., setting the region

    DynamoDBService dynamoDBService = new DynamoDBService(dynamoDbClient);
    @Override
    /*
     * Takes a list of Integers and returns its sum.
     */
    public Integer handleRequest(List<Integer> event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass().toString());
        return event.stream().mapToInt(Integer::intValue).sum();
    }
}
