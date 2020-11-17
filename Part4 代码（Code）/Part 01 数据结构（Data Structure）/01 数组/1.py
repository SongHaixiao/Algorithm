class GenericArray():

    # constructor
    def __init__(self, capacity=10):
        self.__data = [None] * capacity  # store elements to list
        self.__count = 0

    # get the array capacity
    def getCapacity(self) -> int:
        return len(self.__data)

    # get the number of elements in array
    def getCount(self) -> int:
        return self.__count

    # determine if array is empty
    def isEmpty(self) -> bool:
        return self.__count == 0

    # change the element of index
    def set(self, index: int, e):
        if index < 0 and index >= len(self.__data):
            print("Index is invalid !!! Require index index >= 0 and index < size.")
            return
        self.__data[index] = e

    # get the target data of index
    def get(self, index: int):
        if index < 0 and index >= len(self.__data):
            print("Index is invalid !!! Require index index >= 0 and index < size.")
            return
        return self.__data[index]

    # find the target element
    # if find it, return its index
    # otherwise, return -1
    # Time - Complexity : O(n)
    def find(self, e) -> int:
        for i in range((len(self.__data))):
            if self.__data[i] == e:
                return i
        return -1

    # add data in target index
    # Time - Complexity : O(m + n)
    def add(self, index: int, e):

        if index < 0 and index > len(self.__data):
            print(
                "Add Faild!!! Index is invalid !!! Require index index >= 0 and index <= size.")
            return

        # determine the array is full
        # if full: expand size to 2 times of original
        # Time - Complexity: O(m)
        if self.__count == len(self.__data):
            self.resize(2 * len(self.__data))

        # moveing elements behind target index backward
        # Time - Complexity: O(n)
        i = self.__count - 1
        while i >= index:
            self.__data[i + 1] = self.__data[i]
            i -= 1

        self.__data[index] = e
        self.__count += 1

    # add data in head
    def addHead(self, e):
        self.add(0, e)

    # add data in tail
    def addTail(self, e):
        self.add(self.__count, e)

    # delete data of taget index
    # and return its value
    # Time - Complexity: O(m + n)
    def remove(self, index: int):
        if index < 0 and index >= len(self.__data):
            print(
                "Delete Faild!!! Index is invalid !!! Require index index >= 0 and index < size.")
            return

        ret = self.__data[index]  # store the value of deleting data

        # moving elements behind target index forward
        # Time - Complexity : O(m)
        i = index + 1
        while i < self.__count:
            self.__data[i-1] = self.__data[i]
            i += 1

        self.__count -= 1  # number - 1
        self.__data[self.__count] = None  # set the last element as None

        # when the number of elements meet the following coditions
        # reduce the capacity to a half of original size
        # Time - Complexity: O(n)
        if self.__count == len(self.__data)/4 and len(self.__data)/2 != 0:
            self.resize(len(self.__data)/2)

        return ret

    # delete data at head
    def removeHead(self):
        return self.remove(0)

    # delete data at Tail
    def removeTail(self):
        return self.remove(self.__count-1)

    # delete target element
    def removeElement(self, e):
        index = self.find(e)  # get the element's index

        # deter if teh index is valid
        if index != -1:
            self.remove(index)

    # change the capactity of array
    # Time - Complexity : O(n)
    def resize(self, capacity: int):

        # set a new array with new capacity
        newData = [None] * capacity

        # move the elements from original array data
        # to new array newData
        for i in range(self.__count):
            newData[i] = self.__data[i]

        self.__data = newData

    # print array
    def display(self):
        print("Array size = {0}, capacity = {1}".format(
            self.__count, len(self.__data)))
        print("[", end=' ')
        i = 0
        while i < self.__count:
            print(self.__data[i], end=' ')
            if i != self.__count - 1:
                print("", end=', ')
            i += 1
        print("]")


if __name__ == "__main__":

    array = GenericArray(10)
    array.addHead(0)
    array.addHead(0)
    array.add(1, 5)
    array.add(3, 9)
    array.add(3, 10)
    array.add(3, 11)
    array.addTail(20)

    array.display()

    array.removeHead()
    array.removeTail()
    array.removeElement(3)
    array.removeElement(11)

    array.display()

    array.remove(3)

    array.display()
