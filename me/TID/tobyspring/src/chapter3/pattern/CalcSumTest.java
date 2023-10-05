package chapter3.pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest
{
    Calculator calculator;
    String numFilePath;

    @Before
    public void setUp()
    {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException
    {
        assertThat(calculator.calcSum(this.numFilePath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException
    {
        assertThat(calculator.calMultiply(this.numFilePath), is(24));
    }

    @Test
    public void concatOfNumbers() throws IOException
    {
        assertThat(calculator.concatenate(this.numFilePath), is("1234"));
    }
}
