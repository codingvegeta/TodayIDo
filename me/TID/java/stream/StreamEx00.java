import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx00 {
    public static void main(String[] args) {
        String[] lineArr = {"Believe or not It is true", "Do or do not there is no try"};
        Stream<String> lineStream = Arrays.stream(lineArr);
        // map인 경우
//        Stream<Stream<String>> strArrStream = lineStream.map(line -> Stream.of(line.split(" +")));
//        strArrStream.forEach(str -> str.forEach(System.out::println));

        //flatMap인 경우
        Stream<String> str2 = lineStream.flatMap(line -> Stream.of(line.split(" ")));
        str2.forEach(System.out::println);

    }
}
