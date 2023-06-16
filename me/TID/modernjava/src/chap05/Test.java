package chap05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        IntStream.rangeClosed(1, 100).boxed()
//                .flatMap(a -> IntStream.rangeClosed(a, 100)
//
//                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
//                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
        
    }
}
