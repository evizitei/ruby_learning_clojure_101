(1 2 3)
;; ->java.lang.ClassCastException: java.lang.Integer cannot be cast to clojure.lang.IFn (NO_SOURCE_FILE:0)
'(1 2 3)
;; ->(1 2 3)

(comment "Why? the form with a single tick is, I believe, a way to represent data." 
	     "That is, the quote prevents the list from being evaluated as code. "
	     "When you execute the error generating statement with (1 2 3), you're attempting to call the function '1' with the arguments 2 and 3,"
	     "which is not going to fly as the error message indicates."
	     "The message ('java.lang.ClassCastException: java.lang.Integer cannot be cast to clojure.lang.IFn (NO_SOURCE_FILE:0)') "
	     "could be summarized as saying: 'I'm trying to use this '1' thing as a function, but you gave me an integer instead, "
	     "and I don't have a way to cast from one to the other...sorry...'")