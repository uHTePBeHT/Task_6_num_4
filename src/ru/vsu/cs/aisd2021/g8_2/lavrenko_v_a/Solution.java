package ru.vsu.cs.aisd2021.g8_2.lavrenko_v_a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  4. Найти все позиции в массиве/списке целых чисел наибольшего из наиболее часто встречающихся значений.
    Алгоритм должен работать за время O(n*log(n)).
    Использовать структуру данных Map<Integer, List<Integer>> (ключ – число из массива, значение – позиции этого числа).
    Далее пройти по данному словарю для поиска нужного числа и его позиций.*/

public class Solution {
    public static List<Integer> maxFrequency(int[] arr){ //O(n)
        if(arr.length == 0){
            return null;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int key = arr[i];
            List<Integer> indexes;

            if(!map.containsKey(key)){
                indexes = new ArrayList<>();
            }
            else {
                indexes = map.get(key);
            }
            indexes.add(i);
            map.put(key, indexes);
        }
        System.out.println("\n" + "Map: " + map + "\n");

        int maxSize = -1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() > maxSize){
                maxSize = entry.getValue().size();
            }
        }
        System.out.println("Max size = " + maxSize);

        Map.Entry<Integer, List<Integer>> maxKeyEntry = null;

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){ //O(n)
            if(maxKeyEntry == null || (entry.getValue().size() == maxSize &&
                    entry.getKey() > maxKeyEntry.getKey())){
                maxKeyEntry = entry;
            }
        }
        System.out.println("Max key = " + "'" + maxKeyEntry.getKey() + "'");

        return maxKeyEntry.getValue();
    }
}
