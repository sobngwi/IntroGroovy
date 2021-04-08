// each operator returns a collection
nums = [ 3,5,9,1,5]
nums.each {
println it * 2
}
nums.each {
 n -> n * 2
}
nums.eachWithIndex {
 n, index -> n * 2
 println "index: $index , $n "
}
numsDouble = []
nums.each {
 n ->  numsDouble << (n * 2) // illegal in java not effectively final
}
assert numsDouble == [ 6,10,18,2,10]
nums.collect {
 n ->  numsDouble << (n * 2) 
}
// Lambda on Groovy
assert [6,18] ==
nums.collect { n -> n * 2 }
    .findAll { it % 3 == 0 } // filter, no notion of terminal operator.
    assert 24 ==
nums.collect { n -> n * 2 } // collectParallel , findAllParallel GPURSE library/
    .findAll { it % 3 == 0 } // filter, no notion of terminal operator.
    .sum() // reduce method
// * srpread on each element rather that the collection at all 
assert 46 ==    
nums*.multiply(2)
     .sum()
     assert 5 ==    
nums*.mod(3)
     .sum()
        
  
assert numsDouble == [ 6,10,18,2,10, 6, 10, 18,2,10]
def map = [a:1,b:2,'c':3]
map.put('d',4)
map['e'] = 1
map.f = 5 // . operator
map.each /* each of map */{ k,v -> println "key: $k, value: $v" }
assert map.collect { k,v -> "$k=$v"}.join('&') == 'a=1&b=2&c=3&d=4&e=1&f=5' // Map of k,v transform Query string for a rest web service


/* If you have a method wich last parameter is a closure, the the groovy idiom is to 
put the closure afetr the paranthesis */
10.downto(7){ printf "%d ", it }
println ""
10.downto 7, { printf "%d ", it } // optional parenthesis
println ""
10.downto(7, { printf "%d ", it }) // Java Accent

// GET REQUEST 
'https://oreilly.com'.toURL().text
String base = 'https://maps.googleapis.com/maps/api/geocode/xml?'
def encoded = ['10 Fawcett Street', 'Cambridge', 'MA'].collect {
 URLEncoder.encode(it,'UTF-8')
}.join(',')
def queryString = "address=$encoded"
"$base$queryString".toURL().text
// XmlSluper parse the DOM tree.
//root = new XmlSluper().parse("base$queryString")
//loc = root.result[0].geometry.location
// println "(${loc.lat}, $loc.lng})"

// JSON
base = 'http://api.icndb.com/jokes/random?'
qs = [limitTo:'[nerdy]', firstName:'Guillaume', lastName:'Laforge']
qs.getClass().name
qs = qs.collect {k,v -> "$k=$v" }.join('&')
jsonText = "$base$qs".toURL().text

json = new groovy.json.JsonSlurper().parseText(jsonText)
json.value.joke