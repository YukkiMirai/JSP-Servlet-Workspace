package com.luv2code.jsp;

import java.util.*;

public class Solution {
	public static void main(String[] args) {

		ArrayList<String> items = new ArrayList<String>();
		items.add("111   1");
		items.add("112   1");
		items.add("111      15");
		for (String temp : items) {
			System.out.println(temp);
		}
	}
}
