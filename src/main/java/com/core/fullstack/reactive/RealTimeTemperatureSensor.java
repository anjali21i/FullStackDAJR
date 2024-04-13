package com.core.fullstack.reactive;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class RealTimeTemperatureSensor {

	public static void main(String[] args) {
		// Simulating a real-time data stream of temperature readings from multiple
		// sensors
		Flux<Double> temperatureStream = Flux.interval(Duration.ofSeconds(1)).map(i -> generateTemperatureReading());
		
		// Subscribe to the temperature stream and process the readings
		temperatureStream.subscribe(temperature -> processTemperatureReading(temperature),
				error -> System.err.println("Error occurred: " + error),
				() -> System.out.println("Temperature stream completed"));

		// Wait for a while to observe the stream
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Random temperature between 0 and 100
	private static double generateTemperatureReading() {
		return new Random().nextDouble() * 100;
	}

	private static void processTemperatureReading(double temperature) {
		System.out.println("Received temperature reading: " + temperature);

		// processing based on the temp reading
		if (temperature > 80) {
			System.out.println("High temperature detected! Alerting...");
		}
		if (temperature < 8) {
			System.out.println("Cold Waves detected! Alerting...");
		}
	}
}
