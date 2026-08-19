# Java IntelliJ debugging

## Core debugging
- Breakpoints
- Resume Program (F9)
- Step Over (F8)
- Step Into (F7)
- Smart Step Into (Shift+F7)
- Step Out (Shift+F8)
- Run to Cursor
- Call Stack
- Stack Frames
- Variables window
- Inspect objects / collections

## Investigating state
- Evaluate Expression ⭐
- Watches
- Conditional breakpoints
- Hit-count breakpoints
- Log/message breakpoints
- Modify variable values
- Inspect static fields
- Inspect nested objects
- Evaluate Java/Stream expressions

## Finding why something happened
- Exception breakpoints ⭐
- Field watchpoints — "break when this field changes"
- Method breakpoints
- Breakpoint conditions
- Breakpoint enable/disabßßßßßle/grouping
- Drop Frame
- Navigate caller → callee using Call Stack

## Threads
- Threads window
- Switch between threads
- Thread Call Stack
- Thread states: RUNNABLE / WAITING / BLOCKED
- Inspect synchronized locks
- Debug ExecutorService
- Debug CompletableFuture
- Debug parallelStream
- Basic deadlock investigation

## Real-world Java/Spring debugging
- Step into JDK/library source
- Attach/download source code
- Debug Spring Boot application
- DispatcherServlet
- Controller - Service - Repository flow
- @ControllerAdvice
- ResponseBodyAdvice
- Spring interceptors/filters
- Spring AOP/proxies
- Reflection / Method.invoke()
- Debug through proxy → actual implementation

## Advanced IntelliJ/JVM debugging
- HotSwap
- Remote JVM debugging
- JDWP
- Debug Docker/Kubernetes JVM
- Thread dumps
- JVM process inspection
- Heap/object inspection
- Java Flight Recorder basics