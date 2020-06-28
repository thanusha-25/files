'''
Created on 17-Jun-2020

@author: thanusha
'''


sentence=input ("enter string : ")
letter_count={}
for i in sentence :
    if(i not in letter_count):
        letter_count[i]=1
    else:
        letter_count[i]+=1
        
for i in letter_count:
    if(letter_count[i]==2):
        print(i)

