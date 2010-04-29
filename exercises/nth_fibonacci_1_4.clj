(defn nth-fib [n]
	(Math/round 
		(/ (Math/pow (/ (+ 1 (Math/sqrt 5)) 2) n) (Math/sqrt 5))))
		
(def cached-nth-fib (memoize nth-fib))