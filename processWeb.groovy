//'http://www.google.com'.toURL().text.eachLine { println it }
//'http://www.google.com'.toURL().eachLine { println it }
//'http://google.com'.toURL().text.readLines()
//'http://www.google.com'.toURL().text.eachLine { println it }
'http://google.com'.toURL().text.readLines()*.size()