package com.mkk.ugd.string_usage;

public final class StringUtil
{
	private StringUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void stringBuilderTestEt(int iterasyonSayisi)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < iterasyonSayisi; i++) 
		{
			stringBuilder.append(" ");
		}
	}
	
	public static void stringBufferTestEt(int iterasyonSayisi)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < iterasyonSayisi; i++) 
		{
			stringBuffer.append(" ");
		}
	}
	
	public static void stringConcatTest(int iterasyonSayisi)
	{
		String str = new String();
		
		for (int i = 0; i < iterasyonSayisi; i++) 
		{
			str = str + " ";
		}
	}
}
