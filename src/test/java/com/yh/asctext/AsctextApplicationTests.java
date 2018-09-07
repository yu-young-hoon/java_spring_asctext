package com.yh.asctext;

import com.yh.asctext.logic.Logic;
import com.yh.asctext.logic.SortStrategy;
import com.yh.asctext.service.SolutionService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsctextApplicationTests {
	private static String testText;
	private static List<Character>[] divideText;
	private static String mergedText;

	@Autowired
	private Logic logic;

	@BeforeClass
	public static void setup() {
		testText = "!#ㄹㅎㅈaB09Az7?";
	}

	@Test
	public void test1() {
		testText = logic.XSS(testText);
		assertThat(testText, is("aB09Az7"));
	}

	@Test
	public void test2() {
		divideText = logic.Divide(testText);
		assertThat(divideText[0], is(Arrays.asList('a','B','A','z')));
		assertThat(divideText[1], is(Arrays.asList('0','9','7')));
	}

	@Test
	public void test3() {
		Collections.sort(divideText[0], new SortStrategy());
		Collections.sort(divideText[1]);
		assertThat(divideText[0], is(Arrays.asList('A','a','B','z')));
		assertThat(divideText[1], is(Arrays.asList('0','7','9')));
	}

	@Test
	public void test4() {
		mergedText = logic.Merge(divideText[0], divideText[1]);
		assertThat(mergedText, is("A0a7B9z"));
	}

	@Test
	public void test5() {
		int outUnit = 4;
		String result = mergedText.substring(0, mergedText.length() - mergedText.length() % outUnit);
		String tailText = mergedText.substring(mergedText.length() - mergedText.length() % outUnit);
		assertThat(result, is("A0a7"));
		assertThat(tailText, is("B9z"));
	}
}
