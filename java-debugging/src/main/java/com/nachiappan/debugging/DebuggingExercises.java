package com.nachiappan.debugging;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DebuggingExercises {
    public void stepThroughCalculation() {
        int first = 12;
        int second = 4;
        int result = calculateDifference(first, second);
        System.out.printf("%d - %d = %d%n", first, second, result);
    }

    private int calculateDifference(int first, int second) {
        int sum = first + second;
        int adjustment = 2;
        return sum - adjustment;
    }

    public void inspectObjectState() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Read stack frame", true));
        tasks.add(new Task("Inspect variables", false));
        tasks.add(new Task("Evaluate expression", false));
        Task selectedTask = tasks.get(1);
        selectedTask.markComplete();
        System.out.println("Tasks: " + tasks);
    }

    public void investigateException() {
        try {
            int[] scores = {10, 20, 30};
            int requestedIndex = 4;
            System.out.println("Score: " + scores[requestedIndex]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Caught " + exception.getClass().getSimpleName());
            System.out.println("Inspect the exception breakpoint and the call stack here.");
        }
    }

    public void followThreadExecution() {
        CountDownLatch finished = new CountDownLatch(1);
        Thread worker = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            for (int step = 1; step <= 3; step++) {
                System.out.printf("%s completed step %d%n", threadName, step);
            }
            finished.countDown();
        }, "debug-worker");
        worker.start();
        try {
            finished.await();
            worker.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }
    }

    public void followReflectionCall() {
        try {
            Method method = ReflectionTarget.class.getDeclaredMethod("describe", String.class);
            String description = (String) method.invoke(new ReflectionTarget(), "reflection");
            System.out.println(description);
        } catch (ReflectiveOperationException exception) {
            System.out.println("Reflection failed: " + exception.getMessage());
        }
    }

    private static final class Task {
        private final String name;
        private boolean complete;

        private Task(String name, boolean complete) {
            this.name = name;
            this.complete = complete;
        }

        private void markComplete() {
            complete = true;
        }

        @Override
        public String toString() {
            return name + "=" + (complete ? "done" : "open");
        }
    }

    private static final class ReflectionTarget {
        private String describe(String topic) {
            return "Reflection reached the target method for: " + topic;
        }
    }
}
