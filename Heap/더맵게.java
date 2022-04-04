import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		int prev = 0;
		int next = 0;
		int result = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int item : scoville){
			heap.offer(item);
		}

		while (heap.peek() <= K){
			if (heap.size() == 1){
				return -1;
			}

			prev = heap.poll();
			next = heap.poll();

			result = prev + (next * 2);
			heap.add(result);
			answer++;

		}
		return answer;
	}
}