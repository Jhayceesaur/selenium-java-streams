package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams 
{
	
	@Test
	public void StreamsFilterOne() 
	{
		//Print count of values that starts with letter "B"
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Indigo");
		colors.add("Violet");
		colors.add("Black");
		colors.add("Brown");
		
		Long c = colors.stream().filter(s->s.startsWith("B")).count();
		System.out.println(c);
		System.out.println("////////////////////////1");
	}
	
	@Test
	public void StreamsFilterTwo() 
	{
		Long d = Stream.of("Basketball", "Badminton", "Bowling", "Volleyball", "Football", "Soccer").filter(s-> 
		{
			s.startsWith("B");
			//return false; // -- Will display 0 as value
			return true; // -- Will print all values that start with letter "B"
		}).count();
		System.out.println(d);
		System.out.println("////////////////////////2");
	}
	
	@Test
	public void StreamsFilterThree() 
	{
		ArrayList<String> rainbow = new ArrayList<String>();
		rainbow.add("Red");
		rainbow.add("Orange");
		rainbow.add("Yellow");
		rainbow.add("Green");
		rainbow.add("Blue");
		rainbow.add("Indigo");
		rainbow.add("Violet");
		//rainbow.stream().filter(s->s.length()>4).forEach(s->System.out.println(s)); //Print values in the array list that is greater than 4 letters
		rainbow.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s)); //Print first value in the array list that is greater than 4 letters
		System.out.println("////////////////////////3");
	}	
	
	@Test
	//Print values which have letter that ends with "i" and convert it to upper case
	public void StreamsMapOne()
	{
		Stream.of("Honda", "Yamaha", "Suzuki", "SYM", "Kawasaki", "Ducati")
			.filter(s->s.endsWith("i"))
			.map(s->s.toUpperCase())
			.forEach(s->System.out.println(s));
		System.out.println("////////////////////////4");
	}
	
	@Test
	public void StreamsMapTwo() 
	{
		ArrayList<String> animals1 = new ArrayList<String>();
		animals1.add("Tiger");
		animals1.add("Dog");
		animals1.add("Cat");
		
		//Print values that starts with "T" and convert it to upper case and sort alphabetically in order
		List<String> animals2 = Arrays.asList("Lion", "Anaconda", "Bear", "Goat", "Aligator", "Crow");
		animals2.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging 2 different lists
		Stream<String> newStream = Stream.concat(animals1.stream(), animals2.stream());
		//newStream.sorted().forEach(s->System.out.println(s)); //--Merging and printing 2 different list syntax
		
		//Verify and print value/s that match the merged list
		boolean animal = newStream.anyMatch(s->s.equalsIgnoreCase("TiGeR"));
		System.out.println(animal);
		Assert.assertTrue(animal);
		System.out.println("////////////////////////5");
	}
	
	@Test
	//Print value that ends with "i" and is placed in the index 1 then convert to upper case
	public void StreamsCollectOne() 
	{
		List <String> motor = Stream.of("Honda", "Yamaha", "Suzuki", "SYM", "Kawasaki", "Ducati")
		.filter(s->s.endsWith("i"))
		.map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(motor.get(1));
		System.out.println("////////////////////////6");	
	}
	
	@Test
	public void StreamsCollectTwo() 
	{
		//Prints the unique numbers in the array list
		List<Integer> numbers = Arrays.asList(7,7,7,11,9,5,11,21,11,3);
		numbers.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("////////////////////////7");
	}
	
	@Test
	public void StreamsCollectThree() 
	{
		//Prints the unique numbers in the array list
		List<Integer> numbers = Arrays.asList(4,4,4,8,6,2,12,12,10);
		numbers.stream().distinct().forEach(s->System.out.println(s));
		
		//Print the value placed in index #5 sorted from the unique numbers in array list
		List<Integer> digit = numbers.stream().distinct().sorted().collect(Collectors.toList()); 
		System.out.println("Value in index #5 is: " + digit.get(5));
		System.out.println("////////////////////////8");
	}

}

//**NOTE** 
//Case Sensitive to outputs that are expected
//There is no life for intermediate operation if there is no terminal operation
//Terminal operation will execute only if intermediate operation (filter) returns true
