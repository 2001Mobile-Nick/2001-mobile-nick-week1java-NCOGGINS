package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		phrase = phrase.replaceAll("-", " ");
		String[] words = phrase.split(" ");
		String result = "";
		char letter;
		for (int i = 0; i < words.length; i++) {
			letter = words[i].charAt(0);
			result += letter;
		}
		return result.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			if (this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		string = string.toLowerCase();
		char current;
		int result = 0;
		for (int i = 0; i < string.length(); i++) {
			current = string.charAt(i);
			switch (current) {
			case 'a':
			case 'e':
			case 'i':
			case 'l':
			case 'n':
			case 'o':
			case 'r':
			case 's':
			case 't':
			case 'u':
				result += 1;
				break;
			case 'd':
			case 'g':
				result += 2;
				break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				result += 3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				result += 4;
				break;
			case 'k':
				result += 5;
				break;
			case 'j':
			case 'x':
				result += 8;
				break;
			case 'q':
			case 'z':
				result += 10;
				break;
			default:
				break;
			}
		}
		return result;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replace(" ", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		string = string.replace(".", "");
		int length = string.length();

		if (length > 11) {
			throw new IllegalArgumentException();
		}

		String result = "";
		for (int i = 0; i < length; i++) {
			if (Character.isDigit(string.charAt(i))) {
				result += string.charAt(i);
			}
		}
		return result;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] words = null;
		if (string.contains("\n")) {
			words = string.split(",\n");
		} else if (string.contains(",")) {
			words = string.split(",");
		} else {
			words = string.split(" ");
		}
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
			} else {
				map.put(words[i], 1);
			}
		}
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		@SuppressWarnings("unchecked")
		public int indexOf(T t) {
			int length = sortedList.size() - 1;
			int index = length / 2;
			List<T> tempList = null;
			if (sortedList.get(index).equals(t) == true) {
				return index;
			} else if (sortedList.get(index).compareTo(t) < 0) {
				tempList.add((T) sortedList.subList(0, index));
			} else if (sortedList.get(index).compareTo(t) > 0) {
				tempList.add((T) sortedList.subList(index + 1, sortedList.size() - 1));
				setSortedList(tempList);
				indexOf(t);
			}
			// TODO Write an implementation for this method declaration
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String vowels = "aeiou";
		String result = "";
		String[] words = string.split(" ");
		String temp;

		for (int word = 0; word < words.length; word++) {
			char first = words[word].charAt(0);
			for (int vowel = 0; vowel < vowels.length(); vowel++) {
				if (vowels.charAt(vowel) == first || first == 'q' || first == 's' || first == 't') {
					if ((words[word].charAt(1) == 'u')) {
						temp = words[word].substring(2);
						result += temp + "quay";
						break;
					} else if (words[word].charAt(1) == 'c') {
						temp = words[word].substring(3);
						result += temp + "schay";
						break;
					} else if ((words[word].charAt(1) == 'h')) {
						temp = words[word].substring(2);
						result += temp + "thay";
						break;
					} else {
						result += words[word] + "ay";
						break;
					}
				} else {
					if (vowel + 1 == vowels.length()) {
						char tempch = words[word].charAt(0);
						result += words[word].substring(1) + tempch + "ay";
						break;
					}
				}
			}
			if (words.length - 1 != word) {
				result += " ";
			}
		}
		return result;

	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String numbers = Integer.toString(input);
		int digit;
		int sum = 0;
		for (int i = 0; i < numbers.length(); i++) {
			digit = Integer.parseInt(numbers.substring(i, i + 1));
			sum += Math.pow(digit, numbers.length());
		}

		if (sum == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> result = new ArrayList<Long>();
		while (l % 2 == 0) {
			result.add((long) 2);
			l /= 2;
		}
		for (long i = 3; i <= l / i; i += 2) {
			while (l % i == 0) {
				l /= i;
				result.add(i);
			}
		}
		if (l > 2) {
			result.add(l);
		}
		return result;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String capital = alphabet.toUpperCase();
			String result = "";
			char next;
			int index;
			for (int i = 0; i < string.length(); i++) {
				next = string.charAt(i);

				if (alphabet.indexOf(next) != -1) {
					index = alphabet.indexOf(next);
					index = (index + key) % 26;
					next = alphabet.charAt(index);
				} else if (capital.indexOf(next) != -1) {
					index = capital.indexOf(next);
					index = (index + key) % 26;
					next = capital.charAt(index);
				}
				result += next;
			}
			return result;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int count = 1;
		int current = 2;
		if (i < 1) {
			throw new IllegalArgumentException();
		}

		while (count < i) {
			boolean prime = true;
			current++;
			for (int j = 2; j < current; j++) {
				if (current % j == 0) {
					prime = false;
					break;
				}

			}
			if (prime) {
				count++;
			}

		}
		return current;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		static String alphabet = "abcdefghijklmnopqrstuvwxyz";
		static String capitalAlphabet = alphabet.toUpperCase();
		static String reversed = "";
		static String reversedCapital;
		static char front;
		static char back;
		static char temp;
		static String tempString;

		static {
			for (int i = 0; i < alphabet.length(); i++) {
				reversed += alphabet.charAt(alphabet.length() - (i + 1));
			}
			reversedCapital = reversed.toUpperCase();
		}

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String result = "";
			int index;
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				if (alphabet.indexOf(string.charAt(i)) != -1) {
					index = alphabet.indexOf(string.charAt(i));
					result += reversed.charAt(index);
				} else if (capitalAlphabet.indexOf(string.charAt(i)) != -1) {
					index = capitalAlphabet.indexOf(string.charAt(i));
					result += reversedCapital.charAt(index);
				} else if (Character.isDigit(string.charAt(i))) {
					result += string.charAt(i);
				}
				count++;
			}
			result = result.replaceAll("(.{" + "5" + "})", "$1 ").trim();
			return result.toLowerCase();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.replace(" ", "");
			String result = "";
			int index;
			for (int i = 0; i < string.length(); i++) {
				if (Character.isDigit(string.charAt(i))) {
					result += string.charAt(i);
				} else {
					index = reversed.indexOf(string.charAt(i));
					result += alphabet.charAt(index);
				}
			}
			return result;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String numbers = "";
		int sum = 0;
		boolean result = false;

		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				numbers += string.charAt(i);
			} else if (string.charAt(i) == 'X') {
				numbers += string.charAt(i);
			}
		}
		if (numbers.length() != 10) {
			return false;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (Character.isDigit(numbers.charAt(i))) {
				sum += numbers.charAt(i) * (10 - i);
			} else {
				sum += 3;
			}

		}

		if (sum % 11 == 0) {
			result = true;
		}

		return result;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Map<String, Integer> map = new HashMap<>();
		String[] words = string.replaceAll(" ", "").split("");
		for (String i : words) {
			map.merge(i, 1, (a, b) -> a + b);
		}
		if (map.size() == 26) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if ((given instanceof LocalDate)) {
			return ((LocalDate) given).atStartOfDay().plusSeconds(1000000000);
		} else {
			return ((LocalDateTime) given).plusSeconds(1000000000);
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int result = 0;
		ArrayList<Integer> multiples = new ArrayList<Integer>();

		int current = 1;

		if (i > 0) {
			for (int j = 0; j < set.length; j++) {
				current = 1;
				while ((set[j] * current) < i) {
					if (!multiples.contains(set[j] * current)) {
						multiples.add(set[j] * current);
					}
					current++;
				}
			}

			for (int k = 0; k < multiples.size(); k++) {
				current = multiples.get(k);
				result += current;
			}
		}
		return result;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replaceAll(" ", "");
		int temp;
		int sum = 0;
		int[] digits = new int[string.length()];
		if (string.length() <= 1) {
			return false;
		} else if (string.contains("-")) {
			return false;
		} else {
			for (int i = string.length() - 1; i >= 0; i--) {
				if (!Character.isDigit(string.charAt(i)) && (string.charAt(i) != '-')) {
					return false;
				}
				if (i % 2 == 0) {
					temp = Integer.parseInt(string.substring(i, i + 1)) * 2;
					if (temp > 9) {
						temp -= 9;
					}
					digits[i] = temp;
				} else {
					digits[i] = Integer.parseInt(string.substring(i, i + 1));
				}
				for (int j = 0; j < digits.length; j++) {
					sum += digits[j];
				}
				if (sum % 10 == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		int first = 0;
		int second = 0;
		int count = 0;
		String temp;
		int other;
		boolean negative = false;

		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				other = i + 1;
				while (Character.isDigit(string.charAt(other))) {
					other++;
				}
				temp = string.substring(i, other);
				if (string.charAt(i - 1) == '-') {
					negative = true;
				}
				if (count == 0) {
					first = Integer.parseInt(temp);
					if (negative == true) {
						first *= -1;
					}
				} else if (count == 1) {
					second = Integer.parseInt(temp);
					if (negative == true) {
						second *= -1;
					}
				}
				count++;
				i = other;
				negative = false;
			}
		}

		if (string.contains("plus")) {
			return (first + second);
		} else if (string.contains("minus")) {
			return first - second;
		} else if (string.contains("multiplied")) {
			return first * second;
		} else if (string.contains("divided")) {
			return first / second;
		} else {
			System.out.println("Not a valid question.");
		}
		return 0;
	}

}
