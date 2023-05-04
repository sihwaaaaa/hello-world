import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String[] strArr = {"aaa", "ddd", "bbb", "ccc"};
        List<String> list = Arrays.asList(strArr);
        list.forEach(System.out::println);

        //정렬된 형태의 출력
        System.out.println("=======================================");
        Arrays.sort(strArr);
        for (String s : strArr) {
            System.out.println(s);
        }
        
        //list
        System.out.println("=======================================");
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }

        //stream
        System.out.println("=======================================");
        Stream<String> strem1 = list.stream();
        //Stream<String> strem2 = Arrays.stream(strArr);
        strem1.sorted().forEach(System.out::println);
        
        
        // Iterator : next(), hashNext()
        System.out.println("=======================================");
        
        Iterator<String> iter = list.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        
        System.out.println("=======================================");
        strem1 = list.stream();
        strem1.sorted().forEach(s -> System.out.println(s));
        
        System.out.println("=======================================");
        //IntStream intStream = IntStream.rangeClosed(1, 5);
        IntStream intStream = new Random().ints(1,10).limit(20);
        intStream.forEach(i -> System.out.println(i));
        
        System.out.println("=======================================");
        Stream<String> stream3 = Stream.of("123", "가나다", "12");
        stream3.forEach(i -> System.out.println(i));
        
        List<String> list2 = new ArrayList<>();
        list2.add("김길동");
        list2.add("박길동");
        list2.add("빅현빈");
        list2.add("홍길동");
        list2.add("김길동");
        list2.add("김삼순");
        list2.add("김유신");
        
        //1. 김씨 성을 가진 인물 출력
        
        System.out.println("=======================================");
       
       list2.stream().filter(str -> str.startsWith("김")).forEach(s -> System.out.println(s));
        
        //2. 이름이 길동인 인물 출력
        //람다 안쓰면 익명클래스
        list2.stream().filter(new Predicate<String>() {
            public boolean test(String s){
                return s.endsWith("길동");
            }
        }).forEach(new Consumer<String>() {
            public void accept(String s){
                System.out.println(s);
            }
        });

        //해당 바탕화면 폴더의 디렉토리가 아닌 파일만 골라서 파일이름(map) 출력 >> 해당 파일명의 길이를 출력하는 것으로 변경
        File file = new File("C:\\Users\\TJ\\Desktop");
        Arrays.stream(file.listFiles()).filter(f -> f.isFile())
        //.map(f -> f.getName()).map(f -> f.length())
        .map(f -> {
            Map<String, Object> map = new HashMap<>();
            map.put("size", f.length());
            map.put("name", f.getName());
            map.put("name.length", f.getName().length());
            return map;
        })
        .forEach(f -> System.out.println(f));
    }
}
