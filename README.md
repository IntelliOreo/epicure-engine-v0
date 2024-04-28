Invoking function locally through local API Gateway

Start DynamoDB Local in a Docker container. 
`docker run -p 8000:8000 amazon/dynamodb-local`

Check connection with 
`aws dynamodb list-tables --endpoint-url http://localhost:8000`

Create the DynamoDB table. 

>aws dynamodb create-table \
--table-name RecipeIngredients \
--attribute-definitions \
AttributeName=IngredientName,AttributeType=S \
AttributeName=ThirdPartyRecipeID,AttributeType=S \
--key-schema \
AttributeName=IngredientName,KeyType=HASH \
AttributeName=ThirdPartyRecipeID,KeyType=RANGE \
--billing-mode PAY_PER_REQUEST \
--endpoint-url http://localhost:8000

Start the SAM local API.

On a Mac:
`sam local start-api --env-vars src/test/resources/test_environment_mac.json`

On Windows: 
`sam local start-api --env-vars src/test/resources/test_environment_windows.json`

clean up work dir
`rm -rf .aws-sam`

