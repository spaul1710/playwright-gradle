package Pages;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.HashMap;
import java.util.Map;

public class PatchAPIRequest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            APIRequestContext requestContext = playwright.request().newContext();

            String apiKey="reqres-free-v1";
            // Define the request URL
            String url = "https://reqres.in/api/users/2";
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("name", "morpheus");
            requestBody.put("job", "zion resident");
            RequestOptions requestOptions=RequestOptions.create().setHeader("x-api-key",apiKey).setData(requestBody);


            // Define the request body as a Map


            // Send the PATCH request
            APIResponse response = requestContext.patch(url, requestOptions);

            // Verify the response status code
            System.out.println("Status code: " + response.status());

            // Verify the response body
            String responseBody = response.text();
            System.out.println("Response body: " + responseBody);

            // Dispose the context
            requestContext.dispose();
        }
    }

}
