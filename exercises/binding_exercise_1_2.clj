(def x 1)
(def y 1)
(let [x 5 y x] y)     
(binding [x 5 y x] y)

(comment "Hmmm...my first guess was that both printed values would end up being 5, reasoning thus:" 
         "'let' and 'binding' both bind a value to a symbol, it's just that 'let' does so for the within it's form "
         "(only within it's parentheses) and 'binding' does so for within it's parentheses AND within any function called from within the parentheses (thread-local). "
         "So, since x is bound to 5 in both cases just before y is bound to the value of x, I figured they would both be consistent."
         "Imagine my surprise to find it was actually '5' for the 'let' form and '1' for the 'binding' form."
         "It was only after reading a corrective post from Paul Berry on another students response thread that I"
         "understood that the values were assigned sequentially for 'let' (so first in line gets evaluated first)" 
         "and in parallel for 'binding' ( so each gets evaluated independently)."
         "Sorry for the length of the post, this is all rehashing what's been said, but writing it out helps me remember.")