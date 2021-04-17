package study.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/*
* 매출액의 종류
*
* 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고
* 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
* 20 12 20 10 23 17 10
* 각 연속 4일간의 구간의 매출종류는
* 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
* 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
* 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
* 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
* N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종 류를 출력하는 프로그램을 작성하세요.
* ▣ 입력설명
* 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
* 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
* ▣ 출력설명
* 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
* ▣ 입력예제 1
* 7 4
* 20 12 20 10 23 17 10
* ▣ 출력예제 1
* 3 4 4 3
* */

public class Problem3 {

    public ArrayList<Integer> solution(int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < arr.length; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            // lt를 옮기기 전 이전에 lt가 가리키는 값은 다음 윈도우에서 빠지므로 크기를 1 줄이고 크기가 0 이라면 삭제
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();

        int k = 4;
        int[] arr = {20, 12, 20, 10, 23, 17, 10};
        System.out.println(p.solution(k, arr));
    }

}
