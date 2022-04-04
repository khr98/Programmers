import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		int current = 0;
		int i = 0;
		// 작업시점이 순차적으로 들어오는것이 아니기 때문에 정렬해주기
		Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
		// 작업시간이 적게 소요되는 것부터 정렬해주기
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

		// 큐가 빌때까지 실행
		while (i < jobs.length || !q.isEmpty()){
			// 현재시점까지 들어온 작업만 큐에 넣기
			while (i < jobs.length && jobs[i][0] <= current){
				q.add(new int[] {jobs[i][0], jobs[i][1]});
				i++;
			}
			// 큐가 비었다면 현재시점이 다음 작업의 시점으로 변경됨
			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			if (q.isEmpty()){
				current = jobs[i][0];
			}
			// 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행 (PriorityQueue)
			else {
				int[] temp = q.poll();
				// current + temp[1] - temp[0] = 요청에서 종료까지 걸리는 시간
				answer += current + temp[1] - temp[0];
				current += temp[1];
			}
		}



		return answer / jobs.length;
	}
}