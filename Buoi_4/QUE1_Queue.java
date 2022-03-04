package STP_2022.Buoi_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class Struct {
    Integer height, position;

    Struct (Integer height, Integer position){
        this.height = height;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "height=" + height +
                ", position=" + position +
                '}';
    }
}

public class QUE1_Queue {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i=0; i<t; i++){
            int n = scanner.nextInt();
            List<Struct> structs = new ArrayList<>();
            List<Integer> results = new ArrayList<>();

            for (int j=0; j<n; j++){
                structs.add(new Struct(scanner.nextInt(), null));
                results.add(null);
            }
            for (Struct struct : structs)
                struct.position = scanner.nextInt();

            structs.sort(new Comparator<Struct>() {
                @Override
                public int compare(Struct o1, Struct o2) {
                    return o1.height - o2.height;
                }
            });

            int count, temp, j;
            for (int k=0; k<structs.size(); k++){
                temp = structs.get(k).position;
                count = 0;
                if (temp == 0){
                    for (j=0; j<structs.size(); j++)
                        if (Objects.isNull(results.get(j)))
                            break;
                    results.set(j, structs.get(k).height);
                }
                else {
                    for (j=0; j<structs.size(); j++){
//                        dem xem con bao nhieu vi tri trong
                        if (Objects.isNull(results.get(j)))
                            count++;
                        if (count == temp && Objects.isNull(results.get(j+1)))
                            break;
                    }
                    results.set(j+1, structs.get(k).height);
                }
            }
            for (Integer integer : results)
                System.out.print(integer + " ");
            System.out.println();
        }
    }
}
