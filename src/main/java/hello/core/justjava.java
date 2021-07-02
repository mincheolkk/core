package hello.core;

import java.util.Arrays;
import java.util.Collections;

class People implements Comparable<People> {

    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age= age;
    }

    public String print(){
        return name+"("+age+")";
    }

    @Override
    public int compareTo(People people) {
        // TODO Auto-generated method stub
        if (this.age < people.age) {
            return -1;
        } else if (this.age == people.age) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class justjava {
    public static void main(String[] args)  {
        People[] arr = { new People("상현", 20)
                , new People("철수", 14)
                , new People("경완", 31)
                , new People("대호", 40)
                , new People("지운", 24)
        };

        Arrays.sort(arr); //오름차순 정렬

        for (People i : arr) { //오름차순 출력
            System.out.print("["+i.print()+"]");
        }

        Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
        System.out.println();

        for (People i : arr) { //내림차순 출력
            System.out.print("["+i.print()+"]");
        }
    }

}
