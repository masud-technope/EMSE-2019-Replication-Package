
library(cvTools)
library(randomForest)
library(e1071)
library(caret)
library(DMwR)

# reading the data
data=read.csv(file="../Optimal-Non-Optimal-Classification/Optimal-vs-non-optimal-all.csv", header=TRUE)

#adding a new random column
data$newrow <- sample(100, size = nrow(data), replace = TRUE)

sampled_data=data[sample(nrow(data),nrow(data)),]

total_rows=nrow(sampled_data)
number_of_folds=10


#initialize the performance measures
sumAcc=0
sumPosPrec=0
sumPosRec=0
sumNegPrec=0
sumNegRec=0
sumImp=0


#creating the folds
folds <- cvFolds(NROW(sampled_data), K=number_of_folds)


#loop through the folds
for (k in 1:number_of_folds){
  
  data_train=sampled_data[folds$subsets[folds$which!=k],]
  data_test=sampled_data[folds$subsets[folds$which==k],]
  
  #train the model
  fit <- randomForest(as.factor(classlabel) ~ ., data=data_train, importance=TRUE, ntree=2000)
  
  #calculate the importance
  imp=importance(fit)
  sumImp =sumImp + imp

  print(c("Done",k))
  
}

#showing average feature importance
myImp=sumImp/number_of_folds
print(myImp)







