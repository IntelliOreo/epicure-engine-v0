package com.intellioreo.lambda.service;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBService {
    DynamoDbClient client = DynamoDbClient.builder()
            .region(Region.US_EAST_1)
            .endpointOverride(URI.create("http://localhost:8000"))
            .credentialsProvider(StaticCredentialsProvider.create(
                    AwsBasicCredentials.create("abcdefg", "abcdefg")))
            .build();

    public void putItem(String tableName) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("IngredientName", AttributeValue.builder().s("fakeIngredient1").build());
        item.put("ThirdPartyRecipeID", AttributeValue.builder().s("fakeId1").build());
        // For RecipeIngredients, assuming you want to store them as a list of strings
        item.put("RecipeIngredients", AttributeValue.builder().l(
                AttributeValue.builder().s("fakeIngredient1").build(),
                AttributeValue.builder().s("fakeIngredient2").build()
        ).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        client.putItem(request);
    }

    // Additional methods for interacting with DynamoDB
}

