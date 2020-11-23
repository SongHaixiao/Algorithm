# -*- coding: UTF-8 -*-

'''
Note :
       python list insert method can add capacity for list automatically
       so use the self.__size to record the capacity
'''


class Array():

    def __init__(self, capacity: int):
        '''constructor'''
        self.__data = []      # store elements in data list
        self.__count = 0      # record the number of elements in current array
        self.__size = capacity  # record the capacity of array

    def find(self, index: int):
        '''
        Function :
                    find the element of index.

                    if find it, return elements
                    else return False.
         Parameter：
                    index : the index want to find
        '''
        if index > self.__count or index < 0:
            print("Find failed. Index invalid.")
            return False
        else:
            return self.__data[index]

    def delete(self, index: int):
        '''
        Function :
                    delete the element of index.

                    if deletion is success, return True
                    else return False.

        Parameter :

                    index : the index want to delete
        '''
        if index > self.__count or index < 0:
            print("Delete failed. Index invalid.")
            return False
        else:
            self.__data.pop(index)
            self.__count -= 1
            return True

    def insert(self, index: int, value: int):
        '''
        Function :

                    insert the element value in index.
        Parameter :

                    index : the index want to insert

                    value : the element want to insert
        '''
        if index > self.__count or index < 0:
            print("Insert failed. Index invalid.")
            return False

        elif self.__count == self.__size:
            print("Array is full.")
            return False
        else:
            self.__data.insert(index, value)
            self.__count += 1
            return True

    def insertToTail(self, value: int):
        '''
        Function :
                    insert the element in tail.
        Parameter :
                    value : the elemnt want to insert
        '''
        if self.__count == self.__size:
            print("Array is full.")
            return False
        else:
            self.__data.append(value)
            self.__count += 1
            return True

    def printAll(self):
        '''
        Function :
                    print all elements in array.

                    via list format.
        '''
        print(end='[')
        count = 0
        for e in self.__data:
            if e is not None:
                print(e, end='')
                count += 1
            if count != self.__count and e is not None:
                print(end=',')
        print(end=']\n')


if __name__ == "__main__":
    array = Array(5)
    # array.printAll()
    array.insert(0, 3)
    array.insert(0, 4)
    array.insert(1, 5)
    array.insert(3, 9)
    array.insert(3, 10)
    array.printAll()
    # array.insert(3, 11) # Array is full
    array.printAll()
