(defn method-one [& args] (apply println "Inside method #1 =>" args))
(defn method-two [& args] (apply println "Inside method #2 =>" args))
 
;; output for this should be "Inside method #2 => 1 2 3"
(binding [method-one method-two]
  (method-one 1 2 3))
 
;; output should be the defining of an anonymous function with four arguments (method-two,1,2,3)
;; WRONG!  Outpus was actually "inside method #1 => 1 2 3"
((binding [method-one method-two]
   #(method-one 1 2 3)))

(comment "I predicted the first result accurately, but for the second call I guess I had everything wrong."
	     "My expectation was that the second function would just be an anonymous function declaration,"
	     " and that no method would be called. Instead, the output was 'inside method #1 => 1 2 3'. "
	     "After readying Paul Barry's explanation and playing around in the REPL a bit,"
	     " I can see that the anonymous function was indeed defined, "
	     "but that the extra set of parentheses caused it to finally be evaluated, "
	     "and after the binding scope had expired.  Another lesson learned the hard way.")