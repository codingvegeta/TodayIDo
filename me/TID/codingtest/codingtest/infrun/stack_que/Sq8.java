package infrun.stack_que;

import java.util.*;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Sq8 {
    static int solution(int n, int[] d) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i = 0; i<d.length; i++){
            q.offer(new Person(i, d[i]));
        }
        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for(Person x : q){
                if (x.priority>tmp.priority){
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == n) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(solution(m, d));
    }
}
