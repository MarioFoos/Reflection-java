package com.diardon;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class ReflectionApp
{
	public static void main(String[] args)
	{
		inspectClass();
		invokeMethods();
		writeMembers();
		loadClass();
		
	}
	public static void loadClass()
	{
		String pakage = "com.diardon.SampleClass";
		Class<?> klazz;
		try
		{
			klazz = Class.forName(pakage);
			Constructor<?> constructor = klazz.getConstructor();
			Object instance = constructor.newInstance();
			System.out.println(instance instanceof SampleClass); // true
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void writeMembers()
	{
		// Creo un objeto
		SampleClass sample = new SampleClass();
		Class<?> klass = sample.getClass();
		
		// Nuevos números para el array 
		ArrayList<Integer> newNumbers = new ArrayList<>();
		newNumbers.add(0);
		newNumbers.add(4);
		newNumbers.add(6);
		try
		{
			// Muestro antes de modificar
			System.out.println("Antes: " + sample);
			
			Field fNumbers = klass.getDeclaredField("numbers");
			fNumbers.setAccessible(true); 		// Permitir acceso
			fNumbers.set(sample, newNumbers);	// Establecer nuevos números
	
			Field fNum3 = klass.getDeclaredField("num3");
			fNum3.setAccessible(true);
			fNum3.set(sample, 5.31f);
			
			// Muestro después de modificar
			System.out.println("Desp.: " + sample);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void invokeMethods()
	{
		// Creo un objeto
		SampleClass sample = new SampleClass();
		Class<?> klass = sample.getClass();

		// Invoco el método toString
		try
		{
			// Obtengo el método
			Method mToString = klass.getDeclaredMethod("toString");

			// Lo invoco y guardo el resultado
			String ret = (String) mToString.invoke(sample);

			// Muestro en consola
			System.out.println(ret);
			
			// Ahora uso los métodos set y get de str para modificarla
			Method mSet = klass.getDeclaredMethod("setStr", String.class);
			mSet.invoke(sample, "MODIFIED");
			
			Method mGet = klass.getDeclaredMethod("getStr");
			String retStr = (String) mGet.invoke(sample);
			System.out.println("str: " + retStr);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void inspectClass()
	{
		Class<?> klass = SampleClass.class;
		
		System.out.println("Inspeccionar clase: " + klass.getName());
		
		System.out.println();
		System.out.println("Constructores:");
		Constructor<?>[] constructors = klass.getConstructors();
		
		for(int i = 0; i < constructors.length; ++i)
		{
			System.out.println("Constructor #" + (i + 1));
		    System.out.println("Parametros: " + constructors[i].getParameterCount());
		    Parameter[] params = constructors[i].getParameters();
		    for(int p = 0; p < params.length; ++p)
		    {
		    	System.out.println("Param #" + (p + 1) + ": " + params[p].getType());
		    }
		}
		System.out.println();
		System.out.println("Métodos:");
		for(Method method : klass.getDeclaredMethods())
		{
		    System.out.println(method.getName());
		}

		System.out.println();
		System.out.println("Variables:");
		for(Field field : klass.getDeclaredFields())
		{
		    System.out.println(field.getName() + ": " + field.getType());
		}
	}
}
