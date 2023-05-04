import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Subway {
  public static void main(String[] args) throws IOException {

    //csv => List<Map<String, Object>>

    List<String> inputListString = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\TJ\\Desktop\\hello world\\Stream\\src\\CARD_SUBWAY_MONTH_202303 copy.csv"), "utf-8"));
    String str = null;
    while ((str = br.readLine()) != null) {
      inputListString.add(str);
        }
    br.close();
    List<Map<String, Object>> resultList = new ArrayList<>();
    System.out.println(inputListString);
    inputListString.stream().map(l -> l.length());
    System.out.println(inputListString.stream().map(l -> l.length()));


        //데이터 가공 먼저 필요

    //inputListString.stream().map(String >> Map) : List<Map<String, Object>>
    //
    // 집계 계열 (통계,그룹 관련 함수)
    // max, min, sum, avg, count
    //inputListString.stream().map(r -> r.)
    //날짜별(10일 단위)
    //inputListString.stream().collect(Collectors.groupingBy()) ;
   }
}
