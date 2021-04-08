//println InetAddress.localHost
//int x = 4
//int y = 3
//assert 9 == x + y + 2
def x = 1
println x.class.name
x = 'abc'
println x.class.name
x = new Date()
344444444444444.class.name
34.44444444444444444444444444.class.name
println 2.0d - 1.1d
println 2.0 - 1.1
// 05042021

(3.5).class.name
println 3/5
printf "decimal division by default %s" , 3/5
println 3.intdiv(5)
printf "--- %d\n", 3.intdiv(5)

println 2.0 - 1.1
println 2.0.minus(1.1)

//def
def s = 'this is a string ${ 1 + 1 }'
s.class.name
s.reverse()
s = "this is a string"
s.class.name
s = "this is a string $s"
s.class.name
s.class.name
s + " and more ${ 10 + 10 }"
s - 'string' - 'string'
def st = 'abc' * 3
st[-1]
st[0]
// range
st[0..3] // 4 characters
st[-3..-1]
st[-1 ..-3] // decreasing prervious, previous and previous
st ='this is a string'
st[0..3, 5..6, 10..-1] // write the string without spaces -- getAt method in the string.

// Multi line string and regex
def picard= '''\
Oh the vaccum outside is endless
Unforgiving, cold, and friendless
But still we mus boldly go
Make it so, make it so, make it so!
''' //without give 131 chacaters
picard.size()
picard.readLines().size() // 4 lines and 5 lines without the \
def zip = ~/\d{5}(-\d{4})?/
zip.class.name
assert '12345' ==~ zip
assert '12345, 56789-1234 1234'.findAll(zip) ==  ['12345', '56789-1234']

// palindrome check
def palindrome ='Flee to me, remote elf!'.toLowerCase().replaceAll(/\W/,'')
assert palindrome == palindrome.reverse()
assert ~/abcd/ instanceof java.util.regex.Pattern

// A lot of power from little code. POGOI instead of POJO

// AST abstract syntax tree
import groovy.transform.*
//@ToString(includeFields = true, includeNames =true, ignoreNulls =true)
//@EqualsAndHashCode
//@TupleConstructor // Argument from top to bottom

@Canonical // == @ToString + @EqualsAndHashCode + @TupleConstructor
class Person {
    String first
    String last
    Date dob = new Date()
  /*  void setLast(String last){
     println 'My Last::' + last
     assert last != null
     this.last = last
     }*/
   /* String toString() {
     "ToString: ${this.first} + $this.last" // implicit return of last instruction.
     }*/
 }
    
    p  = new Person()
    p.setFirst('Alain')
    p.last = 'Narcisse' // p.setLast
   println  p.first + ' ' +  p.getLast()
   p = new Person(last:'Narcisse')
   println "toString call "  + p.toString()
   println  p.first + ' ' +  p.getLast()
   an1 = new Person(first: 'Alain', last:'Narcisse')
   //sleep 1
   an2 = new Person(first: 'Alain', last:'Narcisse')
   an3 = new Person(first: 'Narcisse', last:'Alain')
   
  assert an1 == an2 // == invoke .equals method
  assert an1 != an3
  Set people = [an1, an2, an3]
  assert people.size() == 2
  // tuple constructor
  an4 = new Person ('Sagueu', 'SOBNGWI')
  an4