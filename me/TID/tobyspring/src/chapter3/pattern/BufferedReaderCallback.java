package chapter3.pattern;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback
{
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
