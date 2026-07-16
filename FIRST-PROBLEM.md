# Interactive Problem 01 — Top Error-Producing Services

Do not open or request a solution file yet. Begin with the starter:
[P01_TopErrorProducingServices_Starter.java](must-practise/P01_TopErrorProducingServices_Starter.java).

## Problem

Each valid log line has this form:

```text
timestamp service severity message
```

The timestamp has no spaces. `service` and `severity` are case-sensitive tokens.
The message may contain spaces. Given log lines and integer `k`, return up to `k`
service names with the largest number of `ERROR` entries. Sort by descending
error count; break equal counts by ascending service name. Ignore malformed
lines.

Example:

```text
2026-07-16T10:00:00Z payments ERROR timeout
2026-07-16T10:00:01Z search INFO healthy
2026-07-16T10:00:02Z payments ERROR retry failed
2026-07-16T10:00:03Z orders ERROR database unavailable
```

For `k = 2`, the result is `[payments, orders]`.

## Your first response

Before coding, answer:

1. What clarifying questions would you ask?
2. What is the straightforward approach and its complexity?
3. What data structures would you use for the improved approach?
4. Which malformed inputs and tie cases must be tested?

Then implement the starter and share your attempted file or commit. Review will
score understanding, approach, correctness, Java quality, testing, complexity,
and communication from 1–4. Hints will be incremental; the completed solution
is revealed only after `show solution`.

