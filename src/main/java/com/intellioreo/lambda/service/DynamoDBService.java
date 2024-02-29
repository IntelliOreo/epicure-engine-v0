package com.intellioreo.lambda.service;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;

public class DynamoDBService {
    private final DynamoDbClient dynamoDbClient;

    public DynamoDBService(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    public void putItem(String tableName, Map<String, AttributeValue> item) {
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();
        dynamoDbClient.putItem(request);
    }

    // Additional methods for interacting with DynamoDB
}

