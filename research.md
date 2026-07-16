# Research Methodology and Coding-Round Analysis

Research checked on **16 July 2026**. This document covers only programming and
coding. It does not prepare system-internals, troubleshooting, networking,
system-design, or behavioural rounds.

## Source-quality rules

1. The recruiter instructions for this specific interview control the format:
   45 minutes, Java, simple algorithm/data-structure implementation, clean and
   efficient working code. This is private candidate-specific evidence.
2. Official Google Careers guidance is authoritative for general interview
   process but does not publish an SRE-SE question bank.
3. First-person, dated candidate reports are useful but anecdotal. Track, level,
   location, and interviewer can materially change the round.
4. Aggregator pages are supporting evidence only. They are not used to label an
   exact problem as reported unless they preserve a clear dated candidate account.
5. Anonymous posts do not establish that a question will repeat.
6. No confidential, leaked, or proprietary question set is used.
7. An adapted SRE scenario is classified `Recurring` or `Representative`, not
   `Reported`, even when its underlying algorithm appears in a report.

## What recent public evidence supports

| Source | Date | Evidence | Confidence |
|---|---|---|---|
| [Google Careers interview guidance](https://www.google.com/about/careers/applications/interview-tips/) | Current when checked 16 Jul 2026 | Official general preparation source; does not disclose questions | High for general process |
| [Google SRE-SE Bangalore candidate report](https://leetcode.com/discuss/post/6006265/Google-SRE-SE-or-Bangalore-or-L3-or-Rejected/) | 2024 | 45-minute scripting round, free language choice, practical file manipulation and duplicate detection; clarity encouraged | Medium; one anonymous report |
| [Google SRE L4 London candidate report](https://leetcode.com/discuss/post/5979952/Google-London-or-L4-or-Aug-Oct-24-Offer-accepted/) | Aug–Oct 2024 | Moving average over the last `n` stream elements and a BFS shortest-path task with input processing | Medium; track labelled SRE but SE/SWE flavour is not explicit |
| [SRE-SE discussion with recent interview replies](https://www.reddit.com/r/sre/comments/1atrq1z/se_sre_interview_at_google/) | Feb 2024 thread | Basic recursion, plain-editor coding, and variability by experience level | Low–medium; discussion replies |
| [Google SRE Dublin candidate reports](https://www.glassdoor.com/Interview/Google-Site-Reliability-Engineer-Dublin-Interview-Questions-EI_IE9079.0%2C6_KO7%2C32_IL.33%2C39_IM1052.htm) | Jun and Dec 2025 entries | 45-minute 1:1, explain before coding, optimisation/time complexity, string questions, and non-standard LeetCode-like tasks | Low–medium; anonymous and mixed SRE flavours |
| [Recent SRE-SE DSA discussion](https://www.reddit.com/r/csMajors/comments/1ovp1o3/need_help_google_coding_interview_for_sresystem/) | 2025 | Recruiter described a straight DSA round; replies prioritised maps, heaps, graphs, binary search, practical parsing, and 45-minute mocks | Low; advice mixed with candidate statement |
| [Recent SWE-SRE discussion](https://www.reddit.com/r/sre/comments/1etg638/google_swesre_interview_prep/) | 2024–2026 updates | Medium-complexity programming, follow-up changes, plain-text coding; reports include tree traversal and interval-style problems | Low–medium and not the SE track |
| [Exponent SRE interview account](https://www.tryexponent.com/experiences/google-site-reliability-engineer-interview-3f10d4) | 2025 | Practical coding, invalid inputs, communication, changing constraints, and fundamentals-first preparation | Low–medium; third-party platform |

## Evidence limitation

There is no reliable, comprehensive public list of exact Google SRE-SE coding
questions from the last two to three years. Recent accounts disagree because
some describe SRE-SE, some SWE-SRE, different levels, and different locations.
The bank therefore uses a small number of reported patterns and a larger set of
transparent, role-relevant representative exercises. It must not be marketed as
a list of questions that Google will ask.

## Expected 45-minute format

The following combines the candidate-specific recruiter email with recurring
public evidence:

| Time | Expected activity |
|---:|---|
| 0–5 min | Restate the problem; clarify input, output, limits, ordering, duplicates, and invalid input |
| 5–10 min | Work an example; describe a straightforward solution and complexity |
| 10–15 min | Derive the improved approach and state the invariant |
| 15–32 min | Implement clean Java while communicating |
| 32–39 min | Manually test normal, boundary, empty, duplicate, and invalid cases |
| 39–44 min | Complexity and one follow-up modification |
| 44–45 min | Concise recap |

The exact minute split is a preparation model, not a verified scoring rubric.

## SRE-SE versus SRE-SWE coding

### Verified

- The candidate-specific preliminary round is a 45-minute Java programming and
  code-evaluation interview.
- Recent SRE-SE accounts include practical file manipulation, duplicate
  detection, recursion, and scripting-like tasks.
- Recent broader SRE reports also include ordinary DSA such as strings, streams,
  trees, intervals, and BFS.

### Reasoned inference

- SRE-SE is more likely than pure SWE to wrap common algorithms in logs, files,
  process, metric, dependency, scheduling, or reliability scenarios.
- Implementation detail, input validation, clarity, and operational edge cases
  may matter more than memorising a specialised trick.
- Core DSA still matters. Practical framing is not permission to ignore graphs,
  heaps, sliding windows, intervals, or complexity.
- Advanced dynamic programming, specialised geometry, and contest techniques
  deserve less time unless weakness data or new evidence changes the plan.

## Most likely pattern families

| Priority | Pattern family | Why it is prioritised |
|---:|---|---|
| 1 | String/file/log parsing + hash maps | Directly aligned with practical scripting reports and SE work |
| 2 | Sliding time windows + deques | Rate, health, and metric streams; tests timestamp boundaries |
| 3 | Graph BFS/DFS/topological sorting | Dependencies, reachability, cycles, and reported BFS evidence |
| 4 | Sorting + intervals | Maintenance/outage merging and concurrency |
| 5 | Heaps/priority queues | Top-K, worker scheduling, and sorted-stream merge |
| 6 | Sets/idempotency/deduplication | Replayed events and direct duplicate-detection evidence |
| 7 | Cache/rate-limiter implementation | Practical data-structure ownership and edge cases |
| 8 | Binary search | Thresholds and monotonic capacity decisions |
| 9 | Trees/grids/Union-Find/tries | Useful breadth after the highest-probability set |
| 10 | Light recursion/backtracking/DP | Coverage without overinvesting in low-evidence advanced DSA |

## What is evaluated beyond correctness

- Contract clarification and explicit assumptions
- Ability to start with a simple correct approach
- Data-structure choice and invariant
- Readable Java 17 without IDE dependence
- Correct time and space analysis
- Manual testing and failure awareness
- Response to hints and changed requirements
- Calm, continuous communication
- Maintainability: naming, decomposition, and avoiding unnecessary cleverness

## Expected DSA depth

Target strong working command of arrays, strings, maps, sets, queues, stacks,
heaps, intervals, trees, graphs, BFS, DFS, topological sorting, sliding windows,
two pointers, and binary search. Know Union-Find and tries well enough for a
medium problem. Practise only a small amount of backtracking and dynamic
programming. The goal is to solve medium practical problems reliably within 45
minutes, not to maximise hard-problem count.

