import numpy as np 
# 准备数据
num=10
pred_prob = list(np.random.uniform(low=0,high=1, size=[num]))
labels = [int(prob>0.5) for prob in list(np.random.uniform(low=0,high=1, size=[num]))]

def auc(labels,logits):
    pos=sum(labels)
    neg=len(labels)-pos 
    total = pos*neg 
    new_zip = list(zip(logits,labels))
    new_zip.sort(key=lambda x:x[0])
    rank_pos=0
    for index,(lo,la) in enumerate(new_zip):
        if la==1:
            rank_pos+=index+1
    auc = (rank_pos-pos*(pos+1)/2)/(pos*neg)
    return auc 
print(auc(labels,pred_prob))