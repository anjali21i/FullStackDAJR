package com.core.fullstack.java8feature.streams;

import java.util.stream.Stream;

public class StreamPractice3 {

	public static void main(String args[]) {
//		String
		var cities = """
				  San Francisco
				  Casablanca
				  Antwerp
				  New Delhi
				  Osaka
				""";

		Stream<String> lines = cities.lines();
		String hh = "";
		System.out.println(lines.toList());

		var message = """
				{"name" : "%s", "language" : "Java"}""";

		var bbb = "{\"name\" : \"%s\", \"language\" : \"Java\"}";
		System.out.println(message.formatted("Duke"));
		System.out.println(bbb.formatted("Duke"));
		System.out.println(bbb == message);

		String cities2 = """
				New York   \s
				Paris      \s
				Bangalore  \s
				Singapore  \s
				Tokyo      \s
				""";

		cities2.lines().map(line -> "|" + line + "|").forEach(System.out::println);
	}

}
