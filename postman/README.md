# Postman Api Tests - L2Calculator

'L2Calculator_API.postman_collection.json' is a Postman collection that contains tests set for the L2Calculator l2calculator.api.
All requests use a collection-level variable called **baseUrl**, which defines the base URL of the l2calculator.api 

The collection includes various automated tests for endpoints such as:

- **GET** - used to retrieve data such as available towns or algorithms.
- **POST** - used to submit user inputs and receive calculated results.

Tests are designed to validate l2calculator.api's behavior, ensuring that it returns correct status code and objectives value: 

- **HTTP Status Code**: The expected HTTP status code for the response ('200 OK', '400 BAD REQUEST').
- **Objects**: Ensuring it contains expected fields and matches types.
- **Error-path tests**: Validating that the l2calculator.api handles errors correctly, such as missing required fields or invalid inputs.

# Tested Functionalities:
1. *GET /towns/all*: Retrieves a list of available towns.
2. *GET /algorithms/all*: Retrieves a list of available algorithms.
3. *POST /calculate*: Submits user inputs for calculation and retrieves results. Also testing error handling for invalid inputs.

# How to run Tests:

To execute the tests, need to ensure l2calculator environment for tests us up and running. the l2calculator.api Postman tests depends on *Docker Container*, so Docker Desktop must be installed and running.

## Environment Setup:
1. **Docker Desktop**: Needed to run app and database containers.
2. **Postman**: Used to run the test collection.

Start both containers by running:
```bash
docker compose up
```

## Running Tests in Postman:
1. Make sure both services are running.
2. Import the collection into Postman:
   - Open Postman.
   - Click on "Import".
   - Select:`L2Calculator_API.postman_collection.json` file.
3. Set the **baseUrl** variable in the collection:
   - Click the 'L2Calculator_API' collection.
   - Open the 'Variables' tab.
   - Set `baseUrl`as variable and in Initial value and Current Value set `http://localhost:3000`.
   - Click 'Save'. 
4. Run the collection:
   - Go to the 'L2Calculator_API' tab.
   - Click the 'Run' button.
   - Next click 'Run L2Calculator_API' button.