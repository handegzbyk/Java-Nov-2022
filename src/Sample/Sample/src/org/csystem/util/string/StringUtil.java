/*----------------------------------------------------------
	FILE			: StringUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 16.04.2023
	
	Utility class for string operations
	
	Copyleft (c) 1993 C and System Programmers Association 
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.string;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;

public class StringUtil {
	public static String capitalize(String s)
	{
		return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}

	public static String changeCase(String s)
	{
		char [] c = s.toCharArray();

		for (int i = 0; i < c.length; ++i)
			c[i] = Character.isUpperCase(c[i]) ? Character.toLowerCase(c[i]) : Character.toUpperCase(c[i]);

		return String.valueOf(c);
	}

	public static int countString(String s1, String s2)
	{
		int count = 0;

		for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
			;

		return count;
	}

	public static int countStringIgnoreCase(String s1, String s2)
	{
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}

	public static String getRandomText(Random r, int n, String text)
	{
		char [] c = new char[n];
		int len = text.length();

		for (int i = 0; i < n; ++i)
			c[i] = text.charAt(r.nextInt(len));

		return String.valueOf(c);
	}

	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new Random(), n);
	}

	public static String getRandomTextEN(Random r, int n)
	{
		return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyzABCDEFGHIJKLMNOPQRSTUWXYZ");
	}

	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new Random(), n);
	}

	public static String getRandomTextTR(Random r, int n)
	{
		return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ");
	}

	public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			char cLeft = Character.toLowerCase(s.charAt(left));

			if (!Character.isLetter(cLeft)) {
				++left;
				continue;
			}

			char cRight = Character.toLowerCase(s.charAt(right));

			if (!Character.isLetter(cRight)) {
				--right;
				continue;
			}

			if (cLeft != cRight)
				return false;

			++left;
			--right;
		}

		return true;
	}

	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();

		for (int i = 0; i < len; ++i)
			if (!s.contains(alphabet.charAt(i) + ""))
				return false;

		return true;
	}

	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
	}

	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
	}

	public static String join(String [] str, String delimiter)
	{
		throw new UnsupportedOperationException("TODO:");
	}

	public static String join(String [] str, char delimiter)
	{
		return join(str, String.valueOf(delimiter));
	}

	public static String padLeading(String s, int len)
	{
		return padLeading(s, len, ' ');
	}

	public static String padLeading(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : (ch + "").repeat(len - length) + s;
	}

	public static String padTrailing(String s, int len)
	{
		return padTrailing(s, len, ' ');
	}

	public static String padTrailing(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : s + (ch + "").repeat(len - length);
	}

	public static String reverse(String str)
	{
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return String.valueOf(c);
	}
}

