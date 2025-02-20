package com.diardon;

import java.util.ArrayList;

public class SampleClass
{
	private String str;
	private Double num1;
	private ArrayList<Integer> numbers;
	private int num2;
	private float num3;
	
	public SampleClass()
	{
		this("wasd1234", 1.23, new ArrayList<>(), 7, 3.21f);

		// Cargo algunos número al array
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
	}
	public SampleClass(String str, Double num1, ArrayList<Integer> numbers, int num2, float num3)
	{
		super();
		this.str = str;
		this.num1 = num1;
		this.numbers = numbers;
		this.num2 = num2;
		this.num3 = num3;
	}
	@Override
	public String toString()
	{
		return "SampleClass [str=" + str + ", num1=" + num1 + ", numbers=" + numbers + ", num2=" + num2 + ", num3=" + num3 + "]";
	}
	public void setStr(String str)
	{
		this.str = str;
	}
	public String getStr()
	{
		return str;
	}
	// Agrego esta anotación solamente para mostrarla en la lista de anotaciones
	@Deprecated
	public void setNumbers(ArrayList<Integer> numbers)
	{
		this.numbers = numbers;
	}
	public ArrayList<Integer> getNumbers()
	{
		return numbers;
	}
}
