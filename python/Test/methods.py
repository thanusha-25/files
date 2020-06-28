'''
Created on 23-Jun-2020

@author: thanusha
'''
# class C :
# #     def __init__(self,msg):
# #         self.msg=msg
#     def set_name(self,msg) :
#         self.__msg= msg
#     def get_name(self) :
#         return self.__msg
# 
# c = C()
# c.set_name("hello")
# print(c.get_name())

'''
class C:
    def __init__(self):
        self.__name=''
    @property
    def name(self):
        return self.__name
    @name.setter
    def name(self,name):
        self.__name=name
    @property
    def show_details(self):
        return "{}{}".format(self.name," is smart")

co= C()
co.name="thanu"
print(co.name)
print(co.show_details)

'''

# inheritance
'''
class Person() :
    def __init__(self,firstName,lastName):
        self.fistName=firstName
        self.lastName=lastName
    def display(self):
        return "Name of employee is {} {}".format(self.fistName,self.lastName)

class Employee(Person):
    def __init__(self,firstName,lastName,empId,dept):
        Person.__init__(self,firstName, lastName)
        self.empId=empId
        self.dept=dept
    def display(self):
        print(super().display())
        return "id is {} and dept is {}".format(self.empId,self.dept)


e1=Employee("Thanu","Pola",103,"Technical")
print(e1.display())

'''

'''
class A :
    def printer(self,msg=None):
        if(msg== None):
            print("this is first one")
        else:
            self.msg=msg
            print ("msg is ", self.msg)
#     def printer(self,msg):
#         self.msg=msg
#         print("this is second with msg {}".format(self.msg))



a1=A()
a1.printer("hello ....")

'''
'''
class A :
    def m(self):
        print("A method")
class B(A) :
    def m(self):
        print("B method")
class C(A) :
    def m(self):
        print("C method")
        super().m()
class D(C,B):
    def m(self):
        print("D method")
        super().m()
d1=D()
d1.m()
'''

# dunder methods

class A :
    def __init__(self,x,y):
        self.x=x
        self.y=y
    def __str__(self):
        return self.x+" "+self.y
    def __repr__(self):
        return self.x+" "+self.y
a=A("4","hello")
print(repr(a))        
print("hello ".__len__())
print(int.__add__(3,7))
print(float.__add__(7.0,9.1))



