# DSA Problem Solving — SRE Systems Coding Track

An IntelliJ-ready Java 17 practice repository focused on the programming round
for Site Reliability Engineering — Systems Engineer interviews. The repository
prioritises practical parsing, logs, metrics, time windows, scheduling,
dependencies, queues, graphs, and clean implementation over obscure competitive-
programming tricks.

Interview target: **11 August 2026**. Current repository phase: **starter files
only**. Completed solution files are intentionally added one at a time after an
attempt or an explicit `show solution` request.

## Important evidence boundary

Public, recent SRE-SE-specific question evidence is limited. The problem bank
therefore distinguishes:

- **Reported:** the exact or essentially equivalent question is described in a
  dated public candidate report.
- **Recurring:** the underlying pattern appears repeatedly in recent Google/SRE
  reports, but this repository's scenario is adapted.
- **Representative:** selected because it exercises role-relevant programming;
  it is not claimed to have been asked by Google.

See [research.md](research.md) for sources, dates, limitations, and the split
between verified facts and reasoned inference.

## Repository structure

```text
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
```

Every starter is an independent Java file with:

- one public class whose name matches the filename;
- no package declaration or dependency;
- the required method signature and a marked `TODO`;
- a runnable `main` method;
- at least five test cases;
- explicit expected values and `TODO` output until implemented.

Starters intentionally do not contain completed algorithms. Their harnesses
compile and run, but report each case as not implemented until you replace the
`UnsupportedOperationException`.

## Ranked problem list

Solution files are locked initially and will be added beside the starter after
your attempt.

| Rank | Problem | Category | Difficulty | Probability | Evidence | Starter | Solution |
|---:|---|---|---|---|---|---|---|
| 01 | Top Error-Producing Services | Must | Medium | High | Representative | [Starter](must-practise/P01_TopErrorProducingServices_Starter.java) | Locked |
| 02 | Excessive Requests in a Window | Must | Medium | High | Recurring | [Starter](must-practise/P02_ExcessiveRequestsInWindow_Starter.java) | Locked |
| 03 | Merge Outage Intervals | Must | Medium | High | Recurring | [Starter](must-practise/P03_MergeOutageIntervals_Starter.java) | Locked |
| 04 | Schedule Jobs Across Workers | Must | Medium | High | Representative | [Starter](must-practise/P04_ScheduleJobsAcrossWorkers_Starter.java) | Locked |
| 05 | Detect Cyclic Dependencies | Must | Medium | High | Recurring | [Starter](must-practise/P05_DetectCyclicDependencies_Starter.java) | Locked |
| 06 | Unavailable Transitive Dependencies | Must | Medium | High | Recurring | [Starter](must-practise/P06_UnavailableTransitiveDependencies_Starter.java) | Locked |
| 07 | Deduplicate Retried Events | Must | Medium | High | Recurring | [Starter](must-practise/P07_DeduplicateRetriedEvents_Starter.java) | Locked |
| 08 | Health-Check Stream Processor | Must | Medium | High | Recurring | [Starter](must-practise/P08_HealthCheckStreamProcessor_Starter.java) | Locked |
| 09 | Aggregate Metrics by Window | Must | Medium | High | Representative | [Starter](must-practise/P09_AggregateMetricsByWindow_Starter.java) | Locked |
| 10 | First Threshold Breach | Must | Medium | High | Representative | [Starter](must-practise/P10_FirstThresholdBreach_Starter.java) | Locked |
| 11 | Normalise File Path | Must | Medium | High | Recurring | [Starter](must-practise/P11_NormalizeFilePath_Starter.java) | Locked |
| 12 | LRU Cache | Must | Medium | High | Recurring | [Starter](must-practise/P12_LruCache_Starter.java) | Locked |
| 13 | Top-K Frequent Events | Must | Medium | High | Recurring | [Starter](must-practise/P13_TopKFrequentEvents_Starter.java) | Locked |
| 14 | Dependency Impact Traversal | Must | Medium | High | Recurring | [Starter](must-practise/P14_DependencyImpactTraversal_Starter.java) | Locked |
| 15 | Token-Bucket Rate Limiter | Must | Medium | High | Representative | [Starter](must-practise/P15_TokenBucketRateLimiter_Starter.java) | Locked |
| 16 | Merge Sorted Log Streams | Recommended | Medium | High | Representative | [Starter](strongly-recommended/P16_MergeSortedLogStreams_Starter.java) | Locked |
| 17 | Maximum Concurrent Incidents | Recommended | Medium | High | Recurring | [Starter](strongly-recommended/P17_MaxConcurrentIncidents_Starter.java) | Locked |
| 18 | Longest Stable Metrics Window | Recommended | Medium | High | Recurring | [Starter](strongly-recommended/P18_LongestStableMetricsWindow_Starter.java) | Locked |
| 19 | Group Equivalent Log Templates | Recommended | Medium | Medium | Representative | [Starter](strongly-recommended/P19_GroupEquivalentLogTemplates_Starter.java) | Locked |
| 20 | Alert-Suppression Cooldown | Recommended | Medium | High | Representative | [Starter](strongly-recommended/P20_AlertSuppressionCooldown_Starter.java) | Locked |
| 21 | Shortest Dependency Path | Recommended | Medium | High | Recurring | [Starter](strongly-recommended/P21_ShortestDependencyPath_Starter.java) | Locked |
| 22 | Deployment Order | Recommended | Medium | High | Recurring | [Starter](strongly-recommended/P22_DeploymentOrder_Starter.java) | Locked |
| 23 | Service Clusters with Union-Find | Recommended | Medium | Medium | Representative | [Starter](strongly-recommended/P23_ServiceClusterUnionFind_Starter.java) | Locked |
| 24 | Prefix Configuration Lookup | Recommended | Medium | Medium | Representative | [Starter](strongly-recommended/P24_PrefixConfigLookup_Starter.java) | Locked |
| 25 | Largest Failure Region | Recommended | Medium | Medium | Recurring | [Starter](strongly-recommended/P25_LargestFailureRegion_Starter.java) | Locked |
| 26 | Search Rotated Timestamp Array | Recommended | Medium | Medium | Recurring | [Starter](strongly-recommended/P26_SearchRotatedTimestampArray_Starter.java) | Locked |
| 27 | Weighted Job Scheduling | Recommended | Hard | Medium | Representative | [Starter](strongly-recommended/P27_WeightedJobScheduling_Starter.java) | Locked |
| 28 | Minimum Worker Capacity | Recommended | Medium | Medium | Recurring | [Starter](strongly-recommended/P28_MinimumWorkerCapacity_Starter.java) | Locked |
| 29 | Bounded Event Buffer | Recommended | Medium | Medium | Representative | [Starter](strongly-recommended/P29_BoundedEventBuffer_Starter.java) | Locked |
| 30 | Parse Key-Value Logs | Recommended | Medium | High | Recurring | [Starter](strongly-recommended/P30_ParseKeyValueLogs_Starter.java) | Locked |
| 31 | First Unique Event | Additional | Easy | Medium | Recurring | [Starter](additional-practice/P31_FirstUniqueEvent_Starter.java) | Locked |
| 32 | Sparse Metric Matrix | Additional | Medium | Lower | Representative | [Starter](additional-practice/P32_SparseMetricMatrix_Starter.java) | Locked |
| 33 | Maintenance-Window Combinations | Additional | Medium | Lower | Representative | [Starter](additional-practice/P33_MaintenanceWindowCombinations_Starter.java) | Locked |
| 34 | Minimum Restart Cost | Additional | Medium | Lower | Representative | [Starter](additional-practice/P34_MinimumRestartCost_Starter.java) | Locked |
| 35 | Process-Tree Traversal | Additional | Easy | Medium | Recurring | [Starter](additional-practice/P35_ProcessTreeTraversal_Starter.java) | Locked |
| 36 | Serialise Process Tree | Additional | Medium | Lower | Representative | [Starter](additional-practice/P36_SerializeProcessTree_Starter.java) | Locked |
| 37 | Flood-Fill Network Zone | Additional | Medium | Medium | Recurring | [Starter](additional-practice/P37_FloodFillNetworkZone_Starter.java) | Locked |
| 38 | K Closest Datacentres | Additional | Medium | Medium | Recurring | [Starter](additional-practice/P38_KClosestDatacenters_Starter.java) | Locked |
| 39 | Streaming Median Latency | Additional | Hard | Lower | Recurring | [Starter](additional-practice/P39_StreamingMedianLatency_Starter.java) | Locked |
| 40 | Weighted Dependency Path | Additional | Medium | Medium | Recurring | [Starter](additional-practice/P40_WeightedDependencyPath_Starter.java) | Locked |

## Recommended order

1. P01–P03: parsing, maps, windows, and intervals.
2. P05–P07 and P14: dependency graphs, cycles, reachability, and deduplication.
3. P04, P08–P10, P13, P15: heaps, streams, metrics, and rate limiting.
4. P11–P12: practical path processing and data-structure implementation.
5. P16–P30 based on the dated [schedule](schedule.md).
6. P31–P40 only after the Must set is stable under time pressure.

## IntelliJ IDEA

1. Clone the repository and open its root as a project.
2. Configure Project SDK **Java 17**.
3. Open any starter file.
4. Run its `main` method directly.
5. Replace the marked `TODO` only in your working branch.

No Maven or Gradle import is required because every file is independent.

## Terminal usage

```bash
cd must-practise
javac P01_TopErrorProducingServices_Starter.java
java P01_TopErrorProducingServices_Starter
```

Java 17 source-file mode can compile and run in one command:

```bash
java P01_TopErrorProducingServices_Starter.java
```

Compile every starter:

```bash
find . -name '*_Starter.java' -print0 | xargs -0 -n1 javac
```

Remove generated class files afterwards:

```bash
find . -name '*.class' -delete
```

## Interactive practice workflow

1. Open [FIRST-PROBLEM.md](FIRST-PROBLEM.md).
2. Clarify the contract before editing the starter.
3. Explain the straightforward and improved approaches.
4. Implement and share the attempted file or commit.
5. Receive review on correctness, complexity, edge cases, Java quality,
   testing, and communication.
6. Request incremental hints if blocked.
7. Say `show solution` only when ready; the completed file will then be added
   without overwriting the attempted version.

Use [progress.md](progress.md) after every attempt and [checklist.md](checklist.md)
during timed mocks.
