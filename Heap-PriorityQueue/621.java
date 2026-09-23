/*
    621. Task Scheduler
    Medium
    Topics
    Companies - Meta
    You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
    Return the minimum number of CPU intervals required to complete all tasks.
    Example 1:
    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
*/

// Using MaxHeap & Queue : O(m)tc where m is no. of tasks
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}

// Using Greedy Approach : think of its as feeling idle spot , since we will need to start by executing the task with most frequency so that in the end we dont sit idle by the cooldwon period, the so max idle time id (maxF-1) * n, since all the remaining or the tasks with less fequency can be executed in between execution of max freqeuncy task : so for evry cylce of n : we keep reducing the idle task, in the end if the idle time is 0; that mean all the task executed by the lenfth of 'tasks', or if the idle task is positive that means we need to add that idle time into the lenght of tasks
// O(m)tc where m is no. of tasks

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int maxf = count[25];
        int idle = (maxf - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxf - 1, count[i]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}