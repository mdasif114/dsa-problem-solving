# Prioritised Engineering Problem Bank

No row below is a prediction of a future interview question. `Recurring` describes
an underlying engineering pattern; `Representative` is a reasoned practice choice.
See [research.md](research.md) for source quality and dates.

## 15 Must Practise

| Rank | Problem and short scenario | Primary pattern | Diff. | Priority | Rationale | Engineering relevance |
|---:|---|---|---|---|---|---|
| 01 | Rank services by ERROR log count, breaking ties deterministically | Parsing, HashMap, heap | Medium | High | Representative | Practical logs, grouping, Top-K |
| 02 | Find clients exceeding `k` requests in any rolling time window | Sliding window, deque | Medium | High | Recurring | Rate and abuse detection; timestamp boundaries |
| 03 | Merge overlapping or touching outage windows | Sort, intervals | Medium | High | Recurring | Incident/maintenance timelines |
| 04 | Assign jobs to limited workers and minimise completion time | Min-heap | Medium | High | Representative | Scheduling and resource allocation |
| 05 | Detect a cycle in service dependencies | DFS colours / Kahn | Medium | High | Recurring | Prevent unsafe deployment/dependency loops |
| 06 | From failed services, find all transitively unavailable dependants | Reverse graph, BFS/DFS | Medium | High | Recurring | Blast-radius calculation |
| 07 | Deduplicate retried events using ID and retention window | HashMap, queue | Medium | High | Recurring | Idempotency and replay handling |
| 08 | Maintain recent health results and availability over the last `n` checks | Queue/deque, stream | Medium | High | Recurring | Adapted from common stream-processing pattern |
| 09 | Aggregate metric values by service and fixed time bucket | Parsing, nested maps | Medium | High | Representative | Metrics pipelines and time bucketing |
| 10 | Return the first timestamp where cumulative errors breach a limit | Prefix sum / binary search | Medium | High | Representative | Threshold detection with ordered data |
| 11 | Canonicalise Unix-style paths with `.`, `..`, and repeated separators | Stack/deque, strings | Medium | High | Recurring | Practical path and file manipulation |
| 12 | Implement fixed-capacity LRU cache operations | HashMap + doubly linked list | Medium | High | Recurring | Core DS implementation and state correctness |
| 13 | Return Top-K frequent event types with deterministic ties | HashMap, heap | Medium | High | Recurring | Alert/log aggregation |
| 14 | Traverse dependency graph to find services impacted by one change | BFS/DFS | Medium | High | Recurring | Graph input and operational impact |
| 15 | Implement deterministic token-bucket allow/deny decisions | State simulation | Medium | High | Representative | Rate limiting, time, invalid input |

## 15 Strongly Recommended

| Rank | Problem and short scenario | Primary pattern | Diff. | Priority | Rationale | Engineering relevance |
|---:|---|---|---|---|---|---|
| 16 | Merge several timestamp-sorted log streams | Heap, multiway merge | Medium | High | Representative | Distributed log collection |
| 17 | Compute peak concurrent incidents | Sweep line / heap | Medium | High | Recurring | Interval boundaries and capacity |
| 18 | Find longest metric window within an allowed min/max range | Monotonic deques | Medium | High | Recurring | Anomaly/stability windows |
| 19 | Group logs after replacing numeric/request-ID tokens | Parsing, hashing | Medium | Medium | Representative | Reduce high-cardinality log noise |
| 20 | Emit an alert only when its key is outside a cooldown period | HashMap, ordered events | Medium | High | Representative | Alert deduplication/suppression |
| 21 | Find shortest dependency chain between two services | BFS | Medium | High | Recurring | Directly backed by recent SRE BFS report |
| 22 | Return a valid deployment order or detect impossibility | Topological sort | Medium | High | Recurring | Safe dependency-aware rollout |
| 23 | Group services connected by network links | Union-Find | Medium | Medium | Representative | Fast connectivity and cluster counting |
| 24 | Return the longest matching configuration prefix | Trie | Medium | Medium | Representative | Hierarchical configuration/routing |
| 25 | Find the largest connected failure region in a host grid | Grid BFS/DFS | Medium | Medium | Recurring | Region/blast-radius traversal |
| 26 | Locate a timestamp in a rotated sorted array | Binary search | Medium | Medium | Recurring | Boundary discipline and search |
| 27 | Select non-overlapping jobs with maximum operational value | DP + binary search | Hard | Medium | Representative | Light DP with scheduling relevance |
| 28 | Find minimum per-worker capacity to finish ordered jobs in `d` shifts | Binary search on answer | Medium | Medium | Recurring | Capacity planning and monotonic feasibility |
| 29 | Simulate bounded producer/consumer buffer operations | Queue simulation | Medium | Medium | Representative | Backpressure and bounded state |
| 30 | Parse quoted key-value log fields into a map | State-machine parsing | Medium | High | Recurring | Practical robust text processing |

## 10 Additional Practice

| Rank | Problem and short scenario | Primary pattern | Diff. | Priority | Rationale | Engineering relevance |
|---:|---|---|---|---|---|---|
| 31 | Return the first event type seen exactly once | HashMap, ordered scan | Easy | Medium | Recurring | Stream/frequency basics |
| 32 | Add two sparse metric matrices | HashMap, matrix | Medium | Lower | Representative | Sparse telemetry representation |
| 33 | Generate maintenance-window combinations reaching exact duration | Backtracking | Medium | Lower | Representative | Basic recursive search |
| 34 | Minimise restart cost where adjacent services cannot restart together | 1-D DP | Medium | Lower | Representative | Light optimisation DP |
| 35 | Return process IDs in preorder from a process tree | Tree DFS | Easy | Medium | Recurring | Recent report mentions basic tree traversal |
| 36 | Serialise and deserialise a process tree | Tree BFS/DFS, parsing | Medium | Lower | Representative | Data representation and robustness |
| 37 | Relabel one connected network zone | Flood fill | Medium | Medium | Recurring | Grid traversal fundamentals |
| 38 | Return K datacentres closest to a coordinate | Heap / quick select | Medium | Medium | Recurring | Top-K and distance calculation |
| 39 | Track median latency from a stream | Two heaps | Hard | Lower | Recurring | Stateful online aggregation |
| 40 | Find minimum-cost route through weighted service dependencies | Dijkstra | Medium | Medium | Recurring | Weighted graph reasoning |

## Selection principles

- One variation is used when it adds a distinct operational constraint, such as
  deterministic ties, timestamp expiry, or a changed follow-up.
- P01–P30 receive most preparation time.
- P31–P40 provide breadth after high-priority patterns are stable.
- The full solution document for a problem is created only after an attempt. It
  will contain the straightforward approach, optimal reasoning, complexity,
  dry run, follow-ups, extensions, common mistakes, and a speakable explanation.

