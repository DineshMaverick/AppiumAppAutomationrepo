package YahooMail.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.FormBody;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BTLoginAPI {

    public static void main(String[] args) throws IOException {

        // Initialize ExtentReports and ExtentTest
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extentloginreport.html");
        spark.config().setDocumentTitle("Login API Test Report");
        spark.config().setReportName("Login API Test Automation Report");
        extent.attachReporter(spark);

        ExtentTest test = extent.createTest("BTLoginAPI Test", "Test to validate the API response");

        try {
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("grant_type", "client_credentials")
                    .build();
            String encodedCredentials = "M3ZnWllQcmRSNElmZlpJZ21Ob3pnNFZNUFpQQ2tyVVg6aHFpUUo1RUlzc2Z1VGh0Sg==";
            String url = "https://api.platform.bt.com/oauth/accesstoken";
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .header("Authorization", "Basic " + encodedCredentials)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();

            System.out.println("Full request:");
            System.out.println(request);

            okhttp3.Response response = client.newCall(request).execute();

            String accessToken = response.body().string();
            System.out.println("Access Token: " + accessToken);
            test.log(Status.INFO, "Access Token: " + accessToken);

            String Token = parseAccessToken(accessToken);

            test.pass("API test passed");

        } catch (Exception e) {
            test.fail("API test failed");
            
        } finally {
            extent.flush();
        }
    }

    public static String parseAccessToken(String body) {
        // Extract the access token value from the response body using string manipulation
        int startIndex = body.indexOf("\"access_token\":\"") + "\"access_token\":\"".length();
        int endIndex = body.indexOf("\"", startIndex);

        return body.substring(startIndex, endIndex);
    }
}
