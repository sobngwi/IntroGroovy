// Collections
//1-Range
Range range = 1..10
println (range) 
range.from
range.to
range.contains(2)
assert range.contains(1) && range.contains(10)
range = 1..<10
assert range.contains(1) && range.contains(9)

// ist
nums = [1,2,4,5,6,7,8,9]
assert nums.class.name == 'java.util.ArrayList'
assert nums.drop(3) == [5, 6, 7, 8, 9]
nums = nums + [100,[1000,10001,1002],101,102]
assert [1, 2, 4, 5, 6, 7, 8, 9, 100, 1000, 10001, 1002, 101, 102] == nums.flatten() // remove internal structure and produces a new one.
println nums*2
//nums[-3,-1] bizarre
assert nums[-2,-1] == [101,102]
assert [1, 2, 4, 5, 6, 7, 8, 9, 100, [1000, 10001, 1002], 101, 102, [4, 5]] == nums << [4,5] // append to the original list and return the same list.
LinkedList ll = [1,2,4,5,6,7,8,9]
assert ll.class.name ==  'java.util.LinkedList'
def set =  [2,1,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9] as SortedSet
assert set.class.name ==  'java.util.TreeSet'
assert set.size() == 9 // duplicate are remove
assert set[0] == 1 // set have been sorted.
// MAPS:
def map = [a:1,b:2,'c':3]
map.put('d',4)
map['e'] = 1
map.f = 5 // . operator
println map
assert map.getClass().name == 'java.util.LinkedHashMap' // . operator already exist then cant be replace

// convert an array to a list
def strings = 'This is a list of strings'.split()
assert strings.class.name == '[Ljava.lang.String;'
strings =  'This is a list of strings'.split() as ArrayList
assert strings.class.name == 'java.util.ArrayList'

// Generics
List<Integer> ints = [1,2,3,'alain','narcisse'] // bizarre Compile OK, but it is up to the dev to enforce the type verification.
ints << new Date()
assert ints.class.name == 'java.util.ArrayList'
def zero = ints[0]
assert zero == 1
def alain = ints[3]
assert alain == 'alain'
assert ints[5].class.name == 'java.util.Date'