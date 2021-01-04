library(aod)

data=read.csv(file="../Optimal-Non-Optimal-Classification/Optimal-vs-non-optimal-all.csv", header=TRUE)
data$classlabel=as.factor(data$classlabel)
mylogit = glm(formula = classlabel ~ medianTF + medianTermEntropy + bodyKeywordRatio + nounRatio, data=data, 
              family = "binomial"(link="logit"))

print(table(mylogit$y))
print(summary(mylogit))

#print(exp(coef(mylogit)))
#print(confint(mylogit))


