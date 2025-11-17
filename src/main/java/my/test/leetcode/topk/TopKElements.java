package my.test.leetcode.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int number : nums){
            Integer frequency = frequencyMap.get(number);
            if(frequency == null){
                frequencyMap.put(number, Integer.valueOf(1));
            }else{
                int frequencyPlusOne = frequency + 1;
                frequencyMap.put(number, frequencyPlusOne);
            }
        }

        System.out.println(frequencyMap);

        PriorityQueue<Frequency> frequencyPriorityQueue = new PriorityQueue<>((Frequency f1, Frequency f2) -> Integer.compare(f2.frequency, f1.frequency));
        for(Map.Entry<Integer, Integer> frequencyEntry: frequencyMap.entrySet()){
            Frequency frequency = new Frequency(frequencyEntry.getKey(), frequencyEntry.getValue());
            frequencyPriorityQueue.offer(frequency);
        }

        System.out.println("Priority Queue Size: " + frequencyPriorityQueue.size());
        System.out.println("Priority Queue: " + frequencyPriorityQueue);
        int queueSize = frequencyPriorityQueue.size();
        for(int i  = 0; i < queueSize; i++){
            System.out.print(i + " : ");
            System.out.println(frequencyPriorityQueue.poll());
        }


    }

}

class Frequency{
    Integer number;
    Integer frequency;

    Frequency(Integer number, Integer frequency){
        this.number = number;
        this.frequency = frequency;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "number=" + number +
                ", frequency=" + frequency +
                '}';
    }
}
