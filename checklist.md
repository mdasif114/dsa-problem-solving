# Coding-Interview Checklist

## Before coding

- Restate the problem and confirm the expected result.
- Ask about input size, ordering, duplicates, mutability, and invalid input.
- For timestamps, confirm units, ordering, inclusivity, and whether equal
  boundary times belong to the same window.
- For intervals, confirm whether `[start, end]` or `[start, end)` is used and
  whether touching intervals merge.
- For logs, confirm grammar, malformed-line behaviour, case sensitivity, and
  deterministic tie-breaking.
- Work through one normal and one boundary example.

## Approach

- Give a straightforward correct solution first.
- State its time and space cost.
- Identify repeated work or the bottleneck.
- Derive the improved approach and name its invariant.
- Explain why the chosen map, set, deque, heap, tree, or graph is appropriate.

## Java implementation

- Use Java 17 and standard-library collections only.
- Prefer interfaces in declarations: `Map`, `Set`, `List`, `Deque`, `Queue`.
- Prefer `ArrayDeque` over legacy `Stack`.
- Use `long` for timestamps, counts, sums, products, and risky arithmetic.
- Avoid subtraction comparators; use `Integer.compare`, `Long.compare`, or
  comparator helpers.
- Keep parsing, algorithm, and formatting responsibilities separate.
- Use clear names and small helpers without overengineering.
- Do not silently mutate input unless agreed.

## Manual testing without execution

- Empty input
- Single item
- All items equal
- Duplicates or replay
- Already sorted and reverse sorted
- Window/interval boundary equality
- Very large values and overflow
- Disconnected graph and self-cycle
- Invalid/malformed input
- `k = 0`, `k = 1`, and `k` larger than available items

Trace the variables that define the invariant: window ends, queue contents,
visited set, indegree, heap top, cache order, or token count.

## Finish

- State final time and space complexity, including auxiliary structures and
  recursion depth.
- Explain the most important edge case.
- Respond to hints by acknowledging them, restating the new insight, and
  adjusting the approach visibly.
- For a follow-up, restate what changed before editing code.
- Keep communicating; do not go silent while implementing.
- End with a concise summary of correctness and trade-offs.

