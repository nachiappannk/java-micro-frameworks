package com.nachiappan.debugging;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class DebuggingExercisesTest {
    private final DebuggingExercises exercises = new DebuggingExercises();

    @Test
    void exercisesCanRunToCompletion() {
        assertDoesNotThrow(() -> {
            exercises.stepThroughCalculation();
            exercises.inspectObjectState();
            exercises.investigateException();
            exercises.followThreadExecution();
            exercises.followReflectionCall();
        });
    }
}
