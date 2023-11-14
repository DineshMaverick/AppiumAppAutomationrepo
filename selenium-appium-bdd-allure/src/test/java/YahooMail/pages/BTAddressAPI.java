package YahooMail.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BTAddressAPI {

    public static void main(String[] args) throws Exception {

        // Initialize ExtentReports and ExtentTest
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        spark.config().setDocumentTitle("API Test Report");
        spark.config().setReportName("API Test Automation Report");
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("BTAddressAPI Test", "Test to validate the API response");

        try {
            // Set base URI
            RestAssured.baseURI = "https://api-sandbox.ee.co.uk";

            // Make API request
            Response response = RestAssured.given()
                    .header("X-EE-EL-Tracking-Header", "9d9f15a5-234c-46b5-9e18-99c6eb394b86")
                    .header("Authorization", "Bearer CSeG6styenHCwIGkICmRBWrzCmgX")
                    .header("X-EE-API-Originator", "MyCompany")
                    .queryParam("buildingNameOrNumber", "131")
                    .queryParam("postcode", "TW33AE")
                    .get("/v1/address");

            // Print response body
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
            test.log(Status.INFO, "Response Body: " + responseBody);

            // Extract and print list ID
            String listId = response.jsonPath().getString("listId");
            System.out.println("List ID: " + listId);
            test.log(Status.INFO, "List ID: " + listId);

            // Use Jackson to map JSON response to Java objects
            List<Map<String, Object>> partialAddresses = response.jsonPath().getList("partialAddresses");

            for (Map<String, Object> address : partialAddresses) {
                String searchId = (String) address.get("id");
                System.out.println("Search ID: " + searchId);
                test.log(Status.INFO, "Search ID: " + searchId);

                // Extract and print href values under links
                List<Map<String, String>> links = (List<Map<String, String>>) address.get("links");
                for (Map<String, String> link : links) {
                    String href = link.get("href");
                    System.out.println("Href: " + href);
                    test.log(Status.INFO, "Href: " + href);
                }
            }

            test.pass("API test passed");

        } catch (Exception e) {
            test.fail("API test failed");
         
        } finally {
            extent.flush();
        }
    }
}
