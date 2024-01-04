package com.core.fullstack.java8feature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// Sample dataset - List of MyData<T> objects with a generic type
		List<MyData<Integer>> dataList = Arrays.asList(new MyData<>(1, 100), new MyData<>(2, 200), new MyData<>(3, 300),
				new MyData<>(4, 400), new MyData<>(5, 500));

		// Example operations using Stream API on the MyData<T> dataset

		// 1. Mapping - Get all data values
		List<Integer> values = dataList.stream().map(MyData::getData).collect(Collectors.toList());
		System.out.println("Data Values: " + values);

		// 2. Filtering - Get data where value > 300
		List<MyData<Integer>> filteredData = dataList.stream().filter(data -> data.getData() > 300)
				.collect(Collectors.toList());
		System.out.println("Filtered Data: " + filteredData);

		// 3. Sorting - Sort data by value
		List<MyData<Integer>> sortedData = dataList.stream()
				.sorted((data1, data2) -> Integer.compare(data1.getData(), data2.getData()))
				.collect(Collectors.toList());
		System.out.println("Sorted Data: " + sortedData);

		// 4. Reduction - Calculate sum of all data values
		int sum = dataList.stream().mapToInt(MyData::getData).sum();
		System.out.println("Sum of Data Values: " + sum);
	}

}

class MyData<T> {
	private int id;
	private T data;

	public MyData(int id, T data) {
		this.id = id;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "MyData{" + "id=" + id + ", data=" + data + '}';
	}
}