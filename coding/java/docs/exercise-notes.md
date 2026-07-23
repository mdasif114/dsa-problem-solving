# Exercise Notes

The code in this module is intentionally small, but each exercise has an
explicit contract so that correctness and operational trade-offs can be
discussed separately from syntax.

## Human-readable file size

**Problem.** Convert a non-negative decimal value followed by a binary unit
(B, KB, MB, GB, or TB) into an exact number of bytes.

**Approach.** Parse the numeric value with BigDecimal, multiply by the selected
power-of-1024 multiplier, and require the final result to be an exact long.

**Edge cases.** Blank input, unknown units, negative values, fractional bytes,
overflow, and malformed numbers are rejected.

**Follow-up.** A file-upload service would also enforce a configured maximum and
return a stable validation error rather than exposing an implementation
exception.

## Duplicate event detector

**Problem.** Determine whether a collection contains the same non-null event ID
more than once.

**Approach.** Insert each ID into a HashSet; add returning false identifies the
first repeated ID.

**Edge cases.** Empty input returns false. Null IDs are rejected because an event
without an identity cannot be safely deduplicated.

**Follow-up.** A bounded or distributed deduplication service needs an expiry
policy, persistence, idempotency semantics, and metrics for replayed events.

## Log frequency analyzer

**Problem.** Count log levels from records whose first token is the level and
whose remaining text is the message.

**Approach.** Parse only the first separator, aggregate in a sorted map, and
return deterministic output.

**Edge cases.** Blank records and records without a message separator are
rejected instead of being counted under an accidental key.

**Follow-up.** A streaming processor would bound memory, define malformed-record
handling, and expose input, parse-error, and per-level counters.

## IP request counter

**Problem.** Count requests when each record begins with an opaque client/IP token
followed by a path.

**Approach.** Extract only the first token and aggregate in a sorted map.

**Edge cases.** The implementation does not attempt to validate IPv4/IPv6 syntax;
that policy belongs at the boundary. It does reject missing client or path
tokens.

**Follow-up.** High-volume traffic may require partitioned aggregation, time
buckets, cardinality controls, and privacy-aware retention.

## Top-K failing services

**Problem.** Return up to k service names with the highest failure counts.

**Approach.** Count with a hash map, then sort by count descending and service name
ascending to make ties deterministic.

**Edge cases.** Non-positive k returns an empty list. Null service names are
rejected. k larger than the number of services returns all services.

**Follow-up.** For a continuously updated system, a bounded heap or streaming
aggregation would avoid sorting every key on every query.

## Parent-child analyzer

**Problem.** Return all descendants of a process in depth-first order.

**Approach.** Follow adjacency lists recursively and use a visited set so a
malformed cycle cannot recurse indefinitely.

**Edge cases.** A leaf returns an empty list. Missing parents are treated as
leaves. A repeated relationship is emitted once.

**Follow-up.** A production dependency graph would validate cycles explicitly and
could calculate blast radius, unavailable dependants, and deployment order.

## Sliding-window rate limiter

**Problem.** Allow at most maxRequests per client in the half-open interval
(now - windowSeconds, now].

**Approach.** Keep one deque of accepted timestamps per client. Expire timestamps
from the front before checking the current count.

**Edge cases.** Boundary timestamps exactly windowSeconds old expire. Client
timestamps must be non-decreasing because the deque is ordered.

**Follow-up.** A distributed limiter needs a shared time source, atomic updates,
partition/failure behavior, and a clear fail-open versus fail-closed policy.
