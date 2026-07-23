# Executable Java Coding Lab

This Maven module contains completed, executable exercises extracted from the
company-neutral software-systems practice curriculum. The scenarios use logs,
requests, events, process relationships, and bounded state because those
contexts make data-structure decisions easier to discuss.

These are engineering exercises, not claims about questions from a particular
employer.

## Run the tests

From the repository root:

~~~bash
mvn -B -f coding/java/pom.xml test
~~~

The module targets Java 17 and uses standard-library collections with JUnit 5
tests.

## Included patterns

| Exercise | Primary pattern | Complexity |
|---|---|---|
| Human-readable file size | Parsing and checked arithmetic | O(n) in input length, O(1) auxiliary space |
| Duplicate event detector | HashSet membership | O(n) average time, O(n) space |
| Log frequency analyzer | Parsing and ordered aggregation | O(n) in total input size, O(u) space |
| IP request counter | Parsing and deterministic aggregation | O(n log u) time, O(u) space |
| Top-K failing services | HashMap and deterministic sorting | O(n + u log u) time, O(u) space |
| Parent-child analyzer | DFS and cycle protection | O(V + E) time, O(V) space |
| Sliding-window rate limiter | Per-client deque and expiry | O(1) amortized per request, O(r) space |

Here n is the number or total size of input records, u is the number of unique
keys, V is the number of processes, E is the number of relationships, and r is
the number of retained requests.

## Design boundaries

Each implementation states its input contract and rejects malformed data where
silently accepting it would hide an operational problem. Returned collections
are read-only where practical. The rate limiter requires timestamps for each
client to be non-decreasing; a production distributed implementation would need
a shared clock policy and external state such as Redis.

Detailed requirements, edge cases, and production follow-ups are recorded in
[exercise-notes.md](docs/exercise-notes.md).
