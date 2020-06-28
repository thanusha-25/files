'''
Created on 13-Jun-2020

@author: thanusha
'''

path=input("enter the path: ")
path_split=path.split("\\")
final=''
path_split.pop(0)
# for i in range(len(path_split)):
for i in path_split:
        final =final+i+"."
print(final)