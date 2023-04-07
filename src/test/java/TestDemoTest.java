import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoTest {
	TestDemo testDemo;

	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if  (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(1, 2, 3, false),
				arguments(2, 3, 5, false),
				arguments(1,-2, 4, true),
				arguments(0, 1, 1, false)
		);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
