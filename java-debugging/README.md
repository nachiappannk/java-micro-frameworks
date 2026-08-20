# Java Debugging Lab

A small console application for practicing Java and IntelliJ/VS Code debugging techniques.

## Run normally

```bash
./mvnw compile exec:java
```

If the wrapper is not executable, run `chmod +x mvnw` once or use `mvn compile exec:java`.

## Run in debug mode

```bash
./mvnw compile exec:java -Dexec.args="1"
```

For an interactive session, omit `-Dexec.args`. In VS Code, place breakpoints in `DebuggingExercises.java`, then start the **Debug Java Debugging Lab** configuration.

## Exercises

1. **Calculation**: step over and step into a method; inspect locals and evaluate an expression.
2. **Object state**: inspect a collection, nested object state, and modify `complete` while paused.
3. **Exception**: enable an exception breakpoint for `ArrayIndexOutOfBoundsException`; inspect the stack and caught exception.
4. **Worker thread**: inspect the `debug-worker` thread, its call stack, and thread state.
5. **Reflection**: step through `Method.invoke()` into the target method.

The exercises are intentionally small and deterministic so you can repeat them while practicing breakpoints, watches, conditional breakpoints, call stacks, and expression evaluation.
