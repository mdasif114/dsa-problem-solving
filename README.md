# Software Systems Coding Lab

A company-neutral Java practice repository for practical data structures, algorithms, parsing, time windows, graphs, queues, scheduling, and reliability-oriented problem solving.

The problems use operationally familiar scenarios such as logs, metrics, requests, dependencies, incidents, and event streams. They are practice exercises, not claims about questions from any particular employer.

## What this repository demonstrates

- Clear problem contracts and input assumptions
- Java 17 implementations using standard collections
- Deterministic handling of malformed input and tie-breaking
- Complexity analysis and boundary-case reasoning
- SRE-oriented follow-up discussions
- A repeatable workflow for attempting, testing, reviewing, and revisiting problems

## Current status

The repository currently contains starter files. A starter is intentionally incomplete and throws UnsupportedOperationException until the implementation is added. This makes progress visible and prevents an unfinished exercise from being presented as complete.

Completed implementations should be added only when they include:

- a documented approach;
- executable Java code;
- automated tests where the project structure supports them;
- edge-case coverage;
- time and space complexity;
- a short production or reliability follow-up when relevant.

## Repository structure

~~~text
dsa-problem-solving/
├── README.md
├── research.md
├── question-bank.md
├── schedule.md
├── checklist.md
├── progress.md
├── FIRST-PROBLEM.md
├── must-practise/
├── strongly-recommended/
└── additional-practice/
~~~

The current starter curriculum is organised by learning priority. The long-term portfolio structure will move completed work into topic-based packages such as hashing, sliding windows, stacks and queues, heaps, trees, graphs, concurrency, and systems.

## Problem themes

- Log parsing and aggregation
- Sliding windows and rate limits
- Interval merging
- Dependency graphs and blast radius
- Event deduplication and idempotency
- Scheduling and bounded buffers
- Metrics aggregation
- LRU caches
- Path processing
- Streaming and concurrency follow-ups

## How to practise

1. Read the contract and clarify assumptions.
2. Work through a normal case and a boundary case.
3. Implement the simplest correct approach.
4. State the invariant and complexity.
5. Test malformed, empty, duplicate, and extreme inputs.
6. Record mistakes and the next review date in progress.md.
7. Add the completed solution only after the attempt is documented.

Run an individual starter from its directory:

~~~bash
javac P01_TopErrorProducingServices_Starter.java
java P01_TopErrorProducingServices_Starter
~~~

## Engineering direction

This repository is being evolved into a broader software-systems engineering lab. Future completed areas may include:

- distributed idempotency;
- retry and dead-letter-queue design;
- backpressure;
- observability and failure-mode analysis;
- concurrency-safe data structures;
- networking and operating-system exercises;
- system-design case studies.

Planned work must remain clearly labelled as planned until implemented and tested.
