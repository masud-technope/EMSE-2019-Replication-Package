
library(cvTools)
library(randomForest)
library(e1071)
library(caret)
library(DMwR)

# reading the data
data=read.csv(file="data-rq3/ext-data/all-dataset-opt-non-opt.csv", header=TRUE)

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
  
  # print(nrow(data_train))
  # print(nrow(data_test))
  print("Before sampling ...")
  print(table(data_train$classlabel))
  
  #HQ-NH=perc.over=140
  #HQ-WH=no-sampling
  #LQ=perc.over=175
  
  #do the sampling
  data_train=SMOTE(classlabel~., data_train, perc.over = 175, K=5)
  
  print("After sampling ...")
  print(table(data_train$classlabel))
  
  
  #train the model
  fit <- randomForest(as.factor(classlabel) ~ ., data=data_train, importance=TRUE, ntree=2000)
  
  #calculate the importance
  imp=importance(fit)
  sumImp =sumImp + imp
  
  #prediction model
  Prediction <- predict(fit, data_test)
  
  
  #calculate accuracy
  cm=confusionMatrix(data=Prediction,
                     reference=data_test$classlabel,
                     positive='opt')
  
  
  #store the results
  #accumulating performance data from each run
  sumAcc = sumAcc+  cm$overall['Accuracy']
  sumPosPrec=sumPosPrec+ cm$byClass['Pos Pred Value']
  sumPosRec=sumPosRec + cm$byClass['Sensitivity']
  sumNegPrec=sumNegPrec + cm$byClass['Neg Pred Value']
  sumNegRec=sumNegRec + cm$byClass['Specificity']
  
  print(c("Done",k))
  
}

#showing average performance for 10 runs
print(sumPosPrec/number_of_folds)
print(sumPosRec/number_of_folds)
print(sumNegPrec/number_of_folds)
print(sumNegRec/number_of_folds)
print(sumAcc/number_of_folds)

#showing average feature importance
myImp=sumImp/number_of_folds
print(myImp)







