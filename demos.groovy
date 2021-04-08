strings = ['a', 'list', 'of', 'strings']
// Groovy  sort
assert strings.sort(false){ it.size() } == ['a', 'of', 'list', 'strings']
// Groovy  sort 2 params
assert strings.sort(false){ it.size() } == ['a', 'of', 'list', 'strings']
// groovy reverse length sort
assert strings.sort(false){ -it.size() } == ['strings', 'list','of', 'a']

strings = ['this', 'is', 'a', 'list', 'of', 'strings']
// groovy sort by length and then alphabetical ELVIS
assert strings.sort(false){ s1,s2 ->  s1.size() <=> s2.size() ?: s1 <=> s2} == ['a', 'is', 'of', 'list', 'this', 'strings']

nums = [ 10, 20, 30, 40, 50 ]
assert 300 == nums.collect { it * 2 }.sum()
// sum with spread dot  -- in groovy opreator correspond to a method
//operator overloading 
assert 300 == ( nums * 2).sum()
assert 300 == nums*.multiply(2).sum()
assert 300 == nums.sum() * 2 
assert 300 == nums.sum { it * 2 }
// inject metod ==> reduce of java
assert 300 == nums.inject ( /* initial accumulator */ 0 ) { acc, val -> 
 acc + ( val * 2 ) 
 }
 // Java Stream.
 assert 300 == nums
                  .stream()
                  .reduce( 0,(acc, val) -> acc + ( val * 2 ));