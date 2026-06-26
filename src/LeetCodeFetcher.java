import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCodeFetcher {

    public static void main(String[] args) throws Exception {
        String slug = "two-sum";
        System.out.println("slug : "+slug);

        String body = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder()
                        .uri(URI.create("https://leetcode.com/graphql"))
                        .header("Content-Type", "application/json")
                        .header("Referer", "https://leetcode.com/problems/" + slug + "/")
                        .POST(HttpRequest.BodyPublishers.ofString(
                                "{\"query\":\"query($titleSlug:String!){question(titleSlug:$titleSlug){questionFrontendId title difficulty likes dislikes acRate topicTags{name} content}}\",\"variables\":{\"titleSlug\":\"" + slug + "\"}}"
                        ))
                        .build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        System.out.println(body);
        Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(body);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }


        System.out.println("Hello");
    }


}
