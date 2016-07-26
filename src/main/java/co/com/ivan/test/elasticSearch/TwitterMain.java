package co.com.ivan.test.elasticSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Hello world!
 *
 */
public class TwitterMain {
	public static List searchForTweets() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		System.out.println("  User: "+twitter.getScreenName());
		Query query = new Query("Millonarios FC");
		List tweetList = new ArrayList();
		for (int i = 0; i < 10; i++) {
			QueryResult queryResult = twitter.search(query);
			tweetList.addAll(queryResult.getTweets());
			if (!queryResult.hasNext()) {
				break;
			}
			query = queryResult.nextQuery();
		}
		Gson gson = new Gson();

		return (List) tweetList.stream().map(gson::toJson).collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) throws TwitterException {
		List<String> str = searchForTweets();
	}
}
