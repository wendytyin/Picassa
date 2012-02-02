README.txt for Picassa part 1.1 (refactoring)

Name: Wendy Yin wty3
Dates: sporadic between Jan 19-Jan 25 2011
Estimated time: no idea, never had that much experience
Total time taken: forever (maybe a total of 7 hours), and I still think I could do a bit more.

Consulted:
my UTA
Professor Hewner (office hours)
RevisedRoulette thing we did in class.

Tested with: ParserTest, same comparison against online images as before.

Comments:
Apparently you can't have a static method that inherits from an abstract one. 
It was more painful than I thought it would be trying to think in an OOP way. My brain keeps on 
wanting to do something more functional. I think the strain might have made me just a little wacky (see GuideToExpressions.txt).
The first few subclasses of Expression were the hardest to write. After that it was copy and paste, 
change a few symbols. I guess that's the beauty of OOP.
I'm fully aware that I may have fallen into some of the "Bad smells" in the attempt to become "open/closed".
For example, the Parser still seems lacking (there's even a comment in there about it), 
and I actually rewrote Expression twice (first time I didn't realize we were supposed to include 
parsing abilities into the expression classes), resulting in some tangled names 
(the same string is called command in one place, myInput in another, input in another, etc.).
