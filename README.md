# "Some Bug Reports Considered Poor" Considered Poorly: An Empirical Study on Query Construction Practices in IR-based Bug Localization

**Mohammad Masudur Rahman, Shamima Yeasmin, Chanchal K. Roy**


## Abstract

Being light-weight and cost-effective, IR-based bug localization approaches have shown promise in localizing software bugs. However, the accuracy of such approaches is largely dependent on the quality of the bug reports they are based on. Existing studies show that IR-based approaches cannot perform well with poor quality bug reports, in particular where there is a lack of program elements (a.k.a., bug localization hints). On the other hand, there is a recent evidence that shows that even the poor bug reports contain enough search keywords  that could localize the bugs successfully. Such potentially contradictory findings suggest that poor bug reports might not be really poor, and cast a serious doubt on the query selection practices in the IR-based bug localization. In this article, we attempted to clear the sky on this aspect by conducting an in-depth empirical study that critically examines the state-of-the-art query selection practices in IR-based bug localization. In particular, we use a dataset of over 1.5K poor quality bug reports, employ 10 existing approaches from the literature, exploit Genetic Algorithm-based approach to construct optimal search queries from the poor bug reports, and then answer three research questions. We confirmed that the state-of-the-art query construction approaches are indeed not sufficient for constructing appropriate search queries for bug localization from the poor quality bug reports. However, such poor quality bug reports indeed contain high quality search keywords in their texts even though they might not contain the explicit bug localization hints. We further confirmed that optimal queries from poor bug reports are very different than the ones delivered by the state-of-the-art approaches in terms of several qualitative aspects (e.g., part of speech, position within a bug report, similarity with ground truth) indicating further potential for improvements.


# Replication Package

Bug Reports, Ground Truth & Corpus
--------------------------------------
- **```BugID:```** contains the IDs of the bug reports used for experiments.
- **```BugReports:```** contains the raw bug report texts. Each report contains the title (first line) and description texts.
- **```Corpus:```** contains the source code mapping files needed for evaluation.
- **```Lucene:```** contains the corpus index created by Lucene 6.2.0
- **```GroundTruth:```** contains the source code files that were changed to fix the reported bugs.

Query Evaluation Module
-----------------------------
- **```QueryEvaluatorModule:```** contains the [**source code**](https://github.com/masud-technope/EMSE-2019-Replication-Package/tree/master/QueryEvaluatorModule) for reproducing the experimental results reported in the paper.

Search Queries for IR-based Bug Localization
---------------------------------------------
- **```Baseline:```** contains the baseline queries and their QE measures.

**Frequency-based Query Selection Methods**
- **```TF:```** contains the queries and their QE measures.
- **```IDF:```** contains the queries and their QE measures.
- **```TF-IDF:```** contains the queries and their QE measures.
- **```Kevic:```** contains the queries and their QE measures.
- **```Kevic:```** contains the queries and their QE measures.
- **```Rocchio:```** contains the queries and their QE measures.
- **```RSV:```** contains the queries and their QE measures.
- **```Dice:```** contains the queries and their QE measures.
- **```SCP:```** contains the queries and their QE measures.

**Graph-based Query Selection Methods**
- **```STRICT:```** contains the queries and their QE measures.
- **```ACER:```** contains the queries and their QE measures.

**Genetic Algorithm-based Optimal Queries**
- **```Optimal-GA:```** contains the queries and their QE measures.



Something not working as expected?
------------------------------------------------------------------------
Contact: **Masud Rahman** (masud.rahman@usask.ca)

OR

Create an issue from [here](https://github.com/masud-technope/EMSE-2019-Replication-Package/issues/new)




