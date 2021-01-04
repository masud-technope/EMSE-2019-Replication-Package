# The Forgotten Role of Search Queries in IR-based Bug Localization: An Empirical Study

**Mohammad Masudur Rahman, Foutse Khomh, Shamima Yeasmin, and Chanchal K. Roy**


## Abstract

Being light-weight and cost-effective, IR-based bug localization approaches have shown promise in localizing software bugs. However, the accuracy of these approaches is largely dependent on the quality of the bug reports that they are based on. A significant number of the bug reports contain only plain natural language texts and no hints for the localization (e.g., program elements). Several existing studies show that IR-based approaches cannot perform well when these bug reports are used as search queries. On the other hand, there is a piece of recent evidence that suggests that even these natural language-only reports contain enough good keywords that could help localize their bugs successfully. Such potentially contradictory findings suggest that natural language-only bug reports might not be really poor after all. These findings also cast serious doubt on the query selection practices in the IR-based bug localization. In this article, we attempted to clear the sky on this aspect by conducting an in-depth empirical study that critically examines the state-of-the-art query selection practices in IR-based bug localization. In particular, we use a dataset of 2,320 bug reports, employ ten existing approaches from the literature, exploit the Genetic Algorithm-based approach to construct near-optimal search queries from these bug reports, and then answer three research questions. We confirmed that the state-of-the-art query construction approaches are indeed not sufficient for constructing appropriate search queries (for bug localization) from the natural language-only bug reports. However, these bug reports indeed contain high-quality search keywords in their texts even though they might not contain explicit hints for bug localization. We also demonstrate that near-optimal queries and non-optimal queries constructed from the bug report texts are significantly different in terms of several traditional measures (e.g., frequency, entropy, position within a bug report), which provides actionable insights. Furthermore, we demonstrate 10%--25% performance improvement in the non-optimal search queries by leveraging such actionable insights.


# Replication Package

Bug Reports, Ground Truth & Corpus
--------------------------------------
- **```BugID:```** contains the IDs of the bug reports used for experiments. It also contains the four clusters of bug reports.
  - **```HQ-NH:```** 567 bug reports leading to high-quality baseline queries (i.e., 1<=QE<=10) with no localization hints. 
  - **```HQ-WH:```** 954 bug reports leading to high-quality baseline queries (i.e., 1<=QE<=10) with localization hints (e.g., stack traces, method invocations).
  - **```LQ-NH:```** 372 bug reports leading to poor baseline queries (i.e., QE>10) with no localization hints.
  - **```LQ-WH:```** 427 bug reports leading to poor baseline queries (i.e., QE>10) with localization hints (e.g., stack traces).
- **```BugReports:```** contains the raw bug report texts. Each report contains the title (first line) and description texts.
- **```Corpus:```** contains the source code mapping files needed for evaluation.
  - **```class:```** contains the source code files from each subject system.
  - **```norm-class```** contains the normalized version of the source code.
  - **```[system-name].ckeys```** contains the source file-index mapping.
- **```Lucene:```** contains the corpus index created by Lucene 6.2.0
- **```GroundTruth:```** contains the source code files that were changed to fix the reported bugs.
- **```Extra-DS:```** contains the dataset used for testing external validity of our findings.

Query Evaluation Module
-----------------------------
- **```QueryEvaluatorModule:```** contains the [**source code**](https://github.com/masud-technope/EMSE-2019-Replication-Package/tree/master/QueryEvaluatorModule) for reproducing the experimental results reported in the paper. It also includes the implementation of 10 existing approaches (TF, IDF, TF-IDF, Kevic and Fritz, STRICT, Rocchio, RSV, Dice, SCP, ACER) and NrOptimal-GA used in the paper.

Search Queries for IR-based Bug Localization
---------------------------------------------
- **```Baseline:```** contains the baseline queries and their QE measures.
  - **```Baseline:```** pre-processed version of title and description from the bug report.
  - **```Baseline-I:```** pre-processed version of title from the bug report.
  - **```Baseline-II:```** pre-processed version of description from the bug report.

**Frequency-based Query Selection Methods**
- **```TF:```** contains the queries and their QE measures.
- **```IDF:```** contains the queries and their QE measures.
- **```TF-IDF:```** contains the queries and their QE measures.
- **```Kevic:```** contains the queries and their QE measures.
- **```Rocchio:```** contains the queries and their QE measures.
- **```RSV:```** contains the queries and their QE measures.
- **```Dice:```** contains the queries and their QE measures.
- **```SCP:```** contains the queries and their QE measures.

**Graph-based Query Selection Methods**
- **```STRICT:```** contains the queries and their QE measures.
- **```ACER:```** contains the queries and their QE measures.

**Genetic Algorithm-based Near-Optimal Queries**
- **```NrOptimal-GA:```** contains the near-optimal queries from 2,320 bug reports and their QE measures.

**Optimal vs. Non-Optimal Query Comparison**
- **```Optimal-vs-Non-Optimal:```** contains the machine learning models (e.g., CSV, ARFF, R-code) trained on optimal, near-optimal and non-optimal queries.
  - **```Optimal-vs-Non-Optimal:```** contains the classification models for optimal and non-optimal queries.
  - **```Near-Optimal-vs-Non-Optimal:```** contains the classification models for near-optimal and non-optimal queries.
  - **```Query-Metric:```** contains 31 metrics calculated for each of the ~14K queries (5.5K near-optimal + 8.3K non-optimal).
  - **```Feature-Importance```** contains the feature importance of search queries learned by the machine learning models.
  - **```Revised-Query-using-Insights:```** contains reformulated/expanded queries after applying the learned insights.
- **```RQ3-GT-Artifact```** contains the artifacts produced from our Grounded Theory-based analysis with 120 low-quality bug reports. 


Something not working as expected?
------------------------------------------------------------------------
Contact: **Masud Rahman** (masud.rahman@usask.ca)

OR

Create an issue from [here](https://github.com/masud-technope/EMSE-2019-Replication-Package/issues/new)




