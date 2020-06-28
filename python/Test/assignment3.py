'''
Created on 17-Jun-2020

@author: thanusha
'''

phonebook ={
            "rohan":{"phonenumber":9160617766,"address":"Hyd","dept":"CSE"},
            "Rahul":{"phonenumber":1234567890,"address":"NZB","dept":"ECE"},
            "Thanvi":{"phonenumber":2345678901,"address":"WRGL","dept":"MECH"}
            }

name=input("enter name :")
choice = input("enter p for phonenumber a for address d for dept : ")
if(choice=="p") :
    res="phonenumber"
elif(choice=="a"):
    res="address"
elif(choice=="d"):
    res="dept"
print(phonebook.get(name).get(res))