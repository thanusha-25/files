'''
Created on 18-Jun-2020

@author: thanusha
'''


def mul (a,b):
    """
    >>> mul(3,2)
    6
    >>> mul(2,5)
    11
    """
    return a*b

if __name__== "__main__" :
    import doctest
    doctest.testmod(verbose=True, optionflags=doctest.NORMALIZE_WHITESPACE)
    