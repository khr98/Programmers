import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		int max = 0;
		int min = 0;
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minPq = new PriorityQueue<>();

		for(String item : operations){
			String[] value = item.split(" ");
			if (value[0].equals("I")){
				maxPq.add(Integer.parseInt(value[1]));
				minPq.add(Integer.parseInt(value[1]));
			}
			else if (value[0].equals("D")) {
				if (!maxPq.isEmpty()){
					if (value[1].equals("1")){
						max = maxPq.poll();
						minPq.remove(max);
					}
					else{
						min = minPq.poll();
						maxPq.remove(min);
					}
				}
			}
		}

		answer[0] = maxPq.isEmpty() ? 0 : maxPq.poll();
		answer[1] = minPq.isEmpty() ? 0 : minPq.poll();


		return answer;
	}
}